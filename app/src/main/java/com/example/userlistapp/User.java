package com.example.userlistapp;

public class User {

    // Atributos privados do tipo int e string que representam id, nome, username e email.
    private int id;
    private String name;
    private String username;
    private String email;


    // Métodos getters e setters para acessar e modificar os atributos privados

    public int getId(){ //Getter para o atributo id
        return id; //Retorna o valor de ID
    }

    public void setId(int id){ // Setter para o atributo id
        this.id = id; // Atribui um valor ao ID
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUserName(){
        return username;
    }

    public void setUserName(String username){
        this.username = username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
