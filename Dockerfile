FROM openjdk:14
VOLUME /tmp
#ENV JAVA_OPTS="-Xms50m -Xmx128m"

ADD target/phonebook-0.0.1-SNAPSHOT.jar phonebook-0.0.1-SNAPSHOT.jar
#EXPOSE 8081
ENTRYPOINT ["java","-jar","phonebook-0.0.1-SNAPSHOT.jar"]


