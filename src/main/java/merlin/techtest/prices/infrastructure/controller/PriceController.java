package merlin.techtest.prices.infrastructure.controller;

import org.springframework.web.bind.annotation.RestController;

import merlin.techtest.prices.application.PriceService;
import merlin.techtest.prices.domain.models.Filter;
import merlin.techtest.prices.domain.models.Price;
import merlin.techtest.prices.exception.PriceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PriceController {

    private final PriceService service;
    
    public PriceController(PriceService service) {
        this.service = service;
    }

    @GetMapping("/api/price")
    public Price getPriceByFilter(@RequestBody Filter filter) {
        return service.getFilteredPrice(filter);
    }
    
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<String> handlePriceNotFoundException(PriceNotFoundException exception) {
        return new ResponseEntity<>("Error: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
