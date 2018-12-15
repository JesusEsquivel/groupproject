package com.techtalentsouth.EvaluationApp.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/")
	public ModelAndView index(Player player) {
		ModelAndView mv = new ModelAndView ("player/index");	
		return mv;
	}
	
	@PostMapping("/")
	public ModelAndView registerPlayer(Player player) {
		ModelAndView mv = new ModelAndView("player/new");
		Player registeredPlayer = playerRepository.save(new Player(player.getName(), player.getHeight()));
		mv.addObject("player", registeredPlayer);
		return mv;
	}
	
	@ModelAttribute("allHeightValues")
	public String[] getAllHeightValues() {
		return new String[] {"5'0\"", "5'1\"", "5'2\"", "5'3\"", "5'4\"", "5'5\"", "5'6\"", "5'7\"", "5'8\"", "5'9\"", "5'10\"", "5'11\"",
				"6'0\"", "6'1\"", "6'2\"", "6'3\"", "6'4\"", "6'5\"", "6'6\"", "6'7\"", "6'8\"", "6'9\"", "6'10\"", "6'11\""};
	}
	

}
