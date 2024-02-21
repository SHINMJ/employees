package com.example.hr.domain.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "jobs")
public class Job  {

    @Id
    private String jobId;
    @Column(nullable = false)
    private String jobTitle;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return jobId != null && Objects.equals(jobId, job.jobId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
