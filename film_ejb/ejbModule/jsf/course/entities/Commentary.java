package jsf.course.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commentary database table.
 * 
 */
@Entity
@NamedQuery(name="Commentary.findAll", query="SELECT c FROM Commentary c")
public class Commentary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_com")
	private int idCom;

	@Column(name="name_user_com")
	private String nameUserCom;

	@Column(name="text_com")
	private String textCom;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="id_movie")
	private Movie movie;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Commentary() {
	}

	public int getIdCom() {
		return this.idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public String getNameUserCom() {
		return this.nameUserCom;
	}

	public void setNameUserCom(String nameUserCom) {
		this.nameUserCom = nameUserCom;
	}

	public String getTextCom() {
		return this.textCom;
	}

	public void setTextCom(String textCom) {
		this.textCom = textCom;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}