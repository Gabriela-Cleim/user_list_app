package com.example.userlistapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Classe responsável por configurar e fornecer uma instância do Retrofit
public class RetrofitClient {

    // Varaivel estatica que armazena a isntancia do Retrofit
    private static Retrofit retrofit = null;

    // Metodo estatic para obter a instancia do Retrofit, aceitando a URL base da API como parametro
    public static Retrofit getClient(String baseUrl){

        // Verifica se a instancia do Retofit ja foi criada
        if(retrofit == null){
            // Cria a instancia do retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl) // Define a URL base da API
                    .addConverterFactory(GsonConverterFactory.create()) // Adiciona um conversor para transformar JSON em objetos Java
                    .build(); // Constroi a instancia do Retrofit
        }

        // Retorna a instância do Retrofit
        return retrofit;
    }
}
