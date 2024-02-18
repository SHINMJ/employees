package com.example.hr.domain.location;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("지역 repository 테스트")
@DataJpaTest
class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private EntityManager entityManager;

    private Country country;

    @BeforeEach
    void setUp() {
        entityManager.createNativeQuery("INSERT INTO regions (region_id, region_name)\n" +
                "VALUES (\n" +
                "\t1,\n" +
                "\t'Europe'\n" +
                "\t);\n").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO countries (country_id, country_name, region_id)\n" +
                "VALUES (\n" +
                "\t'IT',\n" +
                "\t'Italy',\n" +
                "\t1\n" +
                "\t);\n").executeUpdate();

        country = entityManager.find(Country.class, "IT");
    }

    @Test
    void createLocation() {
        Location roma = Location.builder()
                .streetAddress("1297 Via Cola di Rie")
                .postalCode("00989")
                .city("Roma")
                .country(country)
                .build();

        locationRepository.save(roma);

        // sql 확인
        locationRepository.flush();

        Optional<Location> location = locationRepository.findById(roma.getLocationId());

        assertTrue(location.isPresent());
        assertThat(location.get().getCountryName()).isEqualTo(country.getCountryName());
    }
}