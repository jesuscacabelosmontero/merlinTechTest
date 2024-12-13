package merlin.techtest.prices.infrastructure.repository.jpa;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import merlin.techtest.prices.infrastructure.repository.PriceEntity;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    PriceEntity findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long productId, Long brandId, LocalDateTime applicationDateStart, LocalDateTime applicationDateEnd);
}