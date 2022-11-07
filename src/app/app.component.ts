import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Crud Josue Vasquez Martinez';

  constructor(private router:Router){}
  Nuevo() {
    this.router.navigate(["registrar"]);
  }
  Listar() {
    this.router.navigate(["empleados"]);
  }
}
