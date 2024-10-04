package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.AgentStatusUpdateRequest;
import com.example.demo.modle.Agent;
import com.example.demo.modle.User;
import com.example.demo.service.AgentService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/agents")
public class AgentController {
    
    @Autowired
    private AgentService agentService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Agent>> getAgents(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        List<Agent> agents = agentService.getAgentsForUser(user);
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Agent> purchaseAgent(@RequestBody Long userId) {
        User user = userService.findById(userId).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        Agent agent = agentService.createAgent(user);
        return new ResponseEntity<>(agent, HttpStatus.CREATED);
    }

    @PostMapping("/update-status")
    public ResponseEntity<String> updateStatus(@RequestBody AgentStatusUpdateRequest request) {
        // Optional: Validate request here, e.g., check if agentId and status are provided
        agentService.updateAgentStatus(request.getAgentId(), request.getStatus());
        return ResponseEntity.ok("Agent status updated");
    }
}
