package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Topic extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("Ma_de")
    private String id;

    public Topic() {
    }

    public Topic(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
