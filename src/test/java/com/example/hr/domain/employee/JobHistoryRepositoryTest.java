package com.example.hr.domain.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JobHistoryRepositoryTest {
    @Autowired
    JobHistoryRepository repository;

    @PersistenceContext
    private EntityManager em;


    private Job job;
    private Department department;
    private Employee employee;

    @BeforeEach
    void setUp() {
        em.createNativeQuery("insert into jobs (job_id, job_title) values ('job1', 'job1name')")
                .executeUpdate();

        em.createNativeQuery("insert into departments (department_id, department_name) values (100, 'department1')")
                .executeUpdate();

        em.createNativeQuery("insert into employees (employee_id, last_name, email, hire_date, salary, job_id, department_id) " +
                        "values (1000, 'lastname', 'email@email.com', '2020-11-11', 24000, 'job1', 100)")
                .executeUpdate();

        job = em.find(Job.class, "job1");
        department = em.find(Department.class, 100);
        employee = em.find(Employee.class, 1000);
    }


    @AfterEach
    void tearDown() {
        em.createNativeQuery("delete from job_history")
                .executeUpdate();
        em.createNativeQuery("delete from employees")
                .executeUpdate();
        em.createNativeQuery("delete from departments")
                .executeUpdate();
        em.createNativeQuery("delete from jobs")
                .executeUpdate();
        em.flush();
    }

    @Test
    void findByEmployeeId() {
        JobHistory jobHistory = saveJobHistory();

        List<JobHistory> byEmployeeId = repository.findByJobHistoryIdEmployee(employee);

        assertThat(byEmployeeId.size()).isEqualTo(1);
        assertThat(byEmployeeId).contains(jobHistory);
    }


    private JobHistory saveJobHistory(){
        JobHistory jobHistory = JobHistory.builder()
                .jobHistoryId(
                        JobHistoryId.builder()
                                .employee(employee)
                                .startDate(LocalDate.now().minusDays(1000))
                                .build()
                )
                .endDate(LocalDate.now())
                .job(job)
                .department(department)
                .build();

        return repository.save(jobHistory);
    }
}