import { useEffect, useState } from "react";
import axios from "axios";

function StudentList() {
  const [students, setStudents] = useState([]);

  const loadStudents = () => {
    axios.get("http://localhost:8081/students")
      .then(res => setStudents(res.data));
  };

  useEffect(() => {
    loadStudents();
  }, []);

  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8081/students/${id}`)
      .then(() => loadStudents());
  };

  return (
    <div>
      <h2>Student List</h2>
      {students.map(s => (
        <div key={s.id}>
          {s.name} - {s.email} - {s.course}
          <button onClick={() => deleteStudent(s.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
}

export default StudentList;