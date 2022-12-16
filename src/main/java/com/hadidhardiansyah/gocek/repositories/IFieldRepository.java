package com.hadidhardiansyah.gocek.repositories;

import com.hadidhardiansyah.gocek.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IFieldRepository extends JpaRepository<Field, Integer> {

    @Query(value = "select * from field f order by f.field_id", nativeQuery = true)
    List<Field> findAll();

    @Query(value = "select * from field f where f.field_id = ?1", nativeQuery = true)
    Optional<Field> findByFieldId(Integer fieldId);

    @Transactional
    @Modifying
    @Query(value = "delete from field f where f.field_id = ?1", nativeQuery = true)
    void deleteByFieldId(Integer fieldId);

}