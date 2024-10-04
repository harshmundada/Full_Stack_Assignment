import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Dashboard = ({ userId }) => {
    const [agents, setAgents] = useState([]);

    useEffect(() => {
        axios.get(`/api/agents/${userId}`)
            .then(response => {
                setAgents(response.data);
            })
            .catch(error => {
                console.error('Error fetching agents', error);
            });
    }, [userId]);

    return (
        <div>
            <h2>Agent Dashboard</h2>
            <ul>
                {agents.map(agent => (
                    <li key={agent.agentId}>
                        Agent ID: {agent.agentId}, Status: {agent.status}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Dashboard;
