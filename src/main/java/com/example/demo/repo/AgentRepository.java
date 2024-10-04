package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modle.Agent;
import com.example.demo.modle.User;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    List<Agent> findByUser(User user);
    Agent findByAgentId(String agentId);
}