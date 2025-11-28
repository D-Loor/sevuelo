import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-default-layout',
  templateUrl: './default-layout.component.html',
  styleUrls: ['./default-layout.component.scss'],
  imports: [
    RouterOutlet,
    RouterModule
  ]
})
export class DefaultLayoutComponent {
  title = 'SE Vuelo';
}
