import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { Trainer } from '../trainer';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {

  courseID!:number;
  course!: Course;
  Train!:String;
  train:Trainer=new Trainer();
  trainerName!:String;

  constructor(private route:ActivatedRoute,private courseService :CourseService) { }

  ngOnInit(): void {
    this.courseID=this.route.snapshot.params['courseID'];
    this.course=new Course();
    
    
    this.courseService.getCourseById(this.courseID).subscribe(data=>{
      this.course=data;

      console.log(this.course);
      this.train=new Trainer();
      this.courseService.getTrainerByName(this.course.trainer).subscribe(data=>{
        this.train=data;
        console.log(this.train);
      });

    });
    
  }

}
