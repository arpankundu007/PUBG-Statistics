package com.pubgstats.warmach.pubgstats.Utils;

import com.pubgstats.warmach.pubgstats.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by warmach on 3/4/18.
 */

public class PUBGRetrofit {

    public static <S> S createService(Class<S> serviceClass, final String accessToken){
        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        if (accessToken == null) {
                            return chain.proceed(chain.request());
                        }
                        Request authorisedRequest = chain.request().newBuilder()
                                .addHeader("Authorization", accessToken).build();
                        return chain.proceed(authorisedRequest);
                    }
                }).build();

        String BASE_URL = BuildConfig.API_BASE_URL;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(defaultHttpClient)
                .build();

        return retrofit.create(serviceClass);
    }

}
