package com.techtalentsouth.EvaluationApp.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/")
	public String index() {
		return "player/index";
	}

}
