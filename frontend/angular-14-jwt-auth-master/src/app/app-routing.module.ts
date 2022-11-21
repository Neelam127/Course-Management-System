import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { CourseListComponent } from './course-list/course-list.component';
import { PaymentComponent } from './payment/payment.component';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { ViewRegistryComponent } from './view-registry/view-registry.component';
import { UpdateCourseComponent } from './update-course/update-course.component';
import { CreateCourseComponent } from './create-course/create-course.component';
import { ViewCoursesComponent } from './view-courses/view-courses.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  
  {path:'course-details/:courseID',component:CourseDetailsComponent},
  {path:'view-courses-registry',component:ViewRegistryComponent},
  {path:'update-course/:courseID',component:UpdateCourseComponent},
  {path:'create-course',component:CreateCourseComponent},
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  {path:'course-list',component: CourseListComponent},
  {path:'payment',component:PaymentComponent},
  {path:'view-courses',component:ViewCoursesComponent},
  
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
