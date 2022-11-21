import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {

  courseID!:number;
  course:Course=new Course();
 
  constructor(private courseService:CourseService,private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.courseID=this.route.snapshot.params['courseID'];

    this.courseService.getCourseById(this.courseID).subscribe(data=>{
      this.course=data;
    },error=>console.log(error)
    );
  }

  onSubmit(){
    this.courseService.updateCourse(this.courseID,this.course).subscribe(data=>{
      this.goToCourseList();

    }
    ,error=>console.log(error));
  }

  goToCourseList(){
    this.router.navigate(['/admin']);
  }

}
