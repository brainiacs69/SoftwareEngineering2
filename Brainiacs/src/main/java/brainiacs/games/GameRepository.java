package brainiacs.games;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends CrudRepository<Game, Integer>
{
	@Query("SELECT g FROM Game g JOIN g.course u WHERE u.name = :name")
	List<Game> getGamesByCourseName(@Param("name") String name);
}
