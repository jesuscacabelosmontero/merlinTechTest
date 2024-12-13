package merlin.techtest.prices.application;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import merlin.techtest.prices.domain.models.Filter;
import merlin.techtest.prices.domain.models.Price;
import merlin.techtest.prices.exception.PriceNotFoundException;
import merlin.techtest.prices.infrastructure.repository.PriceEntity;
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
    public Price getFilteredPrice(Filter filter){
        PriceEntity price = repository.findPricesByFilter(filter.getProductId(), filter.getBrandId(), filter.getDate());
        if (price == null) {
            throw new PriceNotFoundException("No se encontró el precio para ese producto de esa marca para esa fecha.");
        }
        return modelMapper.map(price, Price.class);
    }
}
