package fr.laposte.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.jpa.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
}
