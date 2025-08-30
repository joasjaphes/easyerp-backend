package com.jcom.easyerp.shared;


import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.ResponseEntity;

public class HttpException<T> {
    private T body;
    private int status;
    public HttpException(T body,  int status) {
        this.body = body;
        this.status = status;

    }
    public ResponseEntity<T> responseEntity() {
        return new ResponseEntity<T>(this.body, null, this.status);
    }
}
