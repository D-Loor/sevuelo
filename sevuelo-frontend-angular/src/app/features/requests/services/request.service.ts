import { inject, Injectable } from '@angular/core';
import { Request } from '../models/request.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  private readonly httpClient = inject(HttpClient);
  private url = environment.apiUrl + 'requests';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getRequests(): Observable<Request[]> {
    return this.httpClient.get<Request[]>(this.url);
  }
  
  getRequest(id: number): Observable<Request> {
    return this.httpClient.get<Request>(`${this.url}/${id}`);
  }

  reserveRequest(id: number): Observable<any> {
    return this.httpClient.put(`${this.url}/reserve/${id}`, this.httpOptions);
  }

  addRequest(request: Request): Observable<Request> {
    return this.httpClient.post<Request>(this.url, request, this.httpOptions);
  }

}
