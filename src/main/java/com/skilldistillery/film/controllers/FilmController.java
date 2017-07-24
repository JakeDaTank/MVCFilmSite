package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.Film;
import com.skilldistillery.film.data.FilmDao;
@Controller
public class FilmController {
	@Autowired
	private FilmDao dao;

	// Get film by title
	@RequestMapping(path = "getTitle.do")
	public ModelAndView getFilmTitleById(@RequestParam(name = "filmId") Integer filmId) {
		String viewName = "WEB-INF/views/searchresult.jsp";
		ModelAndView mv = new ModelAndView(viewName);
		List<Film> films = dao.getFilmTitleById(filmId);
		mv.addObject("filmTitlekey", films);
		return mv;
	}
	
	@RequestMapping(path = "getKeyword.do")
	public ModelAndView getFilmTitleByKeyword(@RequestParam("filmkey") String filmkey) {
		String viewName = "WEB-INF/views/searchresult.jsp";
		ModelAndView mv = new ModelAndView(viewName);
		List<Film> films = dao.getFilmTitleByKeyword(filmkey);
		mv.addObject("filmTitlekey", films);
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addnewFilm(RedirectAttributes redir,@RequestParam("film title") String title, @RequestParam("film length") int length,
			@RequestParam("film rating") String rating, @RequestParam("film description") String description) {
		
		Film film = new Film(length, rating, title, description);
		String viewName = "redirect:addFilm2.do";
		ModelAndView mv = new ModelAndView(viewName);
		redir.addFlashAttribute("film", dao.addFilm(film));

		return mv;
	}
	@RequestMapping(path = "addFilm2.do", method = RequestMethod.GET)
	public ModelAndView addnewFilm2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/result.jsp");
		return mv;
	}
	
	@RequestMapping(path = "home.do")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/home.jsp");
		return mv;
	}
	
	@RequestMapping(path = "updatefilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(RedirectAttributes redir, @RequestParam("film title") String title, @RequestParam("film length") int length, @RequestParam("film rating") String rating, @RequestParam("film description") String description, @RequestParam("film id") int id) {
		Film film = new Film(length, rating, title, description);
		film.setID(id);
		String viewName = "redirect:updateFilm2.do";
		ModelAndView mv = new ModelAndView(viewName);
		dao.updateFilm(film);
		redir.addAttribute("updatedfilm", film.getTitle());		
		return mv;
	}
	@RequestMapping(path = "updateFilm2.do", method = RequestMethod.GET)
	public ModelAndView updateFilm2(RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/updateresult.jsp");
		return mv;
	}
	@RequestMapping(path = "deletefilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(RedirectAttributes redir, @RequestParam("id") int id) {
		String viewName = "redirect:deleteFilmRedir.do";
		ModelAndView mv = new ModelAndView(viewName);
		redir.addAttribute("filmid", dao.deleteFilm(id));
		return mv;
	}
	
	@RequestMapping(path = "deleteFilmRedir.do", method = RequestMethod.GET)
	public ModelAndView deleteFilm2(RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/deleteresult.jsp");
		return mv;
	}
	
}
