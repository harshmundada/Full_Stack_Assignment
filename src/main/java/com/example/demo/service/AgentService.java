package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modle.Agent;
import com.example.demo.modle.User;
import com.example.demo.repo.AgentRepository;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public Agent createAgent(User user) {
        Agent agent = new Agent();
        agent.setAgentId(UUID.randomUUID().toString());
        agent.setStatus("Active");
        agent.setUser(user);
        return agentRepository.save(agent);
    }

    public List<Agent> getAgentsForUser(User user) {
        return agentRepository.findByUser(user);
    }

    public void updateAgentStatus(String agentId, String status) {
        Agent agent = agentRepository.findByAgentId(agentId);
        if (agent != null) {
            agent.setStatus(status);
            agentRepository.save(agent);
        }
    }
}
