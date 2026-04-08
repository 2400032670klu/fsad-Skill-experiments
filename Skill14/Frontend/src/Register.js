import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Register() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleSubmit = async () => {
    await axios.post("http://localhost:8082/register", user);
    alert("Registered");
    navigate("/login");
  };

  return (
    <div>
      <h2>Register</h2>
      <input placeholder="Username" onChange={e => setUser({...user, username: e.target.value})}/>
      <input placeholder="Password" onChange={e => setUser({...user, password: e.target.value})}/>
      <button onClick={handleSubmit}>Register</button>
    </div>
  );
}
export default Register;