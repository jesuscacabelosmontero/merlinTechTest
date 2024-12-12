package merlin.techtest.prices.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

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
    public List<PriceEntity> findPricesByFilter(
        Long productId, 
        Long brandId, 
        LocalDate applicationDateStart, 
        LocalDate applicationDateEnd
    ) {
        return priceJpaRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            productId, 
            brandId, 
            applicationDateStart, 
            applicationDateEnd
        );
    }
}