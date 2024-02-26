package fr.laposte.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class Product extends AbstractJPAEntity {
	
	@ManyToOne
	private Category category;

	
	// @Column(unique = true)
	private String label;

}
