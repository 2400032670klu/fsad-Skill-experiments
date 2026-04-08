import axios from "axios";
import { useState, useEffect } from "react";

function App() {
  const [name, setName] = useState("");
  const [data, setData] = useState([]);

  const load = () => {
    axios.get("http://localhost:8082/students")
      .then(res => setData(res.data));
  };

  useEffect(() => {
    load();
  }, []);

  const add = () => {
    axios.post("http://localhost:8082/students", { name })
      .then(() => {
        setName("");
        load();
      });
  };

  return (
    <div>
      <h2>Skill 13 App</h2>

      <input 
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Enter name"
      />
      <button onClick={add}>Add</button>

      {data.map(s => (
        <p key={s.id}>{s.name}</p>
      ))}
    </div>
  );
}

export default App;