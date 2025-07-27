import React, { Component } from "react";
import "./App.css";

class CurrencyConverter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: "",
      euro: "",
    };
  }

  handleInputChange = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const rupees = parseFloat(this.state.rupees);
    const euro = (rupees / 90).toFixed(2);
    this.setState({ euro });
  };

  render() {
    return (
      <div className="converter">
        <h2 className="green-heading">Currency Converter</h2>

        <div className="form-row">
          <label>Amount:</label>
          <input
            type="number"
            placeholder="Enter amount"
            value={this.state.rupees}
            onChange={this.handleInputChange}
          />
        </div>

        <div className="form-row">
          <label>Currency:</label>
          <input type="text" value="EURO" readOnly />
        </div>

        <button className="submit-btn" onClick={this.handleSubmit}>
          Submit
        </button>

        {this.state.euro && <p>Converted: €{this.state.euro}</p>}
      </div>
    );
  }
}

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };
  }

  increment = () => {
    this.setState((prevState) => ({ count: prevState.count + 1 }));
    this.sayHello();
  };

  sayHello = () => {
    console.log("Hello! Static Message.");
  };

  decrement = () => {
    this.setState((prevState) => ({ count: prevState.count - 1 }));
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  onPress = (event) => {
    alert("I was clicked!");
  };

  render() {
    return (
      <div className="App">
        <div className="button-column">
          <button onClick={this.increment}>Increment</button>
          <button onClick={this.decrement}>Decrement</button>
          <button onClick={() => this.sayWelcome("Welcome!")}>
            Say Welcome
          </button>
          <button onClick={this.onPress}>Synthetic OnPress</button>
        </div>

        <CurrencyConverter />
      </div>
    );
  }
}

export default App;
