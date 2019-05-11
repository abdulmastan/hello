
This archetype provides access to 3 types of logging 
1. syslog 
2. awslog 
3. splunk

Details on these can be found at https://docs.docker.com/engine/admin/logging/overview/


1. Open the apimetadata.properties 
2. uncomment the following lines 
```
ecs.logging.driver=syslog
ecs.logging.driver.options.1=syslog-address: unix:/var/log/demographics-api
ecs.logging.driver.options.2=tag: demographics-api
ecs.logging.driver.options.3=
ecs.logging.driver.options.4=
ecs.logging.driver.options.5=
```
3. Comment out the sections dealing with awslog and splunk 
4. Build your package using mvn package 
5. Examine the docker-compose file under target/classes/docker . This will reflect the changes needed to enable syslog on the container


1. Open the apimetadata.properties 
2. uncomment the following lines 
```
ecs.logging.driver=awslogs
ecs.logging.driver.options.1=awslogs-region: us-east-1
ecs.logging.driver.options.2=awslogs-group: $AWSLOGS_GROUP
ecs.logging.driver.options.3=awslogs-stream-prefix: demographics-api
ecs.logging.driver.options.4=
ecs.logging.driver.options.5=
```
3. Comment out the sections dealing with syslog and splunk 
4. Build your package using mvn package 
5. Examine the docker-compose file under target/classes/docker . This will reflect the changes needed to enable sawslog on the container
    - $AWSLOG_GROUP needs to be supplied based on the environment name via the .env file 


1. Open the apimetadata.properties 
2. uncomment the following lines 
```
#ecs.logging.driver=splunk
#ecs.logging.driver.options.1=splunk-token: $SPLUNK_TOKEN
#ecs.logging.driver.options.2=splunk-url: $SPLUNK_URL
#ecs.logging.driver.options.3=
#ecs.logging.driver.options.4=
#ecs.logging.driver.options.5=
```
3. Comment out the sections dealing with awslog and syslog
4. Build your package using mvn package 
5. Examine the docker-compose file under target/classes/docker . This will reflect the chnages needed to enable splunk on the container
    - $SPLUNK_TOKEN, $SPLUNK_URL are enviroment variables. 
    - They  needs to be supplied based on the environment name via the .env file 
