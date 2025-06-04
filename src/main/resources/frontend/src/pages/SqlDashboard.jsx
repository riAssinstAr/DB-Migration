import "./SqlDashboard.css";
import { useEffect, useState } from "react";
import axios from "axios";

function SqlDashboard() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8081/all-sql")
      .then((res) => setUsers(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="sql-dashboard">
      <h1 className="sql-users">PostgresSQL Users</h1>
      <div className="sql-row sql-header">
        <div className="sql-cell">Employee ID</div>
        <div className="sql-cell">Username</div>
        <div className="sql-cell">Password</div>
        <div className="sql-cell">Bonus Status</div>
      </div>

      {users.map((user, i) => (
        <div className="sql-row" key={i}>
          <div className="sql-cell">{user.id}</div>
          <div className="sql-cell">{user.username}</div>
          <div className="sql-cell">{user.password}</div>
          <div className="sql-cell">{user.bonus == "t" ? "True" : "False"}</div>
        </div>
      ))}
    </div>
  );
}

export default SqlDashboard;
