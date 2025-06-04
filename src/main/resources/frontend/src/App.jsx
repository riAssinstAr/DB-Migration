import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import SqlDashboard from "./pages/SqlDashboard";
import MongoDashboard from "./pages/MongoDashboard";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/dashboard/sql" element={<SqlDashboard />} />
        <Route path="/dashboard/mongo" element={<MongoDashboard />} />
      </Routes>
    </Router>
  );
}

export default App;
