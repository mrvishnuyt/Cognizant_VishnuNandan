import React from 'react';
import Posts from './Posts'; // Import the Posts component
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* Add the Posts component here */}
        <Posts />
      </header>
    </div>
  );
}

export default App;