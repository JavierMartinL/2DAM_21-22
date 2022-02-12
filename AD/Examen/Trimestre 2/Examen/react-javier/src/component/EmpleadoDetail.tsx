import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import { IEmpleado } from '../interface/IEmpleado';

interface IState {
  empleado: IEmpleado;
}

export default function EmpleadoDetail() {

  const [empleado, setEmpleado] = useState<IState>({ empleado: {} as IEmpleado });

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(
    () => {
      const getEmpleado = async () => {
        let rutaEmpleado: string = "http://localhost:8080/empleados/" + id;
        let respuesta = await axios.get(rutaEmpleado);
        console.log(respuesta.data);
        setEmpleado({ empleado: respuesta.data });
      }
      getEmpleado();
    },
    []
  );

  const eliminarEmpleadoApi = async () => {
    let ruta: string = "http://localhost:8080/empleados/" + id;
    try {
      const { data } = await axios.delete(ruta)
      console.log(data);
      navigate('/');
    } catch (error) {
      console.log(error);
    }
  }

  const editarEmpleado = () => {
    navigate("/empleados/" + id + "/update")
  }

  const navegarAtras = () => {
    navigate('/empleados');
  }

  return (
    <div>
      <div>
        <p><b>Id: </b>{empleado.empleado.id}</p>
      </div>
      <div>
        <p><b>Nombre: </b>{empleado.empleado.nombre}</p>
      </div>
      <div>
        <p><b>Apellidos: </b>{empleado.empleado.apellidos}</p>
      </div>
      <div>
        <p><b>Fecha Contrato: </b>{empleado.empleado.fechaContrato}</p>
      </div>
      <div>
        <p><b>Numero: </b>{empleado.empleado.numero}</p>
      </div>
      <div>
        <p><b>Municipio: </b>{empleado.empleado.municipio}</p>
      </div>
      <div>
        <p><b>Calle: </b>{empleado.empleado.calle}</p>
      </div>
      <button onClick={editarEmpleado}>Modificar Empleado</button>
    </div>
  );
};
