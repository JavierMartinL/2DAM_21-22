import React from 'react';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import EmpleadoComponent from './EmpleadoComponent';
import EmpleadoDetail from './EmpleadoDetail';
import EmpleadoCreate from './EmpleadoCreate';
import EmpleadoUpdate from './EmpleadoUpdate';

export default function App() {
  return (
    <div className="container-fluid">
      <BrowserRouter>
        <Navbar />

        <Routes>
          <Route path="/" element={<EmpleadoComponent />} />
          <Route path="/empleados" element={<EmpleadoComponent />} />
          <Route path="/empleados/crear" element={<EmpleadoCreate />} />
          <Route path="/empleados/:id" element={<EmpleadoDetail />} />
          <Route path="/empleados/:id/update" element={<EmpleadoUpdate />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

function Navbar() {
  return (
    <nav>
      <button><Link to="/">Empleados</Link></button>
      <button><Link to="/empleados/crear">Crear Empleado</Link></button>
    </nav>
  )
}