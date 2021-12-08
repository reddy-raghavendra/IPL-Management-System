package com.example.ipl.service;

import java.util.List;

import com.example.ipl.entity.Player;
import com.example.ipl.entity.Team;

public interface PlayerService {
	List<Player> getAllPlayers();
	Player savePlayer(Player player);
	Player getPlayerById(Long id);
	Player updatePlayer(Player player);
	void deletePlayerById(Long id);
}
