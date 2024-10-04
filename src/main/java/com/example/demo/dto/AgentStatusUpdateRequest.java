package com.example.demo.dto;

public class AgentStatusUpdateRequest {

	private String agentId;
    private String status;

    // Constructors
    public AgentStatusUpdateRequest() {}

    public AgentStatusUpdateRequest(String agentId, String status) {
        this.agentId = agentId;
        this.status = status;
    }

    // Getters and Setters
    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
