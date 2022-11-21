import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { Register } from '../register';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  content?: string;

  
  courses: Course[] | undefined;

  register:Register=new Register();

  userName=String(localStorage.getItem('userName'));

  constructor(private userService: UserService,private courseService:CourseService,private router:Router) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe({
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
  
    
  
  
  
    /*
    registerCourse(courseName:String){
      console.log(localStorage.getItem('userName'));
      
      this.register.courseName=(courseName);
      this.register.userName=String(localStorage.getItem('userName'));
      console.log(this.register);
  
      if(confirm('Do you want to register for this course')){
  
      this.courseService.RegisterUser(this.register).subscribe(data => {
        console.log(data);
       });
      }
  
    }
    */
    registerCourse(courseName:String, cost:String){
      localStorage.setItem('courseName',String(courseName));
      localStorage.setItem('cost',String(cost));
      console.log(localStorage.getItem('courseName'));
  
      this.router.navigate(['payment']);
    }
}
