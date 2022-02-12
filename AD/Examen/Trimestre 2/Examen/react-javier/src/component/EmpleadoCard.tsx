import React from 'react'
import { IEmpleado } from '../interface/IEmpleado';
import { useNavigate } from 'react-router-dom';

interface IProps {
  empleado: IEmpleado
}

export default function EmpleadoCard(props: IProps) {

  const navigate = useNavigate();
  
  function mostrarDetalleEmpleado() {
    navigate("/empleados/" + props.empleado.id);
  }

  return (
    <div onClick={mostrarDetalleEmpleado}>
      <h5 >{props.empleado.nombre} {props.empleado.apellidos}</h5>
    </div>
  )
}
