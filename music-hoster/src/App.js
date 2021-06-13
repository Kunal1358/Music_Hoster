import React, { Component } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Homepage from "./components/homepage.component"
import Login from "./components/login.component";
import SignUp from "./components/signup.component";
import dashboard from './components/dashboard.component';
import { red } from '@material-ui/core/colors';
import { Hidden } from '@material-ui/core';

class App extends Component {
  /*constructor() {
    super();
    this.state = {
      name: "React",
      App: false,
      outer: false,
      inner: false
    };
    this.hideComponent = this.hideComponent.bind(this);
  }
  hideComponent(varname) {
    console.log(varname);
    switch (varname) {
      case "App":
        this.setState({ App: !this.state.App });
        break;
      case "inner":
        this.setState({ inner: !this.state.inner });
        break;
      case "outer":
        this.setState({ outer: !this.state.outer });
        break;
      default: return;
    }
  }*/
  render(){
   // const { App,outer,inner } = this.state;

  return (<Router>
    <div className="App">
      <nav className="navbar navbar-expand-lg navbar-light fixed-top">
        <div className="container">
          <Link className="navbar-brand" to={"/homepage"}>MusicHoster</Link>
          <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link className="nav-link" to={"/sign-up"}>Sign up</Link>
                </li>
                <li className="nav-item">
                <Link className="nav-link" to={"/sign-in"}>Sign in</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      

      <Switch><Route path="/dashboard" component={dashboard}  />
            <Route exact path="/" component={Homepage} />
            <Route exact path="/homepage" component={Homepage} />
            <Route exact path="/sign-in" component={Login} />
            <Route exact path="/sign-up" component={SignUp} />
            
          </Switch>
    </div></Router>
  );
}
}

export default App;
