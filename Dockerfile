FROM maven:3.6.3-openjdk-11-slim

COPY . /app

WORKDIR /app

RUN mvn clean package -Dmaven.test.skip=true

COPY target/aplazo-technical-test-0.0.1-SNAPSHOT.jar aplazo-technical-test-0.0.1.jar

CMD java -Xmx1024m -Xms1024m  -jar aplazo-technical-test-0.0.1.jar

