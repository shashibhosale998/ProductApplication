package com.restapi.category.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.category.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
