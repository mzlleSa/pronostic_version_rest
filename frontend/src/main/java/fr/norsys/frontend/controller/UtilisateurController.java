package fr.norsys.frontend.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.norsys.backend.entity.Utilisateur;
import fr.norsys.frontend.constant.Constant;
import fr.norsys.frontend.constant.Url;
import fr.norsys.frontend.constant.View;

@Controller
public class UtilisateurController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/inscription")
	public String showFormInscription(Model model) {
		model.addAttribute(Constant.UTILISATEUR, new Utilisateur());
		return View.INSCRIPTION;
	}

	@PostMapping("/inscriptionProcess")
	public String processInscription(Model model, @Valid @ModelAttribute Utilisateur utilisateur,
			BindingResult theBindingResult) {
		String page;
		setAttributeForRestTemplate();
		if (!theBindingResult.hasErrors()) {
			restTemplate.postForObject(Url.INSCRIPTION_PROCESS, utilisateur, Utilisateur.class);
			page = View.LOGIN;
		} else {
			page = View.INSCRIPTION;
		}
		return page;
	}

	@GetMapping("/login")
	public String showFormLogin(Model model) {
		model.addAttribute(Constant.UTILISATEUR, new Utilisateur());
		return View.LOGIN;
	}

	@PostMapping("/loginProcess")
	public String processLoginForm(HttpServletRequest request, Model model, @ModelAttribute Utilisateur utilisateur)
			throws JsonProcessingException {
		String page;
		setAttributeForRestTemplate();
		Utilisateur user = restTemplate.postForObject(Url.LOGIN_PROCESS, utilisateur, Utilisateur.class);
		if (Optional.ofNullable(user).isPresent()) {
			request.getSession().setAttribute(Constant.UTILISATEUR, user);
			page = this.getPage(user);
		} else {
			page = View.LOGIN;
			model.addAttribute(Constant.ERROR_MESSAGE, Constant.PASSWORD_INVALID_VALUE);
		}
		return page;
	}

	@GetMapping("/profile")
	public String showUserProfile(HttpServletRequest request, Model model) {
		setAttributeForRestTemplate();
		Utilisateur utilisateur = (Utilisateur) request.getSession(false).getAttribute(Constant.UTILISATEUR);
		Utilisateur user = restTemplate.postForObject(Url.PROFILE, utilisateur, Utilisateur.class);
		model.addAttribute(Constant.USER, user);
		return View.PROFILE;
	}

	@GetMapping("/logout")
	public String logOutProcess(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return View.HOME;
	}

	private void setAttributeForRestTemplate() {
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	}

	private String getPage(Utilisateur user) {
		return user.getRole().equals(Constant.ROLE_ADMIN) ? View.ESPACE_ADMIN : View.REDIRECT_COMPETITIONS;
	}
}
