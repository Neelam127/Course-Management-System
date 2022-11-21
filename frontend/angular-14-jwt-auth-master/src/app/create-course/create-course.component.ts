import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.css']
})
export class CreateCourseComponent implements OnInit {
  course: Course = new Course();

  constructor(private courseService: CourseService,

    private router: Router) { }

  ngOnInit(): void {
  }

  saveCourse(){

    this.courseService.createCourse(this.course).subscribe( (data: any) =>{

      console.log(data);

      alert('Course created sucessfully');

      this.goToCourseList();

    },

      (    error: any) => console.log(error));

  }



  goToCourseList(){

    this.router.navigate(['/admin']);;

  }

 

  onSubmit(){

    console.log(this.course);

    this.saveCourse();

  }

}
