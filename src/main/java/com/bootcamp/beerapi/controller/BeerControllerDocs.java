package com.bootcamp.beerapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootcamp.beerapi.dto.BeerDTO;
import com.bootcamp.beerapi.exception.BeerAlreadyRegisteredException;

@Api("Manages beer stock")
public interface BeerControllerDocs {

    @ApiOperation(value = "Hello world!!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a simple hello world")
    })
    BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;
}
