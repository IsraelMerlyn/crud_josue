import { NgModule } from '@angular/core';
import { ActivatedRoute, RouterModule, Routes } from '@angular/router';
import { ActualizarEmpleadoComponent } from './actualizar-empleado/actualizar-empleado.component';
import { DetalleEmpleadoComponent } from './detalle-empleado/detalle-empleado.component';
import { ListaEmpleadoComponent } from './lista-empleado/lista-empleado.component';
import { RegistrarEmpleadoComponent } from './registrar-empleado/registrar-empleado.component';

const routes: Routes = [
  {
    //al agragar la ruta empleados nos redirigue al componente ListaEmpleadoComponent
    path: 'empleados',component:ListaEmpleadoComponent
  },
  {
    //redireccionamos a la ruta empleados cuando este vacia la ruta
    path:'', redirectTo:'empleados',pathMatch:'full'
  },
  {
    //ruta que nos redigira a la vista de registrar 
    path:'registrar', component:RegistrarEmpleadoComponent
  },
  {
    //ruta que nos redigira a la vista de actializar  
    path:'actualizar/:id', component:ActualizarEmpleadoComponent
  },
  {
    //ruta que nos redigira a la vista detalle de los registros 
    path:'detalle/:id', component:DetalleEmpleadoComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
