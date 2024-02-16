package com.example.hr.domain.employee;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "job_history")
public class JobHistory {

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
}
