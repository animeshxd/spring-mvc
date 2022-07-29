
if  [[ -z "$TOMCAT" ]]; then
    echo "TOMCAT=/path/to/tomcat/ required " >&2
    exit -1
fi

mvn clean package -DskipTests -Dmaven.test.skip -Dmaven.artifact.threads=30

WAR="$(ls target/*.war | xargs -n 1 basename)"
if [ $? != 0 ]; then 
    echo ".war file not found in ./target directory"
    exit -1
fi
rm $TOMCAT/webapps/${WAR%%.*}* -rf
cp target/$WAR $TOMCAT/webapps/

$TOMCAT/bin/catalina.sh stop &> /dev/null
$TOMCAT/bin/catalina.sh run
