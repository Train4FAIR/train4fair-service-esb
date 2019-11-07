#!/bin/bash

echo Hi $user_name.
echo You are running the scripts to
echo deploy and run the TrainServiceLocator 
echo Spring Boot Service on host $server_address and  ort $server_port.
echo as well as, the TrainServiceLocator database on host $mongo_host and port $mongo_port. 
echo If necessary you can review and even override the default variables
echo to be aligned with the tergaet environment which you would like to perform this deployment.
echo Ps.: Find below the current/default variables values which could be changed _if necessary.
echo '========================================'
echo server_port $sd_server_port
echo server_address $sd_server_address
echo mongo_host $mongo_host
echo mongo_port $mongo_port
echo app_env $app_env
echo load_db $load_db
echo '========================================'


#mongod --bind_ip_all --ipv6 --port $mongo_port

cd /app/service-locator-app/pht-envsupport-servicelocator
mvn clean install -Dgib.enabled=false -DskipTests
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=$sd_server_port,--server.address=$sd_server_address,--spring.data.mongodb.host=$mongo_host,--spring.data.mongodb.port=$mongo_port,--spring.data.mongodb.database=$mongo_db_name,--mongo.host=$mongo_host,--mongo.port=$mongo_port,--app.env=$app_env,--load.db=$load_db

#cd /app/train-microservices-esb && mvn install -DskipTests && mvn spring-boot:run -Dserver.address=0.0.0.0 -Dserver.port=9091
#mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8881,--server.address=127.0.0.1,--mongo.host=127.0.0.1,--mongo.port=27018,--app.env=dev,--load.db=true
