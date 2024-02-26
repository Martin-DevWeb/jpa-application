package fr.laposte.jpa.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class Competence extends AbstractJPAEntity {
	
	private String libelle;
	private Integer niveau;
}
