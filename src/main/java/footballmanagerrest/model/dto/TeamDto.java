package footballmanagerrest.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import footballmanagerrest.model.Player;
import footballmanagerrest.model.Team;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {

    private Long id;
    private String name;
    private PlayerDto catitan;
    private List<PlayerDto> players = new ArrayList<>();

    public static TeamDto of(Team t){
        if(Objects.isNull(t)){
            return null;
        }

        List<PlayerDto> playerDtos = t.getPlayers().stream()
                .map(PlayerDto::of)
                .collect(Collectors.toList());

        return new TeamDto(
                t.getId(),
                t.getName(),
                PlayerDto.of(t.getCapitan()),
                playerDtos
        );
    }

}
