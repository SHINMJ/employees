package com.example.hr.domain.employee;

import com.example.hr.common.domain.BaseEntity;
import com.example.hr.domain.location.Location;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@EqualsAndHashCode(of = {"departmentId"}, callSuper = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Column(nullable = false)
    private String departmentName;


    private Long managerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "departments_ibfk_1"))
    private Location location;

}
