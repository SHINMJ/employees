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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @PersistenceContext
    private EntityManager em;

    private Job job;
    private Department department;

    @BeforeEach
    void setUp() {
        em.createNativeQuery("insert into jobs (job_id, job_title) values ('job1', 'job1name')")
                .executeUpdate();

        em.createNativeQuery("insert into departments (department_id, department_name) values (100, 'department1')")
                .executeUpdate();

        job = em.find(Job.class, "job1");
        department = em.find(Department.class, 100);
    }

    @AfterEach
    void tearDown() {
        em.createNativeQuery("delete from employees")
                .executeUpdate();
        em.flush();
    }

    @Test
    void createEmployee() {
        Employee employee = Employee.builder()
                .firstName("first")
                .lastName("last")
                .email("email@email.com")
                .hireDate(LocalDate.of(2012, 4, 12))
                .salary(BigDecimal.valueOf(80_000_000))
                .job(job)
                .department(department)
                .build();

        repository.save(employee);

        repository.flush();

        List<Employee> employees = repository.findAll();

        assertThat(employees).contains(employee);
    }

    @Test
    void findById() {
        Employee saved = saveEmployee();

        Optional<Employee> optional = repository.findById(saved.getEmployeeId());

        assertTrue(optional.isPresent());

        assertEquals(saved, optional.get());

    }

    private Employee saveEmployee(){
        Employee employee = Employee.builder()
                .firstName("first")
                .lastName("last")
                .email("email@email.com")
                .hireDate(LocalDate.of(2012, 4, 12))
                .salary(BigDecimal.valueOf(80_000_000))
                .job(job)
                .department(department)
                .build();

        return repository.save(employee);
    }
}