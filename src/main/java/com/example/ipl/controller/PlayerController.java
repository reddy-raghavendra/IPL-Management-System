package com.example.ipl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ipl.entity.Player;
import com.example.ipl.service.PlayerService;
import com.example.ipl.service.TeamService;

@Controller
public class PlayerController {
	private PlayerService playerService;
	private TeamService teamService;

//	public PlayerController(PlayerService playerService) {
//		this.playerService = playerService;
//	}
		
	
	public PlayerController(PlayerService playerService,TeamService teamService) {
		super();
		this.playerService = playerService;
		this.teamService = teamService;
	}	
		
//to list all the Players
	@GetMapping("/players")
	public String listPlayers(Model model) {
//		playerService.getAllPlayers();
		model.addAttribute("players", playerService.getAllPlayers());
//		model.addAttribute("players", teamService.getAllTeams());
		return "players";
	}
	

	@GetMapping("/players/new")
	public String createPlayerForm(Model model) {
//create team object to hold player data
		Player player = new Player();
		model.addAttribute("player", player);
		return "create_player";
	}
	
	@PostMapping("/players")
	public String savePlayer(@ModelAttribute("player") Player player) {
		playerService.savePlayer(player);
		return"redirect:/players";
	}
	@GetMapping("/players/edit/{id}")
	public String editPlayerForm(@PathVariable Long id, Model model){
		model.addAttribute("player",playerService.getPlayerById(id));
		return "edit_player";		
	}
	
	@PostMapping("/players/{id}")
	public String updatePlayer(@PathVariable Long id,@ModelAttribute("player") Player player,Model model) { 
//	get Team from database
		Player existingPlayer = playerService.getPlayerById(id);
		existingPlayer.setFirstName(player.getFirstName());	
		existingPlayer.setLastName(player.getLastName());
//		existingPlayer.setTeamId(id);
		existingPlayer.setId(id);
//		existingPlayer.setId(id);
		existingPlayer.setTeamName(player.getTeamName());
		return "redirect:/players";
	}
	
//	Handler to delete team
	@GetMapping("players/{id}")
	public String deletePlayer(@PathVariable Long id) {
		playerService.deletePlayerById(id);
		return "redirect:/players";
	}
}
