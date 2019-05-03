package footballmanagerrest.dao;

import footballmanagerrest.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

}
