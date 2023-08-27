package com.onurgundogdu.bookstore.exception;

import org.springframework.hateoas.RepresentationModel;

public class ErrorResponse extends RepresentationModel<ErrorResponse> {

    private String message;

    public ErrorResponse(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
