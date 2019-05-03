package footballmanagerrest.web.controller;

import footballmanagerrest.model.Player;
import footballmanagerrest.model.Team;
import footballmanagerrest.model.dto.PlayerDto;
import footballmanagerrest.model.dto.TeamDto;
import footballmanagerrest.service.PlayerService;
import footballmanagerrest.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamRestController {

    private final TeamService teamService;

    @Autowired
    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto create(@RequestBody Team team){
        return TeamDto.of(teamService.create(team));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public TeamDto read(@PathVariable Long id){
        return TeamDto.of(teamService.read(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Team team){
        if(!id.equals(team.getId())){
            throw new IllegalStateException();
        }
        teamService.update(team);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        teamService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDto> getAll(){
        return dtoOfList(teamService.getAll());
    }

    @PostMapping("/{id}/addNewPlayer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPlayer(@PathVariable Long id, @RequestBody Player player){
        teamService.addNewPlayer(id, player);
    }

    @GetMapping("/{id}/assignCapitan")
    @ResponseStatus(HttpStatus.OK)
    public void assignCapitan(@PathVariable Long id, @RequestParam(name = "player") Long playerId){
        teamService.assignCapitan(id, playerId);
    }

    @GetMapping("/{id}/capOfTeam")
    @ResponseStatus(HttpStatus.FOUND)
    public PlayerDto getCapitanOfATeam(@PathVariable Long id){
        return PlayerDto.of(teamService.getCapitanOfATeam(id));
    }

    private List<TeamDto> dtoOfList(List<Team> list){
        return list.stream().map(TeamDto::of).collect(Collectors.toList());
    }
}