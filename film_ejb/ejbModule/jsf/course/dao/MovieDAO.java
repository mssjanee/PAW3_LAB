package jsf.course.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jsf.course.entities.Movie;


@Stateless
public class MovieDAO {
	
	@PersistenceContext
    EntityManager em;
	
	public void insert(Movie movie) {
		em.persist(movie);
	}

	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	public void remove(Movie movie) {
		em.remove(em.merge(movie));
	}

	public Movie get(Object id) {
		return em.find(Movie.class, id);
	}
	
	public List<Movie> getFullList() {
		List<Movie> list = null;

		Query query = em.createQuery("select m from Movie m");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Movie> getList(Map<String, Object> searchParams) {
		List<Movie> list = null;

		// 1. Build query string with parameters
		String select = "select m ";
		String from = "from Movie m ";
		String where = "";
		String orderby = "order by m.nameMovie asc, m.genreMovie ";

		// search for name
		String nameMovie = (String) searchParams.get("nameMovie");
		if (nameMovie != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "m.nameMovie like :nameMovie ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (nameMovie != null) {
			query.setParameter("nameMovie", nameMovie+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
}
