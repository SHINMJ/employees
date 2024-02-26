# 사원 관리 API

## 구성 환경
- Spring Boot 3.2.2
- jdk 17
- MySQL 8.0
- Spring Data JPA

## Data 참고
[hr-schema-mysql](https://github.com/nomemory/hr-schema-mysql/blob/master/hr-schema-mysql.sql)

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
1. database volume directory 생성 `mkdir ./database/data` 
2. gradle 빌드  `./gradlew build`
3. docker-compose 통해 deploy `docker-compose up -d --build`
### 배포 시 참고 사항
open api 가 포함되어 있기 때문에
OPENAPI_SERVICE_KEY 를 발급 받아야 한다.

[공공데이터포털>기상청_중기예보](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15059468)
