package merlin.techtest.prices.infrastructure.repository.jpa;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import merlin.techtest.prices.infrastructure.repository.PriceEntity;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId " +
       "AND p.startDate <= :applicationDate AND p.endDate >= :applicationDate ORDER BY p.priority DESC")
PriceEntity findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
        @Param("productId") Long productId,
        @Param("brandId") Long brandId,
        @Param("applicationDate") LocalDateTime applicationDate);

}