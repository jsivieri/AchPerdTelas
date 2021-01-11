package com.example.achadosperdidos.services;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* retofit service é a classe responsavel por fazer a comunicaçao com a api */
public class RetrofitService {

    private static Context context;
    private String baseUrl = "http://192.168.100.105:8080/";
    private InterfaceDeServicos api;
    private static RetrofitService instancia;

    private RetrofitService() {
        api = criaRetrofit().create(InterfaceDeServicos.class);
    }

    private Retrofit criaRetrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        /*httpClient.connectTimeout(20, TimeUnit.SECONDS);
        httpClient.writeTimeout(20,TimeUnit.SECONDS);
        httpClient.readTimeout(30,TimeUnit.SECONDS);*/
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
    }

    public static InterfaceDeServicos getServico(Context context) {
        RetrofitService.context = context;
        if (instancia == null)
            instancia = new RetrofitService();
        return instancia.api;
    }

}
