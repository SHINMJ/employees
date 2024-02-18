package com.example.hr.domain.employee;

import com.example.hr.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@EqualsAndHashCode(of = {"employeeId"}, callSuper = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    private String phoneNumber;
    @Column(nullable = false)
    private LocalDate hireDate;

    @Column(nullable = false)
    private BigDecimal salary;
    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", foreignKey = @ForeignKey(name = "employees_ibfk_1"), nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "employees_ibfk_2"))
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "employees_ibfk_3"))
    private Employee manager;

    public Employee salaryIncrease(double percentage){
        BigDecimal increase = this.salary.multiply(BigDecimal.valueOf((percentage/100)));
        BigDecimal newSalary = this.salary.add(increase);
        this.salary = newSalary;
        return this;
    }
}
