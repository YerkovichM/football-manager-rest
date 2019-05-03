package footballmanagerrest.service;

import footballmanagerrest.dao.PlayerRepo;
import footballmanagerrest.dao.TeamRepo;
import footballmanagerrest.model.Player;
import footballmanagerrest.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    TeamRepo teamRepo;

    @Autowired
    PlayerRepo playerRepo;

    @Override
    public Team create(Team team) {
        return teamRepo.save(team);
    }

    @Override
    public Team read(Long id) {
        return teamRepo.findById(id).orElseThrow();
    }

    @Override
    public void update(Team team) {
        teamRepo.save(team);
    }

    @Override
    public void delete(Long id) {
        teamRepo.deleteById(id);
    }

    @Override
    public List<Team> getAll() {
        return teamRepo.findAll();
    }

    @Override
    public void addNewPlayer(Long id, Player player) {
        playerRepo.save(player);
        Team team = teamRepo.findById(id).orElseThrow();
        team.addPlayer(player);
        teamRepo.save(team);
    }

    @Override
    public void assignCapitan(Long id, Long playerId) {
        Team team = teamRepo.findById(id).orElseThrow();
        Player player = playerRepo.findById(id).orElseThrow();
        if(!team.getPlayers().stream()
                .anyMatch(p -> p.equals(player))){
            team.addPlayer(player);
        }
        team.setCapitan(player);
        teamRepo.save(team);
        playerRepo.save(player);
    }

    @Override
    public Player getCapitanOfATeam(Long teamId) {
        return teamRepo.findById(teamId).orElseThrow().getCapitan();
    }
}
