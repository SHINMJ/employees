# 사원 관리 API

## 구성 환경
- Spring Boot 3.2.2
- jdk 17
- MySQL 8.0
- Spring Data JPA

## Data 참고
[hr-schema-mysql](https://github.com/nomemory/hr-schema-mysql/blob/master/hr-schema-mysql.sql)

## URL
http://13.209.99.83:8080/

## ENDPOINT 
([API 명세서](http://13.209.99.83:8080/swagger-ui/index.html) 에서 확인 가능)
- [x] 특정 사원의 현재 정보 조회 가능한 api
  - GET /employees/{employeeId}
- [x] 특정 사원의 이력 정보 조회 가능한 api
  - GET /employees/histories
- [x] 부서 및 위치 정보 조회 가능한 api
  - /departments/{departmentId}
- [x] 특정 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트 api
  - PUT /departments/{departmentId}/salary-increase
- [x] 중기 날씨 정보 조회 api (커스터마이징 된 api) 
  - GET /openapi/mid-fcst-info

## Deploy
1. gradle 빌드  `./gradlew build`
2. docker-compose 통해 deploy `docker-compose up -d --build`
