package footballmanagerrest.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/help")
public class HelpRestController {

    @GetMapping
    public String help(){
        return "GET /help - for help<br>" +
                "Players:<br>" +
                "GET /players - list of all players<br>" +
                "GET /players/{id} - find player by id<br>" +
                "POST /players (Player in REQUEST BODY) - create a new player<br>" +
                "PUT /players/{id} (Player in REQUEST BODY) - update player<br>" +
                "DELETE /players/{id} - delete player by id<br>" +
                "GET /players/byTeam?team={team_id} - find all players in team with team_id<br>" +
                "GET /players/byTeamAndPos?team={team_id}&position={pos} - find all players in team with pos position<br>" +
                "Team:<br>" +
                "GET /teams - list of all teams<br>" +
                "GET /teams/{id} - find team by id<br>" +
                "POST /teams (Team in REQUEST BODY) - create a new team<br>" +
                "PUT /teams/{id} (Team in REQUEST BODY) - update team<br>" +
                "DELETE /teams/{id} - delete team by id<br>" +
                "POST /teams/{id}/addNewPlayer (Player in REQUEST BODY) - add a NEW player to a team<br>" +
                "GET /teams/{id}/assignCapitan?player={player_id} - assign player to capitan of a team<br>" +
                "GET /teams/{id}/capOfTeam - get capitan of a team";
    }
}
