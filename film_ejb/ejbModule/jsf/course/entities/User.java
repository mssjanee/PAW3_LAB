package jsf.course.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	@Column(name="email_user")
	private String emailUser;

	@Column(name="log_user")
	private String logUser;

	@Column(name="name_user")
	private String nameUser;

	@Column(name="pss_user")
	private String pssUser;

	//bi-directional many-to-one association to Commentary
	@OneToMany(mappedBy="user")
	private List<Commentary> commentaries;

	//bi-directional many-to-one association to OrderForm
	@OneToMany(mappedBy="user")
	private List<OrderForm> orderForms;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="users")
	private List<Role> roles;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmailUser() {
		return this.emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getLogUser() {
		return this.logUser;
	}

	public void setLogUser(String logUser) {
		this.logUser = logUser;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPssUser() {
		return this.pssUser;
	}

	public void setPssUser(String pssUser) {
		this.pssUser = pssUser;
	}

	public List<Commentary> getCommentaries() {
		return this.commentaries;
	}

	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

	public Commentary addCommentary(Commentary commentary) {
		getCommentaries().add(commentary);
		commentary.setUser(this);

		return commentary;
	}

	public Commentary removeCommentary(Commentary commentary) {
		getCommentaries().remove(commentary);
		commentary.setUser(null);

		return commentary;
	}

	public List<OrderForm> getOrderForms() {
		return this.orderForms;
	}

	public void setOrderForms(List<OrderForm> orderForms) {
		this.orderForms = orderForms;
	}

	public OrderForm addOrderForm(OrderForm orderForm) {
		getOrderForms().add(orderForm);
		orderForm.setUser(this);

		return orderForm;
	}

	public OrderForm removeOrderForm(OrderForm orderForm) {
		getOrderForms().remove(orderForm);
		orderForm.setUser(null);

		return orderForm;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}