package com.example.ipl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ipl.entity.Team;
import com.example.ipl.service.TeamService;

@Controller
public class TeamController {
	private TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
//to list all the Teams
	@GetMapping("/teams")
	public String listTeams(Model model) {
		model.addAttribute("teams", teamService.getAllTeams());
		return "teams";
	}
	
	@GetMapping("/teams/new")
	public String createTeamForm(Model model) {
//create team object to hold team data
		Team team = new Team();
		model.addAttribute("team", team);
		return "create_team";
	}
	
	@PostMapping("/teams")
	public String saveTeam(@ModelAttribute("team") Team team) {
		teamService.saveTeam(team);
		return"redirect:/teams";
	}
	@GetMapping("/teams/edit/{id}")
	public String editTeamForm(@PathVariable Long id, Model model){
		model.addAttribute("team",teamService.getTeamById(id));
		return "edit_team";		
	}
	
	@PostMapping("/teams/{id}")
	public String updateTeam(@PathVariable Long id,@ModelAttribute("team") Team team,Model model) { 
//	get Team from database
		Team existingTeam = teamService.getTeamById(id);
		existingTeam.setEstablishedYear(team.getEstablishedYear());
		existingTeam.setHomeCity(team.getTeamName());
		existingTeam.setEstablishedYear(team.getEstablishedYear());
		existingTeam.setId(id);
		
		teamService.updateTeam(existingTeam);
		return "redirect:/teams";
	}
	
//	Handler to delete team
	@GetMapping("teams/{id}")
	public String deleteTeam(@PathVariable Long id) {
		teamService.deleteTeamById(id);
		return "redirect:/teams";
	}
			
}