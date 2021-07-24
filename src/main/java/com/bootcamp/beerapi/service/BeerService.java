package com.bootcamp.beerapi.service;

import lombok.AllArgsConstructor;
import com.bootcamp.beerapi.dto.BeerDTO;
import com.bootcamp.beerapi.entity.Beer;
import com.bootcamp.beerapi.exception.BeerAlreadyRegisteredException;
import com.bootcamp.beerapi.mapper.BeerMapper;
import com.bootcamp.beerapi.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        Optional<Beer> optSavedBeer = beerRepository.findByName(beerDTO.getName());
        if (optSavedBeer.isPresent()) {
            throw new BeerAlreadyRegisteredException(beerDTO.getName());
        }
        Beer beer = beerMapper.toModel(beerDTO);
        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(savedBeer);
    }
}
