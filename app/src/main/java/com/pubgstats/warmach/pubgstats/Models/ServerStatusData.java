package com.pubgstats.warmach.pubgstats.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by warmach on 3/4/18.
 */

public class ServerStatusData implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("attributes")
    @Expose
    private ServerStatusAttributes attributes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServerStatusAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(ServerStatusAttributes attributes) {
        this.attributes = attributes;
    }
}
