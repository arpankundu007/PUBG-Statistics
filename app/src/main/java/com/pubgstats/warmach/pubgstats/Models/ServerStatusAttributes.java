package com.pubgstats.warmach.pubgstats.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by warmach on 3/4/18.
 */

public class ServerStatusAttributes implements Serializable {

    @SerializedName("releasedAt")
    @Expose
    private String releasedAt;
    @SerializedName("version")
    @Expose
    private String version;

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
