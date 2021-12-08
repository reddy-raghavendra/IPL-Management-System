package com.example.ipl.service;

import java.util.List;

import com.example.ipl.entity.Team;

public interface TeamService {
	List<Team> getAllTeams();
	Team saveTeam(Team team);
	Team getTeamById(Long id);
	Team updateTeam(Team team);
	
	void deleteTeamById(Long id);
}
