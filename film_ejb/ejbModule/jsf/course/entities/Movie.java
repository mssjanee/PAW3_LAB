package jsf.course.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movie")
	private Integer idMovie;

	@Lob
	@Column(name="descr_movie")
	private String descrMovie;

	@Column(name="duration_movie")
	private int durationMovie;

	@Column(name="genre_movie")
	private String genreMovie;

	@Column(name="name_movie")
	private String nameMovie;

	@Column(name="number_movie")
	private int numberMovie;

	@Column(name="price_movie")
	private double priceMovie;

	@Temporal(TemporalType.DATE)
	@Column(name="year_movie")
	private Date yearMovie;

	//bi-directional many-to-one association to Commentary
	@OneToMany(mappedBy="movie")
	private List<Commentary> commentaries;

	//bi-directional many-to-many association to OrderForm
	@ManyToMany(mappedBy="movies")
	private List<OrderForm> orderForms;

	public Movie() {
	}

	public Integer getIdMovie() {
		return this.idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getDescrMovie() {
		return this.descrMovie;
	}

	public void setDescrMovie(String descrMovie) {
		this.descrMovie = descrMovie;
	}

	public int getDurationMovie() {
		return this.durationMovie;
	}

	public void setDurationMovie(int durationMovie) {
		this.durationMovie = durationMovie;
	}

	public String getGenreMovie() {
		return this.genreMovie;
	}

	public void setGenreMovie(String genreMovie) {
		this.genreMovie = genreMovie;
	}

	public String getNameMovie() {
		return this.nameMovie;
	}

	public void setNameMovie(String nameMovie) {
		this.nameMovie = nameMovie;
	}

	public int getNumberMovie() {
		return this.numberMovie;
	}

	public void setNumberMovie(int numberMovie) {
		this.numberMovie = numberMovie;
	}

	public double getPriceMovie() {
		return this.priceMovie;
	}

	public void setPriceMovie(double priceMovie) {
		this.priceMovie = priceMovie;
	}

	public Date getYearMovie() {
		return this.yearMovie;
	}

	public void setYearMovie(Date yearMovie) {
		this.yearMovie = yearMovie;
	}

	public List<Commentary> getCommentaries() {
		return this.commentaries;
	}

	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

	public Commentary addCommentary(Commentary commentary) {
		getCommentaries().add(commentary);
		commentary.setMovie(this);

		return commentary;
	}

	public Commentary removeCommentary(Commentary commentary) {
		getCommentaries().remove(commentary);
		commentary.setMovie(null);

		return commentary;
	}

	public List<OrderForm> getOrderForms() {
		return this.orderForms;
	}

	public void setOrderForms(List<OrderForm> orderForms) {
		this.orderForms = orderForms;
	}

}