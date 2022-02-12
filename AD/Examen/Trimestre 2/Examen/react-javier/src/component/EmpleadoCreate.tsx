import React, { FormEvent } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function EmpleadoCreate() {

  const navigate = useNavigate();

  const agregarEmpleadoApi = (event: FormEvent<HTMLFormElement>) => {
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

    const newEmpleado = {
        "apellidos": apellidos,
        "calle": calle,
        "fechaContrato": fechaContrato,
        "municipio": municipio,
        "nombre": nombre,
        "numero": numero
    }
    
    const axiosPost = async (rutaEmpleado: string) => {
      try {
        const { data } = await axios.post(rutaEmpleado, newEmpleado)
        console.log(data);
        navigate('/empleados');
      } catch (error) {
        console.log(error);
      }
    }

    axiosPost("http://localhost:8080/empleados");
  }

  return (
    <div>
      <div>
        <h3>Crear un nuevo Empleado</h3>
      </div>
      <div>
        <form onSubmit={agregarEmpleadoApi}>
        <label>Nombre: </label>
        <input type="text" id="nombre" /> <br /><br />
        <label>Apellidos: </label>
        <input type="text" id="apellidos" /> <br /><br />
        <label>Fecha Contrato: </label>
        <input type="text" id="fechaContrato" placeholder='dd/MM/yyyy' /> <br /><br />
        <label>Numero: </label>
        <input type="text" id="numero" /> <br /><br />
        <label>Municipio: </label>
        <input type="text" id="municipio" /> <br /><br />
        <label>Calle: </label>
        <input type="text" id="calle" /> <br /><br />
        <button type="submit">Crear</button>
        </form>
      </div>
    </div>
  );
};
