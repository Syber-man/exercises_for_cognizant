import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
  CommonModule,
  FormsModule,
  CreditLabelPipe,
  RouterModule
],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = true;
  searchTerm = '';

//   courses = [
//   {
//     id: 1,
//     name: 'Angular Fundamentals',
//     gradeStatus: 'passed',
//     credits: 4
//   },
//   {
//     id: 2,
//     name: 'Spring Boot Basics',
//     gradeStatus: 'failed',
//     credits: 3
//   },
//   {
//     id: 3,
//     name: 'Machine Learning',
//     gradeStatus: 'pending',
//     credits: 5
//   }
// ];

  courses: Course[] = [];

  constructor(
  private router: Router,
  private route: ActivatedRoute,
  private courseService: CourseService
) {}

  ngOnInit(): void {

    this.searchTerm =
  this.route.snapshot.queryParamMap.get('search') ?? '';

  this.courses = this.courseService.getCourses();

  setTimeout(() => {
    this.isLoading = false;
  }, 1500);

}

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

  isExpanded = false;

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  onSearch(): void {

  this.router.navigate(
    ['courses'],
    {
      queryParams: {
        search: this.searchTerm
      }
    }
  );

}

  get cardClasses() {
    return {
      expanded: this.isExpanded
    };
  }
}