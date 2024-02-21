package com.example.hr.domain.location;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "locations")
public class Location  {

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

    public String getCountryName(){
        return country.getCountryName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Location location = (Location) o;
        return locationId != null && Objects.equals(locationId, location.locationId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
