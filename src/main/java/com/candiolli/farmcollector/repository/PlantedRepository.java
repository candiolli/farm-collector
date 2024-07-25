package com.candiolli.farmcollector.repository;

import com.candiolli.farmcollector.model.Planted;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlantedRepository extends CrudRepository<Planted, Long> {

    @Query("select p from Planted p where p.field.farm.id = :farmId and p.field.id = :fieldId")
    List<Planted> findByFieldFarmIdAndFieldId(@Param("farmId") Long farmId, @Param("fieldId") Long fieldId);
}
