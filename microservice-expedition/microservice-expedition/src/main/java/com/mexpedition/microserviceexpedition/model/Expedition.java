package com.mexpedition.microserviceexpedition.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Expedition {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int idCommande;
	
	private String etat;

}
