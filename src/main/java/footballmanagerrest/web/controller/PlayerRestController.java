package footballmanagerrest.web.controller;


import footballmanagerrest.model.Player;
import footballmanagerrest.model.dto.PlayerDto;
import footballmanagerrest.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerRestController {

    private final PlayerService playerService;

    @Autowired
    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDto create(@RequestBody Player player){
        return PlayerDto.of(playerService.create(player));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public PlayerDto read(@PathVariable Long id){
        return PlayerDto.of(playerService.read(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Player player){
        if(!id.equals(player.getId())){
            throw new IllegalStateException();
        }
        playerService.update(player);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        playerService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDto> getAll(){
        return dtoOfList(playerService.getAll());
    }

    @GetMapping("/byTeam")
    @ResponseStatus(HttpStatus.FOUND)
    public List<PlayerDto> getAllByTeam(@RequestParam(name = "team") Long teamId){
        return dtoOfList(playerService.findAllByTeam(teamId));
    }

    @GetMapping("/byTeamAndPos")
    @ResponseStatus(HttpStatus.FOUND)
    public List<PlayerDto> getAllByTeamAndPosition(@RequestParam(name = "team") Long teamId,
                                                @RequestParam(name = "position")Player.Position position){
        return dtoOfList(playerService.findAllByTeamAndPosition(teamId, position));
    }

    private List<PlayerDto> dtoOfList(List<Player> list){
        return list.stream().map(PlayerDto::of).collect(Collectors.toList());
    }
}
