package footballmanagerrest.service;

import footballmanagerrest.model.Player;
import footballmanagerrest.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    Team create(Team team);

    Team read(Long id);

    void update(Team team);

    void delete(Long id);

    List<Team> getAll();

    void addNewPlayer(Long id, Player player);

    void assignCapitan(Long id, Long playerId);

    Player getCapitanOfATeam(Long teamId);
}
