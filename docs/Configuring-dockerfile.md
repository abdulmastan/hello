
A tokenized version of this file is provided by the archetype 
The portions of the file can be configured by a developer are 
1. JVM_OPTS Settings 
2. Docker base image 


The JVM settings used to create the api image are configurabled by a developer. 
This can be achieved through the api-metadata.properties file 


The below represents the default configuration of the JVM 
```
    docker.jvm.options="-server -Xmx4g -Xms1g -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled"
```

This configuration of the JVM can be updated by modifying the value of __docker.jvm.options__

Note: Understanding of jvm tuning in the prod is a pre-requisite 



The docker based image does not contain any SSL certificates that are Signed. 
To provide a Base JVM that has a the PrivateCA installed, Build an image as below for use. 

Note: **Admins follow below instructions to build and publish <localregistry>/java-<javaVersion>-jre-alpine-with-privateca**

1. Create a Dockerfile as shown below and save in directory <user.home>/java-<javaVersion>-jre-alpine-with-privateca

```
FROM java:8u92-jre-alpine

ADD PrivateCA.cer /etc/ssl/certs/java/PrivateCA
RUN ls -la /etc/ssl/certs/java &&\
    $JAVA_HOME/bin/keytool -storepasswd -new mysecretpassword -keystore $JAVA_HOME/lib/security/cacerts -storepass changeit && \
    echo "yes" | $JAVA_HOME/bin/keytool -import -trustcacerts -file /etc/ssl/certs/java/PrivateCA -alias hz-root-ca -keystore $JAVA_HOME/lib/security/cacerts -storepass mysecretpassword && \
    rm -f /etc/ssl/certs/java/PrivateCA
    
```

2. Save a copy of X509 cert that contains the Private CA in the <user.home>/java-8u92-jre-alpine-with-privateca
    - Name the X509 certfile as PrivateCA.cer
3. Build and publish the docker image 

```
docker build --tag <localregistry>/java-<javaVersion>-jre-alpine-with-privateca:latest
docker login <localregistry>
docker push <localregistry>/java-<javaVersion>-jre-alpine-with-privateca:latest
```



The dockerbase Image is setup to use java:<javaVersion>-jre-alpine. 

This base image can be changed to accomodate patching , customizations etc. 

To use an alterante image update the property __docker.base.image__

ex: To use the image with a private CA built in , update the api-metadata.properties file 
```
    docker.base.image=<localregistry>/java-<javaVersion>-jre-alpine-with-hzca
```
