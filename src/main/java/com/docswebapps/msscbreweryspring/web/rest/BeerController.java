package com.docswebapps.msscbreweryspring.web.rest;
import com.docswebapps.msscbreweryspring.domain.BeerDto;
import com.docswebapps.msscbreweryspring.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity.ok().body(beerService.getBeerDto(beerId));
    }

    @PostMapping
    public ResponseEntity createBeer(@RequestBody BeerDto beerDto) throws URISyntaxException {
        UUID id = this.beerService.createBeerDto(beerDto);
        URI location = new URI("/api/v1/beer" + id);
        return ResponseEntity.created(location).build();
    }

    @PutMapping()
    public ResponseEntity updateBeer(@RequestBody BeerDto beerDto) {
        if(beerDto.getId() == null) {
            return ResponseEntity.badRequest().build();
        } else {
            this.beerService.updateBeerDto(beerDto);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerDto(@PathVariable("beerId") UUID beerId) {
        this.beerService.deleteDto(beerId);
    }
}
