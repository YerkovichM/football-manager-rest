package footballmanagerrest.service;

import footballmanagerrest.dao.PlayerRepo;
import footballmanagerrest.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepo playerRepo;

    @Override
    public List<Player> getAll() {
        return playerRepo.findAll();
    }

    @Override
    public Player create(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public Player read(Long id) {
        return playerRepo.findById(id).orElseThrow();
    }

    @Override
    public void update(Player player) {
        playerRepo.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepo.deleteById(id);
    }

    @Override
    public List<Player> findAllByTeam(Long teamId) {
        return playerRepo.findAll().stream()
                .filter(player -> Objects.nonNull(player.getTeam()))
                .filter(player -> teamId.equals(player.getTeam().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> findAllByTeamAndPosition(Long teamId, Player.Position position) {
        return playerRepo.findAll().stream()
                .filter(player -> Objects.nonNull(player.getTeam()))
                .filter(player -> player.getTeam().getId().equals(teamId))
                .filter(player -> player.getPosition().equals(position))
                .collect(Collectors.toList());
    }

}
