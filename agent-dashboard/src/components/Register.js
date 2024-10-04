import React, { useState } from 'react';
import axios from 'axios';

const Register = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleRegister = async (e) => {
        e.preventDefault(); // Prevent the default form submission
        try {
            // API call to register the user
            const response = await axios.post('http://localhost:8080/api/users/register', { username, password });
            alert('Registration Successful');
            // Optionally reset the form or redirect the user here
        } catch (error) {
            console.error('Registration failed:', error.response.data); // Log the error response
            alert('Registration Failed: ' + (error.response.data.message || 'An error occurred'));
        }
    };

    return (
        <div className="form-container">
            <h2>Register</h2>
            <form onSubmit={handleRegister}>
                <input 
                    type="text" 
                    placeholder="Username" 
                    value={username} 
                    onChange={(e) => setUsername(e.target.value)} 
                    required 
                />
                <input 
                    type="password" 
                    placeholder="Password" 
                    value={password} 
                    onChange={(e) => setPassword(e.target.value)} 
                    required 
                />
                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default Register;
