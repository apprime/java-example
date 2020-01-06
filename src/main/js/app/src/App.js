import React from 'react';
import List from './List';
import Add from './Add';
import 'materialize-css/dist/css/materialize.css';
import {
  BrowserRouter as Router,
  Link,
  Switch,
  Route,
} from "react-router-dom";

function App() {

      return (
        <div className="App">
            <Router basename="/#">
                <nav>
                     <ul>
                        <li>
                            <Link to="/listBoxes">List</Link>
                        </li>
                        <li>
                            <Link to="/addBox">Add</Link>
                        </li>
                    </ul>
                </nav>
                <div className="container">
                    <Switch>
                        <Route path="/listBoxes">
                            <List />
                        </Route>
                        <Route path="/addBox">
                            <Add />
                        </Route>
                    </Switch>
                </div>
            </Router>
        </div>
      );
}

export default App;
