package com.famp.backend.services.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.famp.backend.services.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
}
