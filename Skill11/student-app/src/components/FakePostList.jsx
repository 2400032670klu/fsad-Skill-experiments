import { useState, useEffect } from "react";
import axios from "axios";

function FakePostList() {
  const [data, setData] = useState([]);
  const [filter, setFilter] = useState("");

  const loadData = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => setData(res.data.posts));
  };

  useEffect(() => {
    loadData();
  }, []);

  const filteredData = filter
    ? data.filter(p => p.userId == filter)
    : data;

  return (
    <div>
      <h2>Posts</h2>

      <button onClick={loadData}>Refresh</button>

      <br /><br />

      <label>Filter by User ID: </label>
      <select onChange={(e) => setFilter(e.target.value)}>
        <option value="">All</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
      </select>

      {filteredData.map(p => (
        <div key={p.id}>
          <p>{p.title}</p>
          <p>{p.body}</p>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default FakePostList;