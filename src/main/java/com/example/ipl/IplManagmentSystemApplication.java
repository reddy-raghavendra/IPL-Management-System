package com.example.ipl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.ipl.entity.Player;
import com.example.ipl.entity.Team;
import com.example.ipl.repository.PlayerRepository;
import com.example.ipl.repository.TeamRepository;

@SpringBootApplication
@ComponentScan("com.example.ipl")
@EntityScan("com.example.ipl.entity")
@EnableJpaRepositories("com.example.ipl.repository")
public class IplManagmentSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IplManagmentSystemApplication.class, args);
	}

	@Autowired(required = true)
	private TeamRepository teamRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Override
	public void run(String... args) throws Exception {		
	}

}
