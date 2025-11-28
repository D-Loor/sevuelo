import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RequestsComponent } from './pages/requests/requests.component';
import { NewRequestComponent } from './pages/new-request/new-request.component';
import { RequestDetailComponent } from './pages/request-detail/request-detail.component';
import { DefaultLayoutComponent } from 'src/app/layouts/default-layout/default-layout.component';

const routes: Routes = [
  {
    path: '',
    component: DefaultLayoutComponent,
    children: [
      {
        path: 'requests',
        component: RequestsComponent
      },
      {
        path: 'new-request',
        component: NewRequestComponent
      },
      {
        path: 'requests/:id',
        component: RequestDetailComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RequestsRoutingModule { }
