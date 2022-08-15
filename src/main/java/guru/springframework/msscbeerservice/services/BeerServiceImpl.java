package guru.springframework.msscbeerservice.services;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.exception.BeerNotFoundException;
import guru.springframework.msscbeerservice.repository.BeerRepository;
import guru.springframework.msscbeerservice.web.mapper.BeerMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements
    BeerService {

  private final BeerRepository beerRepository;
  private final BeerMapper beerMapper;

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(
        BeerNotFoundException::new));
  }

  @Override
  public BeerDto saveNewBeer(BeerDto beerDto) {
    return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
  }

  @Override
  public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
    Beer beer = beerRepository.findById(beerId).orElseThrow(BeerNotFoundException::new);

    beer.setBeerName(beerDto.getBeerName());
    beer.setBeerStyle(beerDto.getBeerStyle().name());
    beer.setPrice(beerDto.getPrice());
    beer.setUpc(beerDto.getUpc());

    return beerMapper.beerToBeerDto(beerRepository.save(beer));
  }
}
