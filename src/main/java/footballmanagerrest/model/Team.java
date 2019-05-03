package footballmanagerrest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "capitan")
    private Player capitan;

    @JsonIgnore
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player p){
        players.add(p);
        p.setTeam(this);
    }

    public void removePlayer(Player p){
        players.remove(p);
        p.setTeam(null);
    }
}
