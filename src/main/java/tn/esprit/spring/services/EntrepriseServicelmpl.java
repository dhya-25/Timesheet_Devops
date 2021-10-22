package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class EntrepriseServicelmpl implements IEntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepository;
	

	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<Entreprise> retrieveAllEntreprise() {
		List<Entreprise> entreprises = null; 
		try {
			
			L.info("In method retieveAllUsers :");
	
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			for (Entreprise entreprise : entreprises) {
				L.debug("connexion à la BD OK : ");
			} 
			L.info("Out of Method retrieveAllUSers with succes");
		}catch (Exception e) {
			L.error("Out of Methode retrieveAllUsers with errors : " + e);
		}

		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise e) {
		L.info("In method addUser :");
		Entreprise u_saved = entrepriseRepository.save(e); 
		L.info("Out method addUser :");
		return u_saved; 
	}

	@Override
	public void deleteEntreprise(String id) {
		L.info("In method addUser :");
		entrepriseRepository.deleteById(Long.parseLong(id)); 
		L.info("Out method deleteUser :");

		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		L.info("In method addUser :");
		Entreprise u_saved = entrepriseRepository.save(e); 
		L.info("Out method updateUser :");
		return u_saved; 
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		L.info("In method addUser :");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		Entreprise u =  entrepriseRepository.findById(Long.parseLong(id)).get(); 
		L.info("Out method retrieveUser :");
		return u; 
	}

}
