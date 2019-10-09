package com.docswebapps.msscbreweryspring.web.rest;
import com.docswebapps.msscbreweryspring.domain.BeerDto;
import com.docswebapps.msscbreweryspring.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        // return new ResponseEntity<>(beerService.getBeerDto(), HttpStatus.OK); // OR
        // A Response Entity is the whole HTTP response, body, status, headers etc.
        HttpHeaders myHeaders = new HttpHeaders();
        myHeaders.add("Dave", "Is Ace");
        return ResponseEntity.ok().headers(myHeaders).body(beerService.getBeerDto(beerId));
    }
}
