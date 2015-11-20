package ie.james;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 05/11/2015.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Exhibit {
    @Id
    private String id;
    private String title;
    private String date;
    private String medium;
    private String creditline;
    private String description;
    private String gallery_text;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="Exhibit_HAS_Participations", joinColumns={@JoinColumn(name="EXHIBIT_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="PARTICIPATION_ID", referencedColumnName="prim_id")})
    private List<Participation> participants=new ArrayList<Participation>();
    @Transient
    private List<Map<String,Image>> images=new ArrayList<Map<String,Image>>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getCreditline() {
        return creditline;
    }

    public void setCreditline(String creditline) {
        this.creditline = creditline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGallery_text() {
        return gallery_text;
    }

    public void setGallery_text(String gallery_text) {
        this.gallery_text = gallery_text;
    }

    public List<Participation> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participation> participants) {
        this.participants = participants;
    }

    public List<Map<String, Image>> getImages() {
        return images;
    }

    public void setImages(List<Map<String, Image>> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", medium='" + medium + '\'' +
                ", creditline='" + creditline + '\'' +
                ", description='" + description + '\'' +
                ", gallery_text='" + gallery_text + '\'' +

                '}';
    }
}
