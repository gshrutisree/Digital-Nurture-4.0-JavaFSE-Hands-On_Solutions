import React, { useState } from "react";
import EmployeeList from "./EmployeeList";
import ThemeContext from "./ThemeContext";

function App() {
  const [theme, setTheme] = useState("light");

  const toggleTheme = () =>
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management</h1>
        <button onClick={toggleTheme}>Toggle Theme (Current: {theme})</button>
        <EmployeeList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
