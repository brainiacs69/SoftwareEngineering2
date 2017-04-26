package brainiacs.games;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brainiacs.courses.Course;

@Service
public class GameService
{
	
	@Autowired
	private GameRepository gameRepo;
	@Autowired
	private QuestionRepository qRepo;
	
	public void addGame(Game game)
	{
		gameRepo.save(game);
	}
	
	
	public ArrayList<Game> getGamesByCourseName(String name)
	{
		ArrayList<Game> games = new ArrayList<Game>();
		gameRepo.getGamesByCourseName(name).forEach(games::add);
		return games;
	}
	
	public ArrayList<Game> getGames()
	{
		
		ArrayList<Game> games = new ArrayList<Game>();
		gameRepo.findAll().forEach(games::add);
		return games;	
	}
	
	public Game getGame(Integer id)
	{
		return gameRepo.findOne(id);
	}
	
}
