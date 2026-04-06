import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

  const [students, setStudents] = useState([
    { id: 1, name: "Indra", course: "CSE" },
    { id: 2, name: "Rahul", course: "ECE" },
    { id: 3, name: "Anu", course: "IT" },
    { id: 4, name: "Kiran", course: "MECH" },
    { id: 5, name: "Divya", course: "CIVIL" }
  ]);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({
      ...newStudent,
      [name]: value
    });
  };

  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      alert("Fill all fields");
      return;
    }

    setStudents([...students, newStudent]);

    setNewStudent({ id: "", name: "", course: "" });
  };

  const deleteStudent = (id) => {
    const updated = students.filter((s) => s.id !== id);
    setStudents(updated);
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      <div className="form">
        <input type="number" name="id" placeholder="ID" value={newStudent.id} onChange={handleChange} />
        <input type="text" name="name" placeholder="Name" value={newStudent.name} onChange={handleChange} />
        <input type="text" name="course" placeholder="Course" value={newStudent.course} onChange={handleChange} />

        <button onClick={addStudent}>Add</button>
      </div>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.course}</td>
                <td>
                  <button className="delete" onClick={() => deleteStudent(s.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;