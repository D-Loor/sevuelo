import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestsModule } from './features/requests/requests.module';
import { GlobalExceptionHandler } from './core/handlers/global-exception-handler';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RequestsModule
  ],
  providers: [
    { provide: ErrorHandler, useClass: GlobalExceptionHandler },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
