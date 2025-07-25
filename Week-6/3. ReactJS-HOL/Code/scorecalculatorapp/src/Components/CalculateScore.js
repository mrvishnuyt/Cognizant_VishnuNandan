import React from 'react';
import '../Stylesheets/mystyle.css'; // Import the stylesheet

const CalculateScore = ({ Name, School, Total, goal }) => {
  // Calculate the average score
  const score = (Total / goal) * 100;

  return (
    <div className="student-card">
      <h2>Student Details 📝</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total Marks:</strong> {Total}</p>
      <p><strong>Goal (Max Marks):</strong> {goal}</p>
      <p className="score"><strong>Average Score:</strong> {score.toFixed(2)}%</p>
    </div>
  );
};

export default CalculateScore;