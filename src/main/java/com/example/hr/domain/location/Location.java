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
@Table(name = "locations")
public class Location extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String streetAddress;
    private String postalCode;

    @Column(nullable = false)
    private String city;
    private String stateProvince;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "locations_ibfk_1"), nullable = false)
    private Country country;

}
