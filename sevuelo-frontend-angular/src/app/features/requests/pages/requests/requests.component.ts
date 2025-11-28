import { Component, inject, OnInit } from '@angular/core';
import { Request } from '../../models/request.model';
import { RequestService } from '../../services/request.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss']
})
export class RequestsComponent implements OnInit {
  private requestService = inject(RequestService);
  requests: Request[];
  selectedRequest: Request;

  ngOnInit(): void {
    this.getRequests();
  }

  getRequests(): void {    
    this.requestService.getRequests().subscribe({
      next: (requests) => {
        this.requests = requests
      }
    });
  }

}
