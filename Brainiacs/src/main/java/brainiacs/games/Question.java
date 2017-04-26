package brainiacs.games;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column( name = "id",nullable = false, unique = true)
	private Integer id;
	private String question;
	
/*	@ManyToOne(cascade = {CascadeType.ALL})
	private Game game;*/
	

	@OneToMany(cascade = {CascadeType.ALL})
	private List<Answer> answers;
	
/*	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}*/
	public Integer getId() {
		return id;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

}
