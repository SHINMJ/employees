# 사원 관리 API

## 구성 환경
- Spring Boot 3.2.2
- jdk 17
- MySQL 8.0
- Spring Data JPA

## API 
(<< server >>/swagger-ui/index.html 에서 확인 가능)
- [x] 특정 사원의 현재 정보 조회 가능한 api
  - GET /employees/{employeeId}
- [x] 특정 사원의 이력 정보 조회 가능한 api
  - GET /employees/histories
- [x] 부서 및 위치 정보 조회 가능한 api
  - /departments/{departmentId}
- [x] 특정 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트 api
  - PUT /departments/{departmentId}/salary-increase

