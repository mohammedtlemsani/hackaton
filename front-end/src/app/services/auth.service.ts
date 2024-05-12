import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {jwtDecode} from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated : boolean = false;
  roles : any;
  username!:any;
  accessToken!:any;
  backend_url! : string
  constructor(private http:HttpClient) {
  }

  public login(username:string,password:string){
    let options = {
      headers : new HttpHeaders().set("content-Type","application/x-www-form-urlencoded")
    }
    let params = new HttpParams().set("username",username).set("password",password)
    return this.http.post("http://localhost:8080/login",params,options)
  }

  loadProfile(data:any) {
    this.isAuthenticated = true
    localStorage.setItem("accessToken", data.accessToken);
    this.accessToken = localStorage.getItem("accessToken")
    console.log(this.accessToken)
    let decodedJwt:any = jwtDecode(this.accessToken);
    this.username = decodedJwt.sub;
    this.roles = decodedJwt.scope;
  }
}
