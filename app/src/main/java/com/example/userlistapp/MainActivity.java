package com.example.userlistapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa a RecyclerView
        recyclerView = findViewById(R.id.recyclerView);  // Certifique-se de que o ID é 'recyclerView' no XML
        // Define o LayoutManager para a RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializa a lista de usuários e o adapter
        userList = new ArrayList<>();
        userAdapter = new UserAdapter(userList);
        // Associa o adapter à RecyclerView
        recyclerView.setAdapter(userAdapter);

        // Cria uma instância do serviço de API usando Retrofit
        ApiService apiService = RetrofitClient.getClient("https://jsonplaceholder.typicode.com")
                .create(ApiService.class);

        // Faz uma chamada para obter a lista de usuários
        Call<List<User>> call = apiService.getUsers();


        // Enfileira a chamada para ser executada de forma assíncrona
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                // Método chamado quando a resposta da API é recebida
                if(response.isSuccessful()){ // Verifica se a resposta foi bem-sucedida
                    List<User> users = response.body(); // Obtém o corpo da resposta que contém a lista de usuários
                    if (users != null) {
                        // Adiciona os usuários recebidos à lista e notifica o adapter
                        userList.addAll(users);
                        userAdapter.notifyDataSetChanged(); // Atualiza o RecyclerView
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                // Método chamado quando a chamada para a API falha
                Log.e("Error", t.getMessage()); // Registra a mensagem de erro no log
                Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}