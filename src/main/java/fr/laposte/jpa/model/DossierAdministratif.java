package fr.laposte.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class DossierAdministratif extends AbstractJPAEntity {
	
	@OneToOne
	@NonNull
	private Apprenant apprenant;
	
	private String tuteurNom;
	
	private String tuteurEmail;
}
