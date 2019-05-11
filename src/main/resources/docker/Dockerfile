FROM @docker.base.image@

ENV JAVA_OPTS=@docker.jvm.options@

# Add the micro Service
ADD batch-api*.jar batch-api.jar
RUN ls -la batch-api.jar &&\
    touch batch-api.jar

EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar batch-api.jar" ]

