import { Component } from '@angular/core';
import { LibroService } from '../libro.service';

@Component({
  selector: 'app-datos',
  templateUrl: './datos.component.html',
  styleUrls: ['./datos.component.css']
})
export class DatosComponent {

  nombre: string = '';
  autor: string = '';
  idBiblioteca: number = 0;

  constructor(private libroService: LibroService ) {}

  agregarLibro() {
    if (this.nombre && this.autor && this.idBiblioteca) {
      this.libroService.agregarLibro(this.nombre, this.autor, this.idBiblioteca).subscribe(
        (res) => {
          console.log('Libro agregado correctamente:', res);
        },
        (error) => {
          console.error('Error al agregar el libro:', error);
        }
      );
    } else {
      console.error('Debe ingresar valores para nombre, autor y ID de la biblioteca');
    }
  }
  libros: any[] = [];

  ngOnInit() {
    this.obtenerLibros();
  }

  obtenerLibros() {
    this.libroService.getLibros().subscribe(
      (res) => {
        console.log('Respuesta del servicio:', res); 
        this.libros = res; 
      },
      (error) => {
        console.error('Error al obtener libros:', error);
      }
    );
  }
  

}
