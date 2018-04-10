package fr.norsys.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import fr.norsys.backend.entity.Match;
import fr.norsys.frontend.constant.Url;
import fr.norsys.frontend.constant.View;

@Controller
public class HomeController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	public String showAcceuil(Model model) {
		Match match = restTemplate.getForEntity(Url.GET_HOME, Match.class).getBody();
		model.addAttribute("nextMatch", match);
		return View.HOME;
	}

}
