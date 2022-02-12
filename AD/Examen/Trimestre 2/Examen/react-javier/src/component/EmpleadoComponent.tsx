import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { IEmpleado } from '../interface/IEmpleado';
import EmpleadoCard from './EmpleadoCard';

interface IState {
    empleados: Array<IEmpleado>;
}

export default function AlumnosComponent() {

    const [ empleados, setEmpleados ] = useState<IState>({empleados: new Array<IEmpleado>()});
  
    const navigate = useNavigate();
  
    useEffect(
      () => {
        const getEmpleados = async () => {
          let rutaEmpleados = "http://localhost:8080/empleados";
          let respuesta = await axios.get(rutaEmpleados);
          console.log(respuesta);
          setEmpleados({ empleados: respuesta.data });
        }
        getEmpleados();
      },
      []
    );
  
    return (
      <>
          {
            empleados.empleados?.map((empleado: IEmpleado, index: number) => {
              return (
                <EmpleadoCard key={"emp" + index} empleado={empleado} />
              )
            })
          }
      </>
    )
  }
