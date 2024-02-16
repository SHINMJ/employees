package com.example.hr.domain.employee;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Embeddable
public class JobHistoryId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "job_history_ibfk_1"), nullable = false)
    private Employee employee;
    @Column(nullable = false)
    private LocalDate startDate;

}
