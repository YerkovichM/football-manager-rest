package footballmanagerrest;

import footballmanagerrest.dao.PlayerRepo;
import footballmanagerrest.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FootballManagerRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballManagerRestApplication.class, args);
    }

}
