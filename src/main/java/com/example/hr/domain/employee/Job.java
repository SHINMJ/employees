package com.example.hr.domain.employee;

import com.example.hr.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {

    @Id
    private String jobId;
    @Column(nullable = false)
    private String jobTitle;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;

}
