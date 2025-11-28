import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestService } from '../../services/request.service';
import { Request } from '../../models/request.model';

@Component({
  selector: 'app-new-request',
  templateUrl: './new-request.component.html',
  styleUrls: ['./new-request.component.scss'],
})
export class NewRequestComponent implements OnInit {
  private fb = inject(FormBuilder);
  private requestService = inject(RequestService);
  private router = inject(Router);

  form!: FormGroup;

  ngOnInit(): void {
    this.form = this.fb.group({
      passenger: ['', Validators.required],
      destination: ['', Validators.required],
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    if (this.form.invalid) return;

    const request: Request = this.form.value;

    this.requestService.addRequest(request).subscribe({
      next: (newRequest) => {
        this.router.navigate(['/requests']);
      }
    });
  }
  
}
