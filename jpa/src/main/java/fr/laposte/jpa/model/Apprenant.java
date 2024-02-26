package fr.laposte.jpa.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class Apprenant extends AbstractJPAEntity {
	
	@ManyToMany
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private Set<Competence> competences = new HashSet<>();
	
	public void addCompetence(Competence competence) {
		competences.add(competence);
	}
	
	public List<Competence> getCompetences() {
		return Collections.unmodifiableList(new ArrayList<>(competences));
	}
	
	@ManyToOne
	private SessionFormation sessionFormation;
	
	private String nom;
	
	private String prenom;
}
