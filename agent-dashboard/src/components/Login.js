import React, { useState } from 'react';
import axios from 'axios';

const Login = ({ onLogin }) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(''); // State to hold error messages

    const handleLogin = async (e) => {
        e.preventDefault(); // Prevent default form submission
        try {
            const response = await axios.post('http://localhost:8080/api/users/login', { username, password });

            // Handle successful login
            if (response.data && response.data.userId) {
                alert('Login Successful');
                onLogin(response.data.userId); // Pass the userId to the parent component
            } else {
                alert('Login Failed: Invalid response from server');
            }

        } catch (error) {
            console.error('Login failed:', error); // Log the entire error object

            // Enhanced error handling based on the type of error
            let message = 'An unexpected error occurred';
            
            // Check if error.response exists before accessing data
            if (error.response) {
                if (error.response.data && error.response.data.message) {
                    message = error.response.data.message; // Specific error from backend
                } else if (error.response.status === 401) {
                    message = 'Invalid credentials. Please try again.';
                } else if (error.response.status === 404) {
                    message = 'API endpoint not found.';
                } else {
                    message = `Error: ${error.response.status}`;
                }
            } else if (error.request) {
                message = 'No response from the server. Please check your network connection.';
            }

            alert(message); // Display error message to user
            setError(message); // Set the error message in state for UI display
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
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
                <button type="submit">Login</button>
            </form>
            {error && <p style={{ color: 'red' }}>{error}</p>} {/* Display error if present */}
        </div>
    );
};

export default Login;
