import { Component, OnInit } from '@angular/core';
import { CourseService } from '../course.service';
import { Register } from '../register';

@Component({
  selector: 'app-view-courses',
  templateUrl: './view-courses.component.html',
  styleUrls: ['./view-courses.component.css']
})
export class ViewCoursesComponent implements OnInit {

  registers: Register[] | undefined;

  Name!:string;

  constructor(private courseService:CourseService) { }

  ngOnInit(): void {
    this.getRegister();
  }

  private getRegister(){
    this.Name!=localStorage.getItem('username');
    this.courseService.getRegisteredList().subscribe(data => {
     this.registers = data;
    });
    }

}
