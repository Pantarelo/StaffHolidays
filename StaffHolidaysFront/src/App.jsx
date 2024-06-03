import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './pages/home';
import Employee from './pages/employee';
import Holiday from './pages/holiday';

function App() {

  return (
     <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route index element={<Home />} />
          <Route  path="employee">
            <Route path=":employeeId" element={<Employee/>}>
            </Route>
          </Route>
          <Route  path="holiday">
            <Route path=":holidayId" element={<Holiday/>}>
            </Route>
          </Route>
          {/* <Route path="blogs" element={<Blogs />} />
          <Route path="contact" element={<Contact />} />
          <Route path="*" element={<NoPage />} /> */}
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
