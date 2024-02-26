package fr.laposte.jpa.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor(access = AccessLevel.NONE)
public class AbstractJPAEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}
