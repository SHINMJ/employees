package com.example.hr.domain.location;

import com.example.hr.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "regions")
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    private String regionName;

}
