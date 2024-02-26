package fr.laposte.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.jpa.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
