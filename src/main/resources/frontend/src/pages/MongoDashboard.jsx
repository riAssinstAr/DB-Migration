import "./MongoDashboard.css";
import { useEffect, useState } from "react";
import axios from "axios";

function MongoDashboard() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8081/all-mongo")
      .then((res) => setUsers(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="mongo-dashboard">
      <h1 className="mongo-users">MongoDB Users</h1>
      <div className="mongo-row mongo-header">
        <div className="mongo-cell">Employee ID</div>
        <div className="mongo-cell">Username</div>
        <div className="mongo-cell">Password</div>
        <div className="mongo-cell">Bonus Status</div>
      </div>

      {users.map((user, i) => (
        <div className="mongo-row" key={i}>
          <div className="mongo-cell">{user.id}</div>
          <div className="mongo-cell">{user.username}</div>
          <div className="mongo-cell">{user.password}</div>
          <div className="mongo-cell">
            {user.bonus == "t" ? "True" : "False"}
          </div>
        </div>
      ))}
    </div>
  );
}

export default MongoDashboard;
