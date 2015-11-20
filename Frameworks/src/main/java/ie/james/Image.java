package ie.james;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by User on 05/11/2015.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    private String url;
    private String width;
    private String height;
    private String is_primary;
    private String image_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prim_Id;

    public int getPrim_Id() {
        return prim_Id;
    }

    public void setPrim_Id(int prim_Id) {
        this.prim_Id = prim_Id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getIs_primary() {
        return is_primary;
    }

    public void setIs_primary(String is_primary) {
        this.is_primary = is_primary;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }


}
