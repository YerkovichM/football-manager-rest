package footballmanagerrest.model;


import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Position position;

    @Column(nullable = false)
    private Date birthday;

    @ManyToOne(optional = true)
    @JoinColumn(name = "team_id")
    private Team team;

    public enum Position{
        GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD;
    }
}