/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.wowza.main;

import fameplus.common.constants.PropertiesKey;
import fameplus.common.jdbc.dao.Service;
import fameplus.common.util.PropertiesUtil;
import fameplus.common.util.UtilityLogger;
import fameplus.wowza.jdbc.DBService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.jstl.sql.Result;

/**
 *
 * @author anil
 */
public class SMILGenerator {

    Service service;

    public SMILGenerator(DBService service) {
        this.service = (Service) service;
    }

    public void executeSMILgeneratorJob() {
        String script = "select a.id from event a, booked_channel_slot b, event_operations c where a.booked_channel_slot_id=b.id and a.status='READY' and a.id=c.event_id and c.issmilgenerated=false;";
        UtilityLogger.info(script);
        Result result = service.getData(script);
        int rowCount = result.getRowCount();
        Object[][] data = result.getRowsByIndex();
        for (int rowCounter = 0; rowCounter < rowCount; rowCounter++) {
            String eventId = "E0000000" + data[rowCounter][0];
            System.out.println("Generating SMIL for Event ::" + eventId);
            UtilityLogger.info("Generating SMIL for Event ::" + eventId);
            generateAndStoreSMIL(eventId);
            script = "update event_operations set issmilgenerated=true where event_id=" + data[rowCounter][0];
            service.updateData(script);
        }
    }

    private String generateSMIL(String filePrefix) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version='1.0' encoding='UTF-8'?>");
        stringBuffer.append("<smil title='smil file for adaptiveStreaming template'>");
        stringBuffer.append("	<body>");
        stringBuffer.append("		<switch>");
        stringBuffer.append("			<video height='160' src='" + filePrefix + "_160p' systemLanguage='eng' width='284'>");
        stringBuffer.append("				<param name='videoBitrate' value='200000' valuetype='data'></param>");
        stringBuffer.append("				<param name='audioBitrate' value='44100' valuetype='data'></param>");
        stringBuffer.append("			</video>");
        stringBuffer.append("			<video height='240' src='" + filePrefix + "_240p' systemLanguage='eng' width='426'>");
        stringBuffer.append("				<param name='videoBitrate' value='409600' valuetype='data'></param>");
        stringBuffer.append("				<param name='audioBitrate' value='44100' valuetype='data'></param>");
        stringBuffer.append("			</video>");
        stringBuffer.append("			<video height='360' src='" + filePrefix + "_360p' systemLanguage='eng' width='640'>");
        stringBuffer.append("				<param name='videoBitrate' value='768000' valuetype='data'></param>");
        stringBuffer.append("				<param name='audioBitrate' value='44100' valuetype='data'></param>");
        stringBuffer.append("			</video>");
        stringBuffer.append("			<video height='480' src='" + filePrefix + "_480p' systemLanguage='eng' width='854'>");
        stringBuffer.append("				<param name='videoBitrate' value='1024000' valuetype='data'></param>");
        stringBuffer.append("				<param name='audioBitrate' value='44100' valuetype='data'></param>");
        stringBuffer.append("			</video>");
        stringBuffer.append("			<video height='720' src='" + filePrefix + "_720p' systemLanguage='eng' width='1280'>");
        stringBuffer.append("				<param name='videoBitrate' value='2560000' valuetype='data'></param>");
        stringBuffer.append("				<param name='audioBitrate' value='44100' valuetype='data'></param>");
        stringBuffer.append("			</video>");
        stringBuffer.append("			<video height='1080' src='" + filePrefix + "_1080p' systemLanguage='eng' width='1920'>");
        stringBuffer.append("				<param name='videoBitrate' value='4608000' valuetype='data'></param>");
        stringBuffer.append("				<param name='audioBitrate' value='44100' valuetype='data'></param>");
        stringBuffer.append("			</video>");
        stringBuffer.append("		</switch>");
        stringBuffer.append("	</body>");
        stringBuffer.append("</smil>");
        return stringBuffer.toString();
    }

    private void generateAndStoreSMIL(String streamPrefix) {
        FileOutputStream fos = null;
        try {
            String contentPath = PropertiesUtil.fetchProperty(PropertiesKey.WOWZA_CONTENT_PATH);
            fos = new FileOutputStream(new File(contentPath + "/" + streamPrefix + ".smil"));
            String smilContent = generateSMIL(streamPrefix);
            fos.write(smilContent.getBytes());
            fos.flush();
        } catch (Exception ex) {
            UtilityLogger.debug("Exception occured in generateAndStoreSMIL():", ex);
            System.out.println("Exception occured in generateAndStoreSMIL():" + ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                UtilityLogger.debug("exception in generateAndStoreSMIL", ex);
                Logger.getLogger(SMILGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
