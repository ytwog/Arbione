import logo from './logo.svg';
import './App.css';
import ArbiTable from './element/ArbiTable';
import React from 'react'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p className="App-name">Arbione application</p>
      </header>
      <div>
          <ArbiTable/>
      </div>
    </div>
  );
}

export default App;
