
import { Routes, Route } from "react-router-dom";

import EmployeesPage from "./pages/EmployeesPage";
import QrPage from "./pages/QrPage";

function App() {
  return (
      <Routes>
        <Route
            path="/"
            element={<EmployeesPage />}
        />

        <Route
            path="/qr/:id"
            element={<QrPage />}
        />
      </Routes>
  );
}

export default App;
