#To debug script use bash -x with command prompt

export JAVA_PATH=""
export CLASS_PATH=".:./lib/jstl-1.2.jar:./lib/mysql-connector-java-5.1.34.jar:./lib/log4j-1.2.17.jar:./fameplusWowzaUtility.jar:"
export MAIN_CLASS="fameplus.wowza.main.Main"
java -classpath $CLASS_PATH $MAIN_CLASS
