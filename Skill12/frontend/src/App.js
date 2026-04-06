import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";

function App() {
  return (
    <div>
      <AddStudent refresh={() => window.location.reload()} />
      <StudentList />
    </div>
  );
}

export default App;