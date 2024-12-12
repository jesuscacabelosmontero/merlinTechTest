package merlin.techtest.prices.domain.ports;

import java.time.LocalDate;
import java.util.List;

import merlin.techtest.prices.infrastructure.repository.PriceEntity;

public interface PricePort {

    List<PriceEntity> findPricesByFilter(
        Long productId, 
        Long brandId, 
        LocalDate applicationDateStart, 
        LocalDate applicationDateEnd
    );
}