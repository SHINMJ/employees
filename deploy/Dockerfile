# openjdk17 base image
FROM openjdk:17

# jar 파일이 복사되는 위치
ENV APP_HOME=/usr/src/app/
# 작업 시작 위치
WORKDIR $APP_HOME
# jar 파일 복사
COPY ./build/libs/*.jar app.jar
# application port
EXPOSE 8080
# 실행
CMD ["java", "-jar", "app.jar"]