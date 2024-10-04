import React from 'react';
import axios from 'axios';

const PurchaseAgent = ({ userId }) => {
    const handlePurchase = () => {
        axios.post(`/api/agents/purchase`, { userId })
            .then(response => {
                alert('Agent purchased successfully');
            })
            .catch(error => {
                alert('Failed to purchase agent');
            });
    };

    return (
        <div>
            <button onClick={handlePurchase}>Purchase New Agent</button>
        </div>
    );
};

export default PurchaseAgent;
