package com.mexpedition.microserviceexpedition.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mexpedition.microserviceexpedition.dao.ExpeditionDao;
import com.mexpedition.microserviceexpedition.exception.ExpeditionExceptionIntrouvable;
import com.mexpedition.microserviceexpedition.model.Expedition;

@RestController
public class ExpeditionController {

	@Autowired
	ExpeditionDao expeditionDao;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private Logger logger;

	@GetMapping(value = "/Expeditions")
	public List<Expedition> getListExpedition() {
		return expeditionDao.findAll();
	}

	@GetMapping(value = "/Expedition/{id}")
	public ResponseEntity<String> getExpeditionById(@PathVariable int id) {
		Optional<Expedition> expedition = expeditionDao.findById(id);
		String json = null;

		if (expedition.isPresent()) {
			try {
				json = objectMapper.writeValueAsString(expedition.get());
			} catch (JsonProcessingException e) {

				logger.error("l'expedition avec lid " + id + " n'existe pas");
			}
			return ResponseEntity.ok(json);
		} else {
			logger.info("l'expedition avec id' = " + id + " n''existe pas ");

			throw new ExpeditionExceptionIntrouvable(
					"l'expedition avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");

		}
	}

	@PutMapping(value = ("/Expedition"))
	public ResponseEntity<String> modifierExpedition(@RequestBody Expedition expedition) {
		if (!Objects.isNull(expedition) && expedition.getId() != 0) {
			Optional<Expedition> expeditionTrouve = expeditionDao.findById(expedition.getId());
			String json = null;
			if (expeditionTrouve.isPresent()) {
				expedition = expeditionDao.save(expedition);
				try {
					json = objectMapper.writeValueAsString(expedition);
				} catch (JsonProcessingException e) {
					logger.error("l'expedition avec lid " + expedition.getId() + " n'existe pas");

				}
				return ResponseEntity.ok(json);

			} else {
				logger.info("l'expedition avec id' = " + expedition.getId() + " n''existe pas ");

				throw new ExpeditionExceptionIntrouvable(
						"l'expedition avec l'id " + expedition.getId() + " est INTROUVABLE. Écran Bleu si je pouvais.");

			}
		} else {
			logger.info("l'expedition envoyé est incorrecte");

			throw new ExpeditionExceptionIntrouvable(
					"l'expedition envoyé est incorrecte");

		}
	}

	@PostMapping(value = "/Expeditions")
	public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition expedition) {
		Expedition expeditionAdded = expeditionDao.save(expedition);
		if (Objects.isNull(expeditionAdded)) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(expeditionAdded.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
