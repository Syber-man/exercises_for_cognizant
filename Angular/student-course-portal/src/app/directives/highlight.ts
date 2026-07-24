import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {

  constructor(private element: ElementRef) { }

  @HostListener('mouseenter')
  onMouseEnter(): void {
    this.element.nativeElement.style.backgroundColor = 'yellow';
  }

  @HostListener('mouseleave')
  onMouseLeave(): void {
    this.element.nativeElement.style.backgroundColor = '';
  }

}