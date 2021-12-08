package com.example.ipl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ipl.entity.Player;
import com.example.ipl.repository.PlayerRepository;
import com.example.ipl.repository.TeamRepository;
import com.example.ipl.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	private PlayerRepository playerRepository;
	
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}

	@Override
	public List<Player> getAllPlayers() {
		System.out.println("in player");
		return playerRepository.findAll();
	}

	@Override
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player getPlayerById(Long id) {
		return playerRepository.findById(id).get();
	}

	@Override
	public Player updatePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public void deletePlayerById(Long id) {
		playerRepository.deleteById(id);
	}

}
