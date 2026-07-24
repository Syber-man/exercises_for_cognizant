import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseCard } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';
import { CourseSummaryWidget } from '../../components/course-summary-widget/course-summary-widget';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
  FormsModule,
  CourseCard,
  CourseSummaryWidget
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  portalName = 'Student Course Portal';

  isPortalActive = true;

  message = '';

  searchTerm = '';

  selectedCourse = 'Angular Fundamentals';

  courses: Course[] = [];

  courseCount = 0;

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }

  constructor(private courseService: CourseService) {

  this.courses = this.courseService.getCourses();

  this.courseCount = this.courses.length;

  }

  onCourseEnroll(course: string) {
    alert(`Enrolled in ${course}`);
  }

}