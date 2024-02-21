package com.example.hr.dto.location;

import com.example.hr.domain.location.Location;

public record LocationResponse(Long locationId, String streetAddress, String postalCode,
                               String city, String country) {
    public static LocationResponse of(Location location) {
        return new LocationResponse(location.getLocationId(), location.getStreetAddress(),
                location.getPostalCode(), location.getCity(),
                location.getCountryName());
    }
}
