Instructions for demographics-api

**
ArtifactID's having [-,_] caused problems in docker-compose file
Make ure that the special chars are removed from the service name in 
docker-compose 

**
 

```
mvn compile 
```


```
mvn test 
```


```
mvn spring-boot:run 
```


```
mvn package install 
```


```
mvn deploy 
```

Note: Credentials will need to be provided in the ~/.m2/settings.xml file 

```    
	<server>
      <id>internalMavenRepository</id>
      <username>nexus-username</username>
      <password>password</password>
    </server>

```



Note: Need docker installed and running to build a docker image. To push a docker image you must have credentails to the local Docker Registry 


```
mvn docker:build -Pdocker 
```

Note: To push docker image credentials will need to be provided in the ~/.m2/settings.xml file 

```
	<server>
      <id>internalHostedDockerRegistry</id>
      <username>...</username>
      <password>...</password>
	  <configuration>
	  <email>user@<domain>.com</email>
	  </configuration>	
    </server>    
```



Each application requires certain variables to be provided before it can be deployed to a target ECS enviroment . These are provided in the docker-compose.yml file 
A list of these variables are provided below. 

NOTE: The CI/CD platform substitutes the below variables prior to deployment 

- project.version : this is the version of the micro service as specified in pom.xml
- project.groupId : this is the groupID of the micro service as specified in pom.xml

- ENCRYPT_KEY : This is the key to used to decrypt configuration information provided by the config service. This is picked up from the system environment 
- spring.profiles.active : This is the spring profile that should be enabled 


By default the app logs all information to SYSLOG ; The default log driver enabled via the docker-compose file is 'syslog'. 
Syslog is redirect to the a centralized location ( ex Splunk or ELK) etc. The below env variable is used to inform the container 
the destination for the syslog. 

- syslog.address


Update the docker-compose.yml file . Remove the logging section in the file 
Replace with the below 
'''
     logging:
        driver: splunk
        options:
          splunk-token: "@splunk.token@"
          splunk-url: "@splunk.url@"
          splunk-insecureskipverify: "true"
'''

- splun-token: Splunk Auth Key 
- splunk-url: Location of the splunk server log input service  



Set Env Variables 

- apigeeUsername: Apigee Edge username 
- apigeePassword: Apigee Edge password
- apigeeTargetEnv: dev|sit|...
- apigeeOrg: Apigee Org


```
mvn  -DapigeeUsername=$apigeeUsername -DapigeePassword=$apigeePassword -DapigeeTargetEnv=$apigeeTargetEnv \
    -Dapigee.config.options=update -DapigeeOrg=$apigeeOrg  \
    clean compile install -P prepare-apigee-bundle,configure-apigee-bundle
```

This will produce a proxy bundle zip file in the target folder 

Note: The proxy bundle __SHOULD__ only be publised from the CI/CD pipeline to Apigee Edge Proxy 


```
mvn  -DapigeeUsername=$apigeeUsername -DapigeePassword=$apigeePassword -DapigeeTargetEnv=$apigeeTargetEnv \ 
    -Dapigee.config.options=update -DapigeeOrg=$apigeeOrg  \
    clean compile install -P prepare-apigee-bundle,configure-apigee-bundle,deploy-apigee-bundle
```

More information can be found here 
- [add-apigee-edge-env](docs/add-apigee-edge-env.md)
- [apigee-apiproxy-bundle](docs/apigee-apiproxy-bundle.md)
- [apigee-edge-config-json](docs/apigee-edge-config-json.md)
