
Using a private ssl cert . To import this into the containers JVM follow the steps below 

1. Add the X509 version of the certificate to src\main\resorces\docker\ssl directory as PrivateCA.cer. 
    - Validate that the file is a good X509 cert 
2. Add the file to Git repo 
3. Add the below to your docker file (src\main\resorces\docker\Dockerfile)
```
# Add SSL Cert
 ADD ssl/PrivateCA.cer /etc/ssl/certs/java/PrivateCA
 RUN ls -la /etc/ssl/certs/java &&\
    $JAVA_HOME/bin/keytool -storepasswd -new mysecretpassword -keystore $JAVA_HOME/lib/security/cacerts -storepass changeit && \
    echo "yes" | $JAVA_HOME/bin/keytool -import -trustcacerts -file /etc/ssl/certs/java/PrivateCA -alias private-root-ca -keystore $JAVA_HOME/lib/security/cacerts -storepass mysecretpassword && \
    rm -f /etc/ssl/certs/java/PrivateCA
```
4. Build the docker image 
5. Commit and Push Changes to source control repositories 
