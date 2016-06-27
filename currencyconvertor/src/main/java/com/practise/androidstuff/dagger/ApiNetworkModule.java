package com.practise.androidstuff.dagger;

import android.content.Context;

import com.practise.androidstuff.network.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiNetworkModule {

    @Singleton
    @Provides
    @Named(Constants.Injection.Named.CURRENCY_CONVERTOR_BASE_URL_KEY)
    public String provideBaseUrl() {
        return Constants.Injection.Named.CURRENCY_CONVERTOR_BASE_URL;
    }

    @Singleton
    @Provides
    @Named(Constants.Injection.Named.MASHAPE_API_KEY)
    public String provideMashapeApiKey(Context context) {
        return Constants.Injection.Named.MASHAPE_API_KEY_VALUE;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(
            final @Named(Constants.Injection.Named.MASHAPE_API_KEY) String key) {
        final OkHttpClient.Builder builder
                = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);


        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

//                long t1 = System.nanoTime();
//                Log.d("ApiModule", "Sending request : " +
//                        original.url() + " , " + chain.connection() + " , " +  original.headers());


                // Customize the request
                Request requestBuilder = original.newBuilder()
                        .header(Constants.Injection.Named.MASHAPE_API_KEY, key)
                        .method(original.method(), original.body())
                        .build();

                Response response = chain.proceed(requestBuilder);

//                long t2 = System.nanoTime();
//                Log.d("ApiModule", "Received response : " +
//                        response.request().url()+ " , " +  (t2 - t1) / 1e6d + " , " +  response.headers());

                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                // Customize or return the response
                return response;
            }
        });

        return builder.build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(
            @Named(Constants.Injection.Named.CURRENCY_CONVERTOR_BASE_URL_KEY) String baseUrl,
            OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
