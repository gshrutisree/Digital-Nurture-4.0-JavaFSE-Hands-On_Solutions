import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: "",
      complaint: "",
      NumberHolder: Math.floor(Math.random() * 100) + 1,
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const msg =
      "Thanks " +
      this.state.ename +
      "\nYour Complaint was Submitted.\nTransaction ID is: " +
      this.state.NumberHolder;

    alert(msg);

    this.setState({
      ename: "",
      complaint: "",
      NumberHolder: Math.floor(Math.random() * 100) + 1,
    });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h2 style={{ color: "red" }}>Register your complaints here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name:&nbsp;</label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
            />
          </div>
          <br />
          <div>
            <label>Complaint:&nbsp;</label>
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
            />
          </div>
          <br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
