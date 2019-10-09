package com.docswebapps.msscbreweryspring.service;
import com.docswebapps.msscbreweryspring.domain.BeerDto;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class BeerService {
    public BeerDto getBeerDto(UUID uuid) {
        return BeerDto.builder()
                .beerName("Marstons")
                .beerStyle("Ale")
                .id(uuid)
                .upc(1234L)
                .build();
    }
}
