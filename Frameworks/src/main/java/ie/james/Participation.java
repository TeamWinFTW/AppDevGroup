package ie.james;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

/**
 * Created by User on 05/11/2015.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participation {
    @JsonUnwrapped
    @JoinColumn(name="role")
    @OneToOne
    private Role role;
    @JsonUnwrapped

    @JoinColumn(name="participant")
    @OneToOne
    private Participant participant;

    public int getPrim_id() {
        return prim_id;
    }

    public void setPrim_id(int prim_id) {
        this.prim_id = prim_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prim_id;



    @Override
    public String toString() {
        return "Participation{" +
                "participant=" + participant +
                ", role=" + role +
                '}';
    }

   // @OneToOne(cascade = CascadeType.ALL)
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

   // @OneToOne(cascade = CascadeType.ALL)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
