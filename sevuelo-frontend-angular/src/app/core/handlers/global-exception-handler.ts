import { ErrorHandler, Injectable } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable()
export class GlobalExceptionHandler implements ErrorHandler {

    handleError(error: any): void {
        console.error('Global Error Handler:');

        if (error instanceof HttpErrorResponse) {

            switch (error.status) {

                case 404:
                    console.error('Resource not found');
                    break;

                case 500:
                    console.error('Internal server error');
                    break;

                default:
                    console.error('An unexpected error occurred:', error.message);
                    break;
            }

        } else {
            console.error('An unexpected error occurred:', error.message);
        }
        
        console.error('Response body:', error.error);

    }
}