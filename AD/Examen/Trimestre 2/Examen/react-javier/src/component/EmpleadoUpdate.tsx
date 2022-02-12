import React, { FormEvent, useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import { IEmpleado } from '../interface/IEmpleado';

interface IState {
  empleado: IEmpleado;
}

export default function EmpleadoUpdate() {

  const [ empleado, setEmpleado ] = useState<IState>({empleado: {} as IEmpleado})

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(
    () => {
      const getEmpleado = async () => {
        let rutaEmpleado: string = "http://localhost:8080/empleados/" + id;
        let respuesta = await axios.get(rutaEmpleado);
        console.log(respuesta);
        setEmpleado({ empleado: respuesta.data });
      }
      getEmpleado();
    },
    []
  );

  const modificarEmpleadoApi = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    let inputNombre: HTMLFormElement = event.currentTarget.nombre;
    let inputApellidos: HTMLFormElement = event.currentTarget.apellidos;
    let inputFechaContrato: HTMLFormElement = event.currentTarget.fechaContrato;
    let inputNumero: HTMLFormElement = event.currentTarget.numero;
    let inputMunicipio: HTMLFormElement = event.currentTarget.municipio;
    let inputCalle: HTMLFormElement = event.currentTarget.calle;

    let nombre: string = inputNombre.value;
    let apellidos: string = inputApellidos.value;
    let fechaContrato: Date = inputFechaContrato.value;
    let numero: number = parseInt(inputNumero.value);
    let municipio: string = inputMunicipio.value;
    let calle: string = inputCalle.value;

    const updateEmpleado = {
        "id": id,
        "apellidos": apellidos,
        "calle": calle,
        "fechaContrato": fechaContrato,
        "municipio": municipio,
        "nombre": nombre,
        "numero": numero
    }
    
    const axiosPost = async (rutaEmpleado: string) => {
      try {
        const { data } = await axios.put(rutaEmpleado, updateEmpleado)
        console.log(data);
        navigate('/empleados/' + id);
      } catch (error) {
        console.log(error);
      }
    }

    axiosPost("http://localhost:8080/empleados/" + id);
  }

  return (
    <div>
      <div>
        <h3>Modificar el Empleado con id: {id}</h3>
      </div>
      <div>
        <form onSubmit={modificarEmpleadoApi}>
        <label>Nombre: </label>
        <input type="text" id="nombre" defaultValue={empleado.empleado.nombre} /> <br /><br />
        <label>Apellidos: </label>
        <input type="text" id="apellidos" defaultValue={empleado.empleado.apellidos} /> <br /><br />
        <label>Fecha Contrato: </label>
        <input type="text" id="fechaContrato" placeholder='dd/MM/yyyy' defaultValue={empleado.empleado.fechaContrato} /> <br /><br />
        <label>Numero: </label>
        <input type="text" id="numero" defaultValue={empleado.empleado.numero} /> <br /><br />
        <label>Municipio: </label>
        <input type="text" id="municipio" defaultValue={empleado.empleado.municipio} /> <br /><br />
        <label>Calle: </label>
        <input type="text" id="calle" defaultValue={empleado.empleado.calle} /> <br /><br />
        <button type="submit">Modificar</button>
        </form>
      </div>
    </div>
  );
};
