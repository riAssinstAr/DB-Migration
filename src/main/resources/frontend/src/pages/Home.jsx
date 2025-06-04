import "./Home.css";
import logo from "../assets/react.svg";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

function Home() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    // Step 1: Validate login
    const loginResponse = await fetch("http://localhost:8081/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    });

    if (!loginResponse.ok) {
      alert("Invalid credentials");
      return;
    }

    // Step 2: Trigger migration
    const apiResponse = await fetch("http://localhost:8081/api", {
      headers: {
        "X-USER": username,
      },
    });

    if (apiResponse.ok) {
      const message = await apiResponse.text();
      alert(message);
    } else {
      alert("Failed to trigger migration.");
    }
  };

  return (
    <>
      <div className="home">
        <h1 className="home-title">Welcome to the Migration Tool !</h1>
        <div className="row">
          <button
            onClick={() => navigate("/dashboard/sql")}
            type="button"
            className="sql-button"
          >
            &gt;&gt; PostgresSQl
          </button>
          <form className="home-form" onSubmit={handleLogin}>
            <img className="image" src={logo} alt="" />
            <p className="home-description">This was built with React</p>
            <input
              type="text"
              placeholder="Enter your username..."
              className="home-input"
              id="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
            <input
              type="password"
              placeholder="Enter your password..."
              className="home-input"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />

            <button type="submit" className="home-button">
              Submit
            </button>
          </form>
          <button
            onClick={() => navigate("/dashboard/mongo")}
            type="button"
            className="mongo-button"
          >
            &gt;&gt; MongoDB
          </button>
        </div>
        <h2 className="home-h2">** Instructions **</h2>
        <div className="home-para">
          <p className="home-p">
            &gt;&gt; Check out the PostgresSQL database for user information
          </p>
          <p className="home-p">
            &gt;&gt; Pick any one user's information to enter into the login
            form
          </p>
          <p className="home-p">
            &gt;&gt; Submit the username and password for the user you selected
          </p>
          <p className="home-p">
            &gt;&gt; Go to the MongoDB database and check if the data has been
            migrated
          </p>
        </div>
        <p className="home-copy">- DB Migrator 1.0.0 &#169; 2025 -</p>
      </div>
    </>
  );
}

export default Home;
