package footballmanagerrest.model.dto;

import footballmanagerrest.model.Player;
import footballmanagerrest.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Player.Position position;
    private Date birthday;
    private Long teamId;

    public static PlayerDto of(Player p){
        if(Objects.isNull(p)){
            return null;
        }

        Long teamId = (Objects.nonNull(p.getTeam()))
                ? p.getTeam().getId()
                : null;

        return new PlayerDto(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getPosition(),
                p.getBirthday(),
                teamId
        );
    }
}
