import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from './empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  //conexion a la APIsRest
  private baseURL = "http://localhost:8080/api/v1/empleados";

  constructor(private HttpClient:HttpClient) { }

    //metodo que obtendra todos los Usuarios registrados
  obtenerListaEmpleados():Observable<Empleado[]>{
    return this.HttpClient.get<Empleado[]>(`${this.baseURL}`);
  }
  //metpdp que obtendremos el empleado registrado por ID
  obtenerEmpleadoId(id:number):Observable<Empleado>{
    return this.HttpClient.get<Empleado>(`${this.baseURL}/${id}`);
  }
    //metodo para poder guardar a los Usuarios
  registrarEmpleado(empleado:Empleado):Observable<Object>{
    return this.HttpClient.post(`${this.baseURL}`,empleado);
  }
  
  actualizarEmpleado(id:number, empleado:Empleado):Observable<Object>{
    return this.HttpClient.put(`${this.baseURL}/${id}`,empleado);
  }
  eliminarEmpleado(id:number):Observable<Object>{
    return this.HttpClient.delete(`${this.baseURL}/${id}`);
  }

  
}
