import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { Register } from '../register';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  content?: string;

  
  courses: Course[] | undefined;

  register:Register=new Register();

  username=String(localStorage.getItem('userName'));

  constructor(private userService: UserService,private courseService:CourseService,private router:Router) { }

  ngOnInit(): void {
    this.userService.getAdminBoard().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.content = res.message;
          } catch {
            this.content = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.content = `Error with status: ${err.status}`;
        }
      }
    });
    this.getCourses();
  }

  private getCourses(){
    this.courseService.getCourseList().subscribe(data => {
     this.courses = data;
    });
    }
  
    courseDetails(courseID:number){
      this.router.navigate(['course-details',courseID]);
    }
  
    updateCourse(courseID: number){
      this.router.navigate(['update-course',courseID]);
    }
  
    deleteCourse(courseID:number){
      if(confirm('Are you sure you want to delete')){
      this.courseService.deleteCourse(courseID).subscribe(data=>{
        console.log(data);
        this.getCourses();
      
      })
    }
    }
  
    registerCourse(courseName:String){
      console.log(localStorage.getItem('userName'));
      
      this.register.courseName=(courseName);
      this.register.username=String(localStorage.getItem('username'));
      console.log(this.register);
  
      if(confirm('Do you want to register for this course')){
  
      this.courseService.RegisterUser(this.register).subscribe(data => {
        console.log(data);
       });
      }
  
    }
}
