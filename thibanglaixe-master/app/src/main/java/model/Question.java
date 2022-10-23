package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Question extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("MaCauHoi")
    private int id;
    @SerializedName("noi_dung")
    private String content;
    @SerializedName("dap_an")
    private List<Answer> dapAn;
    @SerializedName("hinh_anh")
    private String hinhAnh;
    @SerializedName("HinhBB")
    private String hinhBB;
    @SerializedName("HinhSH")
    private String hinhSH;

    public Question() {
    }

    public Question(int id, String content, List<Answer> dapAn) {
        this.id = id;
        this.content = content;
        this.dapAn = dapAn;
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

    public List<Answer> getDapAn() {
        return dapAn;
    }

    public void setDapAn(List<Answer> dapAn) {
        this.dapAn = dapAn;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHinhBB() {
        return hinhBB;
    }

    public void setHinhBB(String hinhBB) {
        this.hinhBB = hinhBB;
    }

    public String getHinhSH() {
        return hinhSH;
    }

    public void setHinhSH(String hinhSH) {
        this.hinhSH = hinhSH;
    }
}
