CATALINA_HOME=/home/user/.local/opt/apache-tomcat-10.0.23/

[ -d $CATALINA_HOME ] || exit 5

if ! [ -d target ] || ! [ -d target/spring-mvc/ ]; then
    echo "running mvn package"
    mvn package
    echo "synchronizing..."
    cp -r target/spring-mvc $CATALINA_HOME/webapps/
else
    echo "synchronizing..."
    cp -r src/main/webapp/* target/spring-mvc/
    cp -r target/classes target/spring-mvc/WEB-INF/
    
fi

cp -r target/spring-mvc $CATALINA_HOME/webapps/
echo "synchronized"

TPID="$(ps -ef | awk '/[t]omcat/{print $2}')"

if ! [ $TPID -gt 0 ]; then
    echo "[tomcat] starting..."
    $CATALINA_HOME/bin/catalina.sh start
    exit 0
fi

