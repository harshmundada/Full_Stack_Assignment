import React, { useState } from 'react';
import './App.css';
import Login from './components/Login';
import Register from './components/Register';
import Dashboard from './components/Dashboard';
import PurchaseAgent from './components/PurchaseAgent';

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
                    <>
                        <Login onLogin={handleLogin} />
                        <Register />
                    </>
                ) : (
                    <>
                        <Dashboard userId={userId} />
                        <PurchaseAgent userId={userId} />
                    </>
                )}
            </header>
        </div>
    );
}

export default App;
