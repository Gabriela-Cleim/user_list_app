package com.example.userlistapp;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

// Classe ViewHolder que mantém as referências às views dos itens da lista
public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView txtId, txtName, txtUsername, txtEmail;

    // Construtor que inicializa as views
    public UserViewHolder(View itemView){

        // Chama o construtor da classe pai (RecyclerView.ViewHolder)
        super(itemView);

        // Associa a TextView do layout XML ao campo userName
        txtId = itemView.findViewById(R.id.text_view_id);
        txtName = itemView.findViewById(R.id.text_view_name);
        txtUsername = itemView.findViewById(R.id.text_view_username);
        txtEmail = itemView.findViewById(R.id.text_view_email);
    }
}
