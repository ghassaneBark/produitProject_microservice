package com.mexpedition.microserviceexpedition.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mexpedition.microserviceexpedition.model.Expedition;

@Repository
public interface ExpeditionDao extends JpaRepository<Expedition,Integer> {
	
	

}
