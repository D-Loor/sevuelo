import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RequestsRoutingModule } from './requests-routing.module';
import { RequestDetailComponent } from './pages/request-detail/request-detail.component';
import { NewRequestComponent } from './pages/new-request/new-request.component';
import { RequestsComponent } from './pages/requests/requests.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    RequestsComponent,
    NewRequestComponent,
    RequestDetailComponent
  ],
  imports: [
    CommonModule,
    RequestsRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class RequestsModule { }
