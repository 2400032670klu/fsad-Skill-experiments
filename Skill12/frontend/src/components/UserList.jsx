import { useState, useEffect } from "react";

function UserList() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(res => res.json())
      .then(res => setData(res));
  }, []);

  return (
    <div>
      <h2>API Users</h2>
      {data.map(u => (
        <div key={u.id}>
          <p>{u.name}</p>
          <p>{u.email}</p>
          <p>{u.phone}</p>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default UserList;