import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-lista-empleado',
  templateUrl: './lista-empleado.component.html',
  styleUrls: ['./lista-empleado.component.css']
})
export class ListaEmpleadoComponent implements OnInit {
  

  empleados: Empleado[];
 

  constructor(private empleadoServicio:EmpleadoService,private router:Router) { }

  ngOnInit(): void {
    this.obtenerEmpleados();
    
  }
  Nuevo() {
    this.router.navigate(["registrar"]);
  }
  Listar() {
    this.router.navigate(["empleados"]);
  }

    private obtenerEmpleados(){
      this.empleadoServicio.obtenerListaEmpleados().subscribe(dato=>{
        this.empleados=dato;
      });
    }
    detalleEmpleado(id:number){
      this.router.navigate(['detalle',id]);
    }

   eliminarEmpleado(id:number){
    
    this.empleadoServicio.eliminarEmpleado(id).subscribe(dato =>{
      console.log(dato);
      this.obtenerEmpleados();
    })
  }
    actualizarEmpleado(id:number){
    this.router.navigate(['actualizar',id])

    };

}
