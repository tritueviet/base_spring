https://hub.docker.com/r/araczkowski/oracle-apex-ords

Installation:
docker pull araczkowski/oracle-apex-ords

Run the container based on prebuilt image from docker with 8080, 1521, 22 ports opened:
docker run -d --name <own-container-name> -p 49160:22 -p 8080:8080 -p 1521:1521 araczkowski/oracle-apex-ords

Password for SYS & SYSTEM & Tomcat ADMIN & APEX ADMIN:
secret


Connect via ssh to server with following setting:
ssh root@localhost -p 49160
password: <custom-password> / secret


Connect database with following setting:
hostname: localhost
port: 1521
sid: xe
username: system
password: <custom-password> / secret


Connect to Tomcat Manager with following settings:
http://localhost:8080/manager
user: ADMIN
password: <custom-password> / secret


Connect to Oracle Application Express web management console via ORDS with following settings:
http://localhost:8080/ords/apex
workspace: INTERNAL
user: ADMIN
password: <custom-password> / secret