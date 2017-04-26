package brainiacs.games;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer
{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column( name = "id",nullable = false, unique = true)
	private Integer id;
	private String answer;
	private boolean correct;
	
/*	@ManyToOne(cascade = {CascadeType.ALL})
	private Question question;
	*/
	
	
	
	
	
	
	
/*	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
