package fr.norsys.frontend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import fr.norsys.backend.entity.Equipe;
import fr.norsys.backend.entity.Pronostic;
import fr.norsys.backend.entity.Utilisateur;
import fr.norsys.frontend.constant.Constant;
import fr.norsys.frontend.constant.Url;
import fr.norsys.frontend.constant.View;

@Controller
public class PronosticController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/pronostic")
	public String showPronosticForm(@RequestParam("idMatch") String matchId, Model model, HttpServletRequest request) {
		Long idMatch = Long.parseLong(matchId);
		setAttributesForRestTemplate();
		boolean estJouer = restTemplate.getForEntity(Url.GET_EST_JOUER, Boolean.class, idMatch).getBody();
		Equipe[] equipes = restTemplate.getForEntity(Url.GET_EQUIPES, Equipe[].class, idMatch).getBody();
		Pronostic[] pronostics = restTemplate
				.getForEntity(Url.GET_PRONOSTICS, Pronostic[].class, getUser(request).getId(), idMatch).getBody();
		this.setAttributeForPronosticPage(model, idMatch, equipes, pronostics, estJouer);
		return View.PRONOSTIC;
	}

	@PostMapping("/pronosticProcess")
	public ModelAndView pronosticProcess(HttpServletRequest request) {
		Long idMatch = this.parsLong(Constant.ID_MATCH, request);
		Pronostic pronostic1 = new Pronostic(getUser(request).getId(), this.parsLong(Constant.FIRST_LABEL, request),
				idMatch, this.parsInt(Constant.FIRST_EQUIPE, request));
		Pronostic pronostic2 = new Pronostic(getUser(request).getId(), this.parsLong(Constant.SECOND_LABEL, request),
				idMatch, this.parsInt(Constant.SECOND_EQUIPE, request));
		this.doActionForPronosticProcess(request, pronostic1, pronostic2);
		return new ModelAndView(View.REDIRECT_COMPETITIONS);
	}

	private void doActionForPronosticProcess(HttpServletRequest request, Pronostic pronostic1, Pronostic pronostic2) {
		List<Pronostic> pronostics = new ArrayList<Pronostic>();
		pronostics.addAll(Arrays.asList(pronostic1, pronostic2));
		setAttributesForRestTemplate();
		restTemplate.postForObject(getUrl(request), pronostics, List.class);
	}

	private void setAttributeForPronosticPage(Model model, Long idMatch, Equipe[] equipes, Pronostic[] pronostics,
			boolean estJouer) {
		model.addAttribute(Constant.FIRST_EQUIPE, equipes[0]);
		model.addAttribute(Constant.SECOND_EQUIPE, equipes[1]);
		setAttributeForPronostic(model, equipes, pronostics);
		model.addAttribute(Constant.ID_MATCH, idMatch);
		model.addAttribute(Constant.EST_JOUER, estJouer);
		model.addAttribute(Constant.PRONOSTICS, pronostics);
	}

	private void setAttributeForPronostic(Model model, Equipe[] equipes, Pronostic[] pronostics) {
		if (pronostics.length != 0) {
			Map<Long, Pronostic> mapPronostics = new HashMap<Long, Pronostic>();
			Arrays.stream(pronostics).forEach(pronostic -> mapPronostics.put(pronostic.getIdEquipe(), pronostic));
			this.addAttributePronosticEquipe(model, mapPronostics.get(equipes[0].getId()),
					mapPronostics.get(equipes[1].getId()));
		} else {
			this.addAttributePronosticEquipe(model, null, null);
		}
	}

	private String getUrl(HttpServletRequest request) {
		return request.getParameter(Constant.ACTION).equals(Constant.INSERT) ? Url.ADD_PRONOSTIC : Url.UPDATE_PRONOSTIC;
	}

	private Utilisateur getUser(HttpServletRequest request) {
		return (Utilisateur) request.getSession(false).getAttribute(Constant.UTILISATEUR);
	}

	private Long parsLong(String parametre, HttpServletRequest request) {
		return Long.parseLong(request.getParameter(parametre));
	}

	private Integer parsInt(String parametre, HttpServletRequest request) {
		return Integer.parseInt(request.getParameter(parametre));
	}

	private void setAttributesForRestTemplate() {
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	}

	private void addAttributePronosticEquipe(Model model, Pronostic pronostic1, Pronostic pronostic2) {
		model.addAttribute(Constant.PRONOSTIC_FIRST_EQUIPE, pronostic1);
		model.addAttribute(Constant.PRONOSTIC_SECOND_EQUIPE, pronostic2);
	}

}
