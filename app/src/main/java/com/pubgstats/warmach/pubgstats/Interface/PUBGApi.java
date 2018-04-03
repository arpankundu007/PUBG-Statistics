package com.pubgstats.warmach.pubgstats.Interface;

import com.pubgstats.warmach.pubgstats.Models.ServerStatus;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by warmach on 3/4/18.
 */

public interface PUBGApi {
    @GET("status")
    Call<ServerStatus> checkServerStatus();
}
