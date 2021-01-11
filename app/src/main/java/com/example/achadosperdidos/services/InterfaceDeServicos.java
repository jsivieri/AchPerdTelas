package com.example.achadosperdidos.services;


import com.example.achadosperdidos.domain.Objeto;
import com.example.achadosperdidos.domain.ObjetoDto;
import com.example.achadosperdidos.domain.ObjetoDto2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface InterfaceDeServicos {

//    @POST("/auth/login")
//    Call<TokenDTO> save_objeto(@Body Objeto dto);


    @GET("/objeto")
    Call<List<ObjetoDto>> listarObjetos();//lista objetos para deletar um

    @GET("/objeto/listar")
    Call<List<ObjetoDto2>> listar();//consulta a lista de objetos cadastrados na API


    @DELETE("delete_obj/{id}")
    Call<Void> excluir_objeto(@Path("id") Long id);

}