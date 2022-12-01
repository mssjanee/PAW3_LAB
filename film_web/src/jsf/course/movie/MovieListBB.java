package jsf.course.movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import jsf.course.dao.MovieDAO;
import jsf.course.entities.Movie;


@Named
@RequestScoped
public class MovieListBB {
	private static final String PAGE_MOVIE_EDIT = "movieEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String nameMovie;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	MovieDAO movieDAO;
		
	public String getNameMovie() {
		return nameMovie;
	}

	public void setNameMovie(String nameMovie) {
		this.nameMovie = nameMovie;
	}

	public List<Movie> getFullList(){
		return movieDAO.getFullList();
	}

	public List<Movie> getList(){
		List<Movie> list = null;

		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nameMovie != null && nameMovie.length() > 0){
			searchParams.put("nameMovie", nameMovie);
		}
		
		//2. Get list
		list = movieDAO.getList(searchParams);
		return list;
	}

	public String newMovie(){
		Movie movie = new Movie();
		
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("person", person);
		
		//2. Pass object through flash	
		flash.put("movie", movie);
		
		return PAGE_MOVIE_EDIT;
	}

	public String editMovie(Movie movie){
		flash.put("movie", movie);
		return PAGE_MOVIE_EDIT;
	}
		
	

	public String deleteMovie(Movie movie){
		movieDAO.remove(movie);
		return PAGE_STAY_AT_THE_SAME;

	}
}
