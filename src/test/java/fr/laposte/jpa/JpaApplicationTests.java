package fr.laposte.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.jpa.model.Apprenant;
import fr.laposte.jpa.model.Category;
import fr.laposte.jpa.model.Competence;
import fr.laposte.jpa.model.DossierAdministratif;
import fr.laposte.jpa.model.Product;
import fr.laposte.jpa.model.SessionFormation;
import fr.laposte.jpa.repository.ApprenantRepo;
import fr.laposte.jpa.repository.CategoryRepo;
import fr.laposte.jpa.repository.CompetenceRepo;
import fr.laposte.jpa.repository.DossierAdministratifRepo;
import fr.laposte.jpa.repository.ProductRepo;
import fr.laposte.jpa.repository.SessionFormationRepo;

@SpringBootTest
class JpaApplicationTests {
	
	@Autowired
	private ProductRepo repo;
	@Autowired
	private CategoryRepo catRepo;
	//new Repo's
	@Autowired
	private ApprenantRepo appRepo;
	@Autowired
	private CompetenceRepo compRepo;
	@Autowired
	private DossierAdministratifRepo dossAdRepo;
	@Autowired
	private SessionFormationRepo sessForRepo;
	
	@BeforeEach
	void clean() {
		repo.deleteAll();
		catRepo.deleteAll();
		//new Repo's
		compRepo.deleteAll();
		dossAdRepo.deleteAll();
		appRepo.deleteAll();
		sessForRepo.deleteAll();
	}

	@Test
	void testSaveProduct() {
		Product p = new Product();
		p.setLabel("produit 1");
		repo.save(p);
	}
	
	@Test
	void testSaveCategory() {
		Category c = new Category();
		c.setLabel("categorie 1");
		catRepo.save(c);
	}
	
	@Test
	void testLinkProductCategory() {
		Category c = new Category();
		c.setLabel("Fruits");
		catRepo.save(c);
		
		Product p = new Product();
		p.setLabel("pomme");
		p.setCategory(c);
		repo.save(p);
	}
	
	@Test
	void testNewRepos() {
		Apprenant a = new Apprenant();
		Apprenant a2 = new Apprenant();
		Competence c = new Competence();
		SessionFormation sf = new SessionFormation();
		SessionFormation sf2 = new SessionFormation();
		DossierAdministratif da = new DossierAdministratif(a);
		
		sf.setLibelle("CDA La Poste");
		sessForRepo.save(sf);
		sf2.setLibelle("test");
		sessForRepo.save(sf2);
		
		c.setLibelle("Paresse");
		c.setNiveau(10);
		compRepo.save(c);
		
		a.setNom("LE FILS");
		a.setPrenom("Martin");
		a.addCompetence(c);
		a.setSessionFormation(sf);
		appRepo.save(a);
		a2.setNom("MARLEY");
		a2.setPrenom("Bob");
		a2.addCompetence(c);
		a2.setSessionFormation(sf2);
		appRepo.save(a2);
		
		da.setTuteurNom("François");
		da.setTuteurEmail("françois@fakeEmail.com");
		dossAdRepo.save(da);
	}

}
