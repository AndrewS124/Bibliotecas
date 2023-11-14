import { Component } from '@angular/core';

@Component({
  selector: 'app-datos',
  templateUrl: './datos.component.html',
  styleUrls: ['./datos.component.css']
})
export class DatosComponent {

  dato: string = ""

  handleLogin() {
    throw new Error('Method not implemented.');
  }

}
