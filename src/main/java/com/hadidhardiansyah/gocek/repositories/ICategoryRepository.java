package com.hadidhardiansyah.gocek.repositories;

import com.hadidhardiansyah.gocek.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category c order by c.category_id", nativeQuery = true)
    List<Category> findAll();

    @Query(value = "select * from category c where c.category_id = ?1", nativeQuery = true)
    Optional<Category> findByCategoryId(Integer categoryId);

    @Transactional
    @Modifying
    @Query(value = "delete from category c where c.category_id = ?1", nativeQuery = true)
    void deleteByCategoryId(Integer categoryId);














}