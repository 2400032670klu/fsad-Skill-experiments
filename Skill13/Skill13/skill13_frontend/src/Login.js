import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Login() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleLogin = async () => {
    const res = await axios.post("http://localhost:8082/login", user);

    if (res.data) {
      localStorage.setItem("user", res.data.username);
      navigate("/home");
    } else {
      alert("Invalid");
    }
  };

 return (
  <div style={{ textAlign: "center", marginTop: "50px" }}>
    <h2>Login</h2>

    <input 
      placeholder="Username"
      onChange={e => setUser({...user, username: e.target.value})}
      style={{ padding: "8px", margin: "10px" }}
    />

    <br />

    <input 
      type="password"
      placeholder="Password"
      onChange={e => setUser({...user, password: e.target.value})}
      style={{ padding: "8px", margin: "10px" }}
    />

    <br />

    <button onClick={handleLogin} style={{ padding: "8px 20px" }}>
      Login
    </button>
  </div>
);
}
export default Login;