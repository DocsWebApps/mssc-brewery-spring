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

    public UUID createBeerDto(BeerDto beerDto) {
        BeerDto newBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(1234L)
                .build();

        return newBeer.getId();
    }

    public void updateBeerDto(BeerDto beerDto) {
    }

    public void deleteDto(UUID beerId) {
    }
}
