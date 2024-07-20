package com.example.userlistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter que gerencia a criação e ligação dos itens da lista
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> userList;

    // Construtor que recebe a lista de usuários
    public UserAdapter(List<User> userList){
        this.userList = userList;
    }

    // Cria novas views (invocada pelo layout manager)
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Infla o layout do item e cria um ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent, false);
        return new UserViewHolder(view);
    }

    // Substitui o conteúdo de uma view (invocada pelo layout manager)
    public void onBindViewHolder(UserViewHolder holder, int position){
        // Obtém o usuário da lista na posição especificada
        User user = userList.get(position);

        // Define o texto da TextView com o nome do usuário
        holder.txtId.setText(String.valueOf(user.getId()));
        holder.txtName.setText(user.getName());
        holder.txtUsername.setText(user.getUserName());
        holder.txtEmail.setText(user.getEmail());
    }

    // Retorna o tamanho do dataset (invocado pelo layout manager)
    public int getItemCount() {
        return userList.size();
    }
}
