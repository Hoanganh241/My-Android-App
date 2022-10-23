package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ExamPrinciple extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("y_nghia")
    private String content;
    @SerializedName("hinh_anh")
    private String image;

    public ExamPrinciple() {
    }

    public ExamPrinciple(String content, String image) {
        this.content = content;
        this.image = image;
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
