package fr.norsys.frontend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import fr.norsys.backend.entity.Competition;
import fr.norsys.backend.entity.Equipe;
import fr.norsys.frontend.constant.Constant;
import fr.norsys.frontend.constant.Url;
import fr.norsys.frontend.constant.View;

@Controller
public class CompetitionController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/competitions")
	public String showCompetition(Model model) {
		Competition[] competitions = restTemplate.getForEntity(Url.GET_COMPETITIONS, Competition[].class).getBody();
		model.addAttribute(Constant.LISTE_COMPETITIONS, competitions);
		return View.COMPETITIONS;
	}

	@GetMapping("/competition")
	public String showPoulesForCompetition(@RequestParam("id") String id, Model model) {
		@SuppressWarnings("unchecked")
		Map<Integer, List<Equipe>> poules = restTemplate
				.getForEntity(Url.GET_COMPETITION, Map.class, Long.parseLong(id)).getBody();
		model.addAttribute(Constant.ATTRIBUTE_POULES, poules);
		model.addAttribute(Constant.ATTRIBUTE_ID_COMPETITION, id);
		return View.POULES;
	}

}
