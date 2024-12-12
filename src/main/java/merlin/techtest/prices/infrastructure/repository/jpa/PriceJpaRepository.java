package merlin.techtest.prices.infrastructure.repository.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import merlin.techtest.prices.infrastructure.repository.PriceEntity;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    List<PriceEntity> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        Long productId, 
        Long brandId, 
        LocalDate applicationDateStart, 
        LocalDate applicationDateEnd
    );
}