import React from "react";
import "./App.css";
import officeImage from "./office.jpg";

function App() {
  const heading = "Office Space";
  const jsxImage = (
    <img
      src={officeImage}
      width="30%"
      height="30%"
      alt="Office Space"
      style={{ borderRadius: "10px" }}
    />
  );

  const officeItem = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai",
  };

  const officeList = [
    { Name: "WeWork", Rent: 75000, Address: "Bangalore" },
    { Name: "Regus", Rent: 58000, Address: "Pune" },
    { Name: "Innov8", Rent: 62000, Address: "Hyderabad" },
    { Name: "SmartSpace", Rent: 45000, Address: "Kolkata" },
  ];
  const getRentColor = (rent) => {
    return rent <= 60000 ? "textRed" : "textGreen";
  };

  return (
    <div className="App">
      <h1>{heading}, at Affordable Range</h1>
      {jsxImage}

      <h3>Name: {officeItem.Name}</h3>
      <h3 className={getRentColor(officeItem.Rent)}>
        Rent: ₹{officeItem.Rent}
      </h3>
      <h3>Address: {officeItem.Address}</h3>

      <h2>Office Listings</h2>
      <ul>
        {officeList.map((item, index) => (
          <li key={index}>
            <strong>{item.Name}</strong> -
            <span className={getRentColor(item.Rent)}> ₹{item.Rent} </span> -
            {item.Address}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
