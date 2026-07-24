import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnInit,
  OnChanges,
  OnDestroy,
  SimpleChanges
} from '@angular/core';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnInit, OnChanges, OnDestroy {

  @Input() courseName = '';

  @Output() enrollClicked = new EventEmitter<string>();

  ngOnInit(): void {
    console.log('CourseCard initialized');
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('Input changed:', changes);
  }

  ngOnDestroy(): void {
    console.log('CourseCard destroyed');
  }

  enroll() {
    this.enrollClicked.emit(this.courseName);
  }

}