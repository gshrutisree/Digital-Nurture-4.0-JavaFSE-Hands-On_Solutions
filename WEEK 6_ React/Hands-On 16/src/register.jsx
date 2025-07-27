import React, { Component } from "react";

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: "",
      email: "",
      password: "",
      errors: {
        fullName: "",
        email: "",
        password: "",
      },
    };
  }

  validateForm = (errors) => {
    return !Object.values(errors).some((error) => error.length > 0);
  };

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case "fullName":
        errors.fullName =
          value.length < 5
            ? "Full Name must be at least 5 characters long!"
            : "";
        break;

      case "email":
        const validEmailRegex = RegExp(/^[^\s@]+@[^\s@]+\.[^\s@]+$/);
        errors.email = validEmailRegex.test(value) ? "" : "Email is not valid!";
        break;

      case "password":
        errors.password =
          value.length < 8 ? "Password must be 8 characters long!" : "";
        break;

      default:
        break;
    }

    this.setState({ errors, [name]: value });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    if (this.validateForm(this.state.errors)) {
      alert("Valid Form");
    } else {
      const { errors } = this.state;
      if (errors.fullName) alert(errors.fullName);
      if (errors.email) alert(errors.email);
      if (errors.password) alert(errors.password);
    }
  };

  render() {
    const { errors } = this.state;

    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1 style={{ color: "red" }}>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name: </label>
            <input type="text" name="fullName" onChange={this.handleChange} />
          </div>
          <br />
          <div>
            <label>Email: </label>
            <input type="text" name="email" onChange={this.handleChange} />
          </div>
          <br />
          <div>
            <label>Password: </label>
            <input
              type="password"
              name="password"
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

export default Register;
