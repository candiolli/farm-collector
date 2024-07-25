package com.candiolli.farmcollector.repository;

import com.candiolli.farmcollector.model.Farm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FarmRepository extends CrudRepository<Farm, Long> {

    @Query(value = "select p.crops_type, p.season, p.expected_product_amount, h.actual_harvested_amount from farm f " +
            "inner join field fd on fd.farm_id = f.id " +
            "inner join planted p on p.field_id = fd.id " +
            "inner join harvested h on h.field_id = fd.id " +
            "where f.id = 1", nativeQuery = true)
    List fetchReport();
}
