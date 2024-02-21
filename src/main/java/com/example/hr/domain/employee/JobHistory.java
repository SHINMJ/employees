package com.example.hr.domain.employee;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "job_history")
public class JobHistory  {

    @EmbeddedId
    private JobHistoryId jobHistoryId;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", foreignKey = @ForeignKey(name = "job_history_ibfk_2"), nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "job_history_ibfk_3"), nullable = false)
    private Department department;

    public Employee getEmployee(){
        return this.getJobHistoryId().getEmployee();
    }

    public LocalDate getStartDate(){
        return this.getJobHistoryId().getStartDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JobHistory that = (JobHistory) o;
        return jobHistoryId != null && Objects.equals(jobHistoryId, that.jobHistoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobHistoryId);
    }
}
