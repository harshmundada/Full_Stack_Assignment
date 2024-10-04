import React, { useState } from 'react';
import './App.css';
import Login from './components/Login';
import Dashboard from './components/Dashboard';

function App() {
    const [userId, setUserId] = useState(null); // State to hold logged-in user ID

    const handleLogin = (id) => {
        setUserId(id); // Set user ID on successful login
    };

    return (
        <div className="App">
            <header className="App-header">
                <h1>Agent License Management</h1>
                {!userId ? (
                    <Login onLogin={handleLogin} /> // Render Login if not logged in
                ) : (
                    <Dashboard userId={userId} /> // Render Dashboard if logged in
                )}
            </header>
        </div>
    );
}

export default App;
