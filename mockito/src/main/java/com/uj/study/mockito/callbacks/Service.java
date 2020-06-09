package com.uj.study.mockito.callbacks;

public interface Service {

    void doAction(String request, Callback<Response> callback);

}
