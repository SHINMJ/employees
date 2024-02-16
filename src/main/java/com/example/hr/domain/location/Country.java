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
@Table(name = "countries")
public class Country extends BaseEntity {

    @Id
    private String countryId;

    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", foreignKey = @ForeignKey(name = "countries_ibfk_1"), nullable = false)
    private Region region;

}
