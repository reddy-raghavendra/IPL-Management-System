package com.example.ipl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ipl.entity.Team;
import com.example.ipl.repository.TeamRepository;
import com.example.ipl.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	
	private TeamRepository teamRepository;
	
	public TeamServiceImpl(TeamRepository teamRepository) {
		super();
		this.teamRepository = teamRepository;
	}

	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepository.findAll();
	}

	@Override
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team getTeamById(Long id) {
		return teamRepository.findById(id).get();
	}

	@Override
	public Team updateTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public void deleteTeamById(Long id) {
		teamRepository.deleteById(id);
	}

}
