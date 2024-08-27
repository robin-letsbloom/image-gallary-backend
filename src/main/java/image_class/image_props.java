package image_class;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "gallery")

public class image_props {



    @Id

    private int image_id;
    private LocalDate upload_date;
    @Column(name = "image_url")
    private  String url;
    @Column(name = "image_category")
    private String catagory;

    public image_props(int image_id, LocalDate upload_date, String url, String catagory) {

        super();
        this.image_id = image_id;
        this.upload_date = upload_date;
        this.url = url;
        this.catagory = catagory;
    }
    public image_props(){
        super();
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public LocalDate getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(LocalDate upload_date) {
        this.upload_date = upload_date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}
