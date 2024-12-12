package merlin.techtest.prices.infrastructure.controller;

import org.springframework.web.bind.annotation.RestController;

import merlin.techtest.prices.application.PriceService;
import merlin.techtest.prices.domain.models.Filter;
import merlin.techtest.prices.domain.models.Price;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PriceController {

    private final PriceService service;
    
    public PriceController(PriceService service) {
        this.service = service;
    }

    @GetMapping("/api/price")
    public List<Price> getPriceByFilter(@RequestBody Filter filter) {
        return service.getFilteredPrice(filter);
    }
    
}
