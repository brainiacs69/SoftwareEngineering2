package brainiacs.games;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import brainiacs.courses.Course;

@RestController
public class GameController
{
	@Autowired
	private GameService gameService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/games/create")
	public String createCourse(@RequestBody Game game)
	{
		
		
		gameService.addGame(game);
		return "asd";
	}
	
	
	@RequestMapping("/games")
	public ArrayList<Game> getGames()
	{
		return gameService.getGames();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/games")
	public Game getGame(@RequestBody Game game)
	{
		return gameService.getGame(game.getId());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/games/course")
	public ArrayList<Game> getGamesByCourse(@RequestBody Course course)
	{
		return gameService.getGamesByCourseName(course.getName());
	}
}
