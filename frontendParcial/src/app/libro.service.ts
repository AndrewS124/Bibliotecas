import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  private urlApi = 'http://localhost:8080/Libro/';

  constructor(private http: HttpClient) {}

  public getLibros(): Observable<any> {
    return this.http.get<any>(this.urlApi);
  }

  public agregarLibro(nombre: string, autor: string, bibliotecaId: number): Observable<any> {
    const nuevoLibro = { nombre, autor, bibliotecaId };
    return this.http.post(this.urlApi, nuevoLibro);
  }



}
