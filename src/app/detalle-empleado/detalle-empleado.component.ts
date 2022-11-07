import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-detalle-empleado',
  templateUrl: './detalle-empleado.component.html',
  styleUrls: ['./detalle-empleado.component.css']
})
export class DetalleEmpleadoComponent implements OnInit {

  id:number;
  empleado:Empleado;

  constructor( private rout:ActivatedRoute, private empleadoServicio:EmpleadoService) { }

  ngOnInit(): void {
    this.id = this.rout.snapshot.params['id'];
    this.empleado = new Empleado();
    this.empleadoServicio.obtenerEmpleadoId(this.id).subscribe(dato => {
      this.empleado = dato;
    });

  }

}
