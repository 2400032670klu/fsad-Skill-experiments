import { useEffect, useState } from "react";
import axios from "axios";

function Profile() {
  const [user, setUser] = useState({});

  useEffect(() => {
    const username = localStorage.getItem("user");

    axios.get(`http://localhost:8082/user/${username}`)
      .then(res => setUser(res.data));
  }, []);

  return (
    <div>
      <h2>Profile</h2>
      <p>{user.username}</p>
    </div>
  );
}
export default Profile;