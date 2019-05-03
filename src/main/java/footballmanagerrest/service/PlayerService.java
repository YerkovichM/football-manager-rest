package footballmanagerrest.service;

import footballmanagerrest.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    List<Player> getAll();

    Player create(Player player);

    Player read(Long id);

    void update(Player player);

    void delete(Long id);

    List<Player> findAllByTeam(Long teamId);

    List<Player> findAllByTeamAndPosition(Long teamId, Player.Position position);

}
