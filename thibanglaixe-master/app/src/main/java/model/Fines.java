package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fines extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("noi_dung")
    private String content;
    @SerializedName("tien_phat")
    private String mulct;

    public Fines() {
    }

    public Fines(String content, String mulct) {
        this.content = content;
        this.mulct = mulct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMulct() {
        return mulct;
    }

    public void setMulct(String mulct) {
        this.mulct = mulct;
    }
}
