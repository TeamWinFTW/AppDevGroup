package ie.james;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by User on 05/11/2015.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {

    private String role_id;
    private String role_name;
    private String role_display_name;
    private String role_url; ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prim_Id;

    public int getPrim_Id() {
        return prim_Id;
    }

    public void setPrim_Id(int prim_Id) {
        this.prim_Id = prim_Id;
    }


    public String getRole_id() {
        return role_id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", role_name='" + role_name + '\'' +
                ", role_display_name='" + role_display_name + '\'' +
                ", role_url='" + role_url + '\'' +
                '}';
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_display_name() {
        return role_display_name;
    }

    public void setRole_display_name(String role_display_name) {
        this.role_display_name = role_display_name;
    }

    public String getRole_url() {
        return role_url;
    }

    public void setRole_url(String role_url) {
        this.role_url = role_url;
    }
}
