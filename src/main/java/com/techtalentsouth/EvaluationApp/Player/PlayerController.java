package com.techtalentsouth.EvaluationApp.Player;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	// adds the heights to the drop-down-menu on index page
	@ModelAttribute("allHeightValues")
	public String[] getAllHeightValues() {
		return new String[] {"5'0\"", "5'1\"", "5'2\"", "5'3\"", "5'4\"", "5'5\"", "5'6\"", "5'7\"", "5'8\"", "5'9\"", "5'10\"", "5'11\"",
				"6'0\"", "6'1\"", "6'2\"", "6'3\"", "6'4\"", "6'5\"", "6'6\"", "6'7\"", "6'8\"", "6'9\"", "6'10\"", "6'11\""};
	}
	
	//lists all players
	@GetMapping("/players/all")
	public ModelAndView getAllPlayers(Player player) {
		ModelAndView mv = new ModelAndView("player/playerList");
		mv.addObject("players", playerRepository.findAll());
		return mv;
	}
	
	// Shows the individual player to edit
	@GetMapping("players/edit/{id}")
	public ModelAndView updatePlayer(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("player/edit");
		Optional<Player> player = playerRepository.findById(id);
		mv.addObject("player", player);
		return mv;
	}
	
	//saves the edits to the player's skill level
	@PutMapping("/players/edit")
	public ModelAndView saveUpdates(Player player, Long id) {
		ModelAndView mv = new ModelAndView("redirect:/players/all");
		playerRepository.save(player);
		return mv;
	}
	
	// Values for radio buttons on edit page
	@ModelAttribute("skillValues")
    public int[] getSkillValues() {
        return new int[] {1, 2, 3, 4, 5};
    }
	
	//shows the form for editing a player
	@DeleteMapping("/players/delete/{id}")
	public ModelAndView deletePlayer(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("redirect:/players/all");
		playerRepository.deleteById(id);
		return mv;
	}


}
