package fr.norsys.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import fr.norsys.backend.entity.Match;
import fr.norsys.frontend.constant.Constant;
import fr.norsys.frontend.constant.Url;
import fr.norsys.frontend.constant.View;

@Controller
public class MatchController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/matchs")
	public String showMatchsForPoule(@RequestParam("idCompetition") String idCompetition,
			@RequestParam("idPoule") String idPoule, Model model) {
		Match[] listeMatchs = restTemplate
				.getForEntity(Url.GET_MATCHS, Match[].class, Long.parseLong(idCompetition), Long.parseLong(idPoule))
				.getBody();
		model.addAttribute(Constant.LISTE_MATCHS, listeMatchs);
		return View.MATCHS;
	}

}
