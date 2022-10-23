package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Answer extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("MaDapAn")
    private int id;
    @SerializedName("noi_dung")
    private String content;
    @SerializedName("dap_an_dung")
    private String isRight;

    public Answer() {
    }

    public Answer(int id, String content, String isRight) {
        this.id = id;
        this.content = content;
        this.isRight = isRight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsRight() {
        return isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }
}
