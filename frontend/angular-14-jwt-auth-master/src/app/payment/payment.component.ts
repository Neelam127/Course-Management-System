import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { Register } from '../register';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
 
  courses: Course[] | undefined;

  amount:String=String(localStorage.getItem('cost'));

  register:Register=new Register();

  username=String(localStorage.getItem('username'));

  constructor(private courseService:CourseService,private router:Router) { }

  ngOnInit(): void {
  }

  
  registerCourses(courseName:String){
    console.log(localStorage.getItem('userName'));
    
    this.register.courseName=String(localStorage.getItem('courseName'));
    this.register.username=String(localStorage.getItem('username'));
    console.log(this.register);

   

    this.courseService.RegisterUser(this.register).subscribe(data => {
      console.log(data);
      alert("Payment sucessful");
      this.router.navigate(['view-courses-registry'])

     },
    (    error: any) => alert("You have already registered for this Course")
     

          
     
     );
    }
    
/*
     this.courseService.createCourse(this.course).subscribe( (data: any) =>{

      console.log(data);

      alert('Course created sucessfully');

      this.goToCourseList();

    },

      (    error: any) => console.log(error));

  }*/

  cancel($event:any){
    this.router.navigate(['user']);
  }


}
