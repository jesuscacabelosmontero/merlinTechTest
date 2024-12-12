package merlin.techtest.prices.application;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import merlin.techtest.prices.domain.models.Filter;
import merlin.techtest.prices.domain.models.Price;
import merlin.techtest.prices.infrastructure.repository.PriceRepository;

@Service
public class PriceService {

    private final PriceRepository repository;
    private final ModelMapper modelMapper;
    
    public PriceService(PriceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    
    @Transactional
    public List<Price> getFilteredPrice(Filter filter){
        return repository.findPricesByFilter(null, null, null, null)
        .stream().map(price -> modelMapper.map(price, Price.class)).collect(Collectors.toList());
    }
}
