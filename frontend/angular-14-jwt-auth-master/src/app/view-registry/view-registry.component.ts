import { Component, OnInit } from '@angular/core';
import { CourseService } from '../course.service';
import { Register } from '../register';

@Component({
  selector: 'app-view-registry',
  templateUrl: './view-registry.component.html',
  styleUrls: ['./view-registry.component.css']
})
export class ViewRegistryComponent implements OnInit {

  registers!: Register[];

 
  userName:any = localStorage.getItem('username');
  
  

  constructor(private courseService:CourseService) { }

  ngOnInit(): void {
    
    this.getAll();
   
 this.userName =localStorage.getItem('userName');


    console.log(localStorage.getItem('username'));
  }

  private getAll(){
   
   
    this.courseService.getAllRegistery(String(this.userName)).subscribe(data => {
     this.registers = data;
    });
    }


}
