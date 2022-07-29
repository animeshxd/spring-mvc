TPID="$(ps -ef | awk '/[t]omcat/{print $2}')"

if  [ -z "$TOMCAT" ]; then
    echo "TOMCAT=/path/to/tomcat/ required " >&2
    exit -1
fi

mvn clean package -DskipTests -Dmaven.test.skip -Dmaven.artifact.threads=30

WAR="$(ls target/*.war | xargs -n 1 basename)"
if [ $? -ne 0 ]; then 
    echo ".war file not found in ./target directory" >&2
    exit -1
fi
rm $TOMCAT/webapps/${WAR%%.*}* -rf
cp target/$WAR $TOMCAT/webapps/
if ! [ $TPID -gt 0 ]; then
    $TOMCAT/bin/catalina.sh run
    exit 0
fi
echo "Deployed at http://localhost:8080/${WAR%%.*}"