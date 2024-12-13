package merlin.techtest.prices.infrastructure.repository;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import merlin.techtest.prices.domain.ports.PricePort;
import merlin.techtest.prices.infrastructure.repository.jpa.PriceJpaRepository;

@Repository
public class PriceRepository implements PricePort {

    private final PriceJpaRepository priceJpaRepository;

    public PriceRepository(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }

    @Override
    public PriceEntity findPricesByFilter(
        Long productId, 
        Long brandId, 
        LocalDateTime applicationDate
    ) {
        return priceJpaRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            productId, 
            brandId, 
            applicationDate,
            applicationDate
        );
    }
}