import React from "react";

export function OddPlayers([first, , third, , fifth]) {
  return (
    <div>
      <h3>Odd Team Players</h3>
      <ul>
        <li>First: {first}</li>
        <li>Third: {third}</li>
        <li>Fifth: {fifth}</li>
      </ul>
    </div>
  );
}

export function EvenPlayers([, second, , fourth, , sixth]) {
  return (
    <div>
      <h3>Even Team Players</h3>
      <ul>
        <li>Second: {second}</li>
        <li>Fourth: {fourth}</li>
        <li>Sixth: {sixth}</li>
      </ul>
    </div>
  );
}

function IndianPlayers() {
  const T20Players = ["Virat", "Rohit", "Hardik"];
  const RanjiTrophyPlayers = ["Pujara", "Rahane", "Saha"];

  const allPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Merged Indian Players</h2>
      <ul>
        {allPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <OddPlayers {...[allPlayers]} />
      <EvenPlayers {...[allPlayers]} />
    </div>
  );
}

export default IndianPlayers;
