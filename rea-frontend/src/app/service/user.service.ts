import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8082/api/user';

  constructor(private http: HttpClient) {
  }

  createSettings(settings: any) {
    return this.http.put<any>(`${this.userUrl}/settings`, settings);
  }

  getSettings() {
    return this.http.get<any>(`${this.userUrl}/settings`);
  }

}
