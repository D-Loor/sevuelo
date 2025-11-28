import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
const routes: Routes = [
  {
    path: '',
    redirectTo: 'requests',
    pathMatch: 'full'
  },
  {
    path: '',
    loadChildren: () =>
      import('./features/requests/requests-routing.module')
        .then(m => m.RequestsRoutingModule)
  },
  {
    path: '**',
    redirectTo: 'requests'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
