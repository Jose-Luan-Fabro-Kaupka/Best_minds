import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private url = 'http://localhost:8081/produtos';

  constructor(private http: HttpClient) { }

  getProdutos(): Observable<any[]> {
    return this.http.get<any[]>(this.url);
  }

  getProdutoById(id: string): Observable<any> {
    return this.http.get<any>(`${this.url}/${id}`);
  }

  updateProduto(id: string, produto: any): Observable<any> {
    return this.http.put<any>(`${this.url}/${id}`, produto);
  }

  createProduto(produto: any): Observable<any> {
    return this.http.post<any>(this.url, produto);
  }

  deleteProduto(id: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${id}`);
  }
}
