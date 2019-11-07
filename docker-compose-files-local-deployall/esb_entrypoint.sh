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
echo server_port $esb_server_port
echo server_address $esb_server_address
echo mongo_host $mongo_host
echo mongo_port $mongo_port
echo app_env $app_env
echo load_db $load_db
echo '========================================'

cd /app/train-microservices-esb
mvn clean install -Dgib.enabled=false -DskipTests
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=$esb_server_port,--server.address=$esb_server_address,--mongo.host=$mongo_host,--mongo.port=$mongo_port,--spring.data.mongodb.host=$mongo_host,--spring.data.mongodb.port=$mongo_port,--spring.data.mongodb.database=$mongo_db_name,--app_env=$app_env,--load_db=$load_db,--srv_loc_protocol=$srv_loc_protocol,--srv_loc_host=$srv_loc_host,--srv_loc_port=$srv_loc_port,--srv_loc_app_ctx=$srv_loc_app_ctx,--srv_loc_rest_ctx=$srv_loc_rest_ctx,--env_db_name=$env_db_name,--env_db_type=$env_db_type,--env_db_token=$env_db_token,--env_ms_name=$env_ms_name,--env_ms_type=$env_ms_type,--env_ms_token=$env_ms_token,--env_dav_name=$env_dav_name,--env_dav_type=$env_dav_type,--env_dav_token=$env_dav_token

#cd /app/train-microservices-esb && mvn install -DskipTests && mvn spring-boot:run -Dserver.address=0.0.0.0 -Dserver.port=9091
#mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8881,--server.address=127.0.0.1,--mongo.host=127.0.0.1,--mongo.port=27018,--app.env=dev,--load.db=true
