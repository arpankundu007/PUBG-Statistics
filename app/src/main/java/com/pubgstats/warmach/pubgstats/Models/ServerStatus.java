package com.pubgstats.warmach.pubgstats.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by warmach on 3/4/18.
 */

public class ServerStatus implements Serializable {

    @SerializedName("data")
    @Expose
    private ServerStatusData data;

    public ServerStatusData getData() {
        return data;
    }

    public void setData(ServerStatusData data) {
        this.data = data;
    }
}
