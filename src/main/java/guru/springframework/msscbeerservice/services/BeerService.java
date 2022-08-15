package guru.springframework.msscbeerservice.services;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface BeerService {

  BeerDto getBeerById(UUID beerId);

  BeerDto saveNewBeer(BeerDto beerDto);

  BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
