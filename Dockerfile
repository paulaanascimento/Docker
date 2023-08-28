FROM openjdk:11

COPY /src/main/java .
COPY lib .
COPY pom.xml .

RUN javac Main.java

CMD ["java", "Main"]