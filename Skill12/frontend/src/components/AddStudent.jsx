import { useState } from "react";
import axios from "axios";

function AddStudent({ refresh }) {

  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  const handleChange = (e) => {
    setStudent({
      ...student,
      [e.target.name]: e.target.value
    });
  };

  const addStudent = () => {
    axios.post("http://localhost:8081/students", student)
      .then(() => {
        setStudent({ name: "", email: "", course: "" });
        refresh();
      });
  };

  return (
    <div>
      <h2>Add Student</h2>

      <input name="name" placeholder="Name" value={student.name} onChange={handleChange} />
      <input name="email" placeholder="Email" value={student.email} onChange={handleChange} />
      <input name="course" placeholder="Course" value={student.course} onChange={handleChange} />

      <button onClick={addStudent}>Add</button>
    </div>
  );
}

export default AddStudent;