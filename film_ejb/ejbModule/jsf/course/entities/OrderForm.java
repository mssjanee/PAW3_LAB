package jsf.course.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the order_form database table.
 * 
 */
@Entity
@Table(name="order_form")
@NamedQuery(name="OrderForm.findAll", query="SELECT o FROM OrderForm o")
public class OrderForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_order_form")
	private int idOrderForm;

	@Column(name="nb_mov_ord")
	private int nbMovOrd;

	@Column(name="nb_order")
	private int nbOrder;

	@Column(name="us_credit_ord")
	private int usCreditOrd;

	@Column(name="us_email_ord")
	private String usEmailOrd;

	@Column(name="us_name_ord")
	private String usNameOrd;

	@Column(name="us_price_ord")
	private String usPriceOrd;

	@Column(name="us_surname_ord")
	private String usSurnameOrd;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-many association to Movie
	@ManyToMany
	@JoinTable(
		name="order_movie"
		, joinColumns={
			@JoinColumn(name="id_order_form")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_movie")
			}
		)
	private List<Movie> movies;

	public OrderForm() {
	}

	public int getIdOrderForm() {
		return this.idOrderForm;
	}

	public void setIdOrderForm(int idOrderForm) {
		this.idOrderForm = idOrderForm;
	}

	public int getNbMovOrd() {
		return this.nbMovOrd;
	}

	public void setNbMovOrd(int nbMovOrd) {
		this.nbMovOrd = nbMovOrd;
	}

	public int getNbOrder() {
		return this.nbOrder;
	}

	public void setNbOrder(int nbOrder) {
		this.nbOrder = nbOrder;
	}

	public int getUsCreditOrd() {
		return this.usCreditOrd;
	}

	public void setUsCreditOrd(int usCreditOrd) {
		this.usCreditOrd = usCreditOrd;
	}

	public String getUsEmailOrd() {
		return this.usEmailOrd;
	}

	public void setUsEmailOrd(String usEmailOrd) {
		this.usEmailOrd = usEmailOrd;
	}

	public String getUsNameOrd() {
		return this.usNameOrd;
	}

	public void setUsNameOrd(String usNameOrd) {
		this.usNameOrd = usNameOrd;
	}

	public String getUsPriceOrd() {
		return this.usPriceOrd;
	}

	public void setUsPriceOrd(String usPriceOrd) {
		this.usPriceOrd = usPriceOrd;
	}

	public String getUsSurnameOrd() {
		return this.usSurnameOrd;
	}

	public void setUsSurnameOrd(String usSurnameOrd) {
		this.usSurnameOrd = usSurnameOrd;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}