import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  const buttonStyle = theme === "dark" ? "btn btn-dark" : "btn btn-light";

  return (
    <div className="card">
      <h3>{employee.name}</h3>
      <p>{employee.designation}</p>
      <button className={buttonStyle}>View</button>
    </div>
  );
}

export default EmployeeCard;
