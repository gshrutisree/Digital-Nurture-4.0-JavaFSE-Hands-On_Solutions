import React from "react";

export class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0,
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1,
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1,
    }));
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h1>Mall Entry Tracker</h1>
        <p>People Entered: {this.state.entrycount}</p>
        <p>People Exited: {this.state.exitcount}</p>
        <button onClick={this.updateEntry}>Login</button>
        <button onClick={this.updateExit} style={{ marginLeft: "10px" }}>
          Exit
        </button>
      </div>
    );
  }
}
