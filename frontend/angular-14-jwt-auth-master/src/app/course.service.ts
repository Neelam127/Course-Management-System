import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trainer } from 'src/app/trainer';
import { Course } from './course';
import { Register } from './register';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  

  baseURL = "http://localhost:8081/cos/Course";

  url="http://localhost:8089/api/User";
  url2="http://localhost:8089/api/UserLogin";

  TrainerURL="http://localhost:8080/train/Trainers"

  registerURL="http://localhost:8007/reg/Registers";

  getregisterlist="http://localhost:8007/reg/Register";

  constructor(private httpClient: HttpClient) { }

 

  getCourseList(): Observable<Course[]>{

    return this.httpClient.get<Course[]>(`${this.baseURL}`);

  }

  createCourse(course: Course): Observable<Object>{

    return this.httpClient.post(`${this.baseURL}`, course);

  }

  getCourseById(courseID:number): Observable<Course>{
    return this.httpClient.get<Course>(`${this.baseURL}/${courseID}`);
  }

  updateCourse(courseID:number,course:Course):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${courseID}`,course);
  }

  getTrainerByName(Train:String):Observable<Trainer>{
    return this.httpClient.get<Trainer>(`${this.TrainerURL}/${Train}`);
  }


  deleteCourse(courseID:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${courseID}`);
  }

  createUser(user: User): Observable<Object>{

    return this.httpClient.post(`${this.url}`, user);

  }

  RegisterUser(register: Register): Observable<Object>{

    return this.httpClient.post(`${this.registerURL}`, register);

  }

  UserLogin(user: User): Observable<Object>{

    return this.httpClient.post(`${this.url2}`, user);

  }

  
  getRegisteredList(): Observable<Register[]>{

    return this.httpClient.get<Register[]>(`${this.getregisterlist}`);

  }

  getAllRegistery(userName:string): Observable<Register[]>{

    return this.httpClient.get<Register[]>(`${this.registerURL}/${userName}`);

  }

  

}
