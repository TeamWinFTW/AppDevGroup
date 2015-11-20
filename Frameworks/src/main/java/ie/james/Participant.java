package ie.james;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by User on 05/11/2015.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant {

    private String person_id;
    private String person_name;
    private String person_url;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prim_Id;

    public int getPrim_Id() {
        return prim_Id;
    }

    public void setPrim_Id(int prim_Id) {
        this.prim_Id = prim_Id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "person_id='" + person_id + '\'' +
                ", person_name='" + person_name + '\'' +
                ", person_url='" + person_url + '\'' +
                '}';
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_url() {
        return person_url;
    }

    public void setPerson_url(String person_url) {
        this.person_url = person_url;
    }
}
