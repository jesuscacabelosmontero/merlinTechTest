package merlin.techtest.prices.domain.ports;

import java.time.LocalDateTime;

import merlin.techtest.prices.infrastructure.repository.PriceEntity;

public interface PricePort {

    PriceEntity findPricesByFilter(
        Long productId, 
        Long brandId, 
        LocalDateTime applicationDate
    );
}