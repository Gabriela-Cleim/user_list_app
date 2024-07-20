package com.example.userlistapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

// Interface que define os endpoints da API e os métodos para fazer as requisições
public interface ApiService {
    // Define uma requisição GET para o endpoint "/users"
    // Este método retornará uma chamada (Call) que, quando executada, fará a requisição e retornará uma lista de objetos User
    @GET("/users")
    Call<List<User>> getUsers();
}
