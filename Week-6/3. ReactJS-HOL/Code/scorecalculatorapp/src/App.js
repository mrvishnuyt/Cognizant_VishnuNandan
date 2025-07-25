import React from 'react';
import CalculateScore from './Components/CalculateScore';
import './App.css'; // Default App CSS

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Student Score Calculator 📊</h1>
        <CalculateScore
          Name="Priya Sharma"
          School="Delhi Public School"
          Total={475}
          goal={500}
        />
        <CalculateScore
          Name="Rohan Mehta"
          School="Modern School"
          Total={380}
          goal={400}
        />
      </header>
    </div>
  );
}

export default App;