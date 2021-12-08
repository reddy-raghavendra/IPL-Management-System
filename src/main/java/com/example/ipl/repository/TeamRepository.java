package com.example.ipl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ipl.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
