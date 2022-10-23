package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrafficSigns extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("id_bien")
    private String id;
    @SerializedName("y_nghia")
    private String content;
    @SerializedName("hinh_anh")
    private String image;

    public TrafficSigns() {
    }

    public TrafficSigns(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
