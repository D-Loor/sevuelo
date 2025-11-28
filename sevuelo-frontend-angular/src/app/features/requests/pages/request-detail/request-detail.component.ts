import { Component, inject, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Request } from '../../models/request.model';
import { RequestService } from '../../services/request.service';

@Component({
  selector: 'app-request-detail',
  templateUrl: './request-detail.component.html',
  styleUrls: ['./request-detail.component.scss']
})
export class RequestDetailComponent implements OnInit {
  @Input() request: Request;

  private requestService = inject(RequestService);
  private route = inject(ActivatedRoute);

  ngOnInit(): void {
    this.getRequest();
  }

  previousState(): void {
    window.history.back();
  }

  getRequest(): void {
    const id = this.route.snapshot.paramMap.get('id');

    this.requestService.getRequest(Number.parseInt(id)).subscribe({
      next: (request) => this.request = request
    });
  }

  reserve(): void {
    this.requestService.reserveRequest(this.request.id).subscribe({
      next: (newRequest) => {
        this.request = newRequest;
        this.previousState();
      }
    });
  }

}
