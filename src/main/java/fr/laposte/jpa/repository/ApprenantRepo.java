package fr.laposte.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.jpa.model.Apprenant;

public interface ApprenantRepo extends JpaRepository<Apprenant, Long> {

}
