package com.skilldistillery.film.data;

import java.util.List;

public interface FilmDao {
	Film addFilm(Film film);
	Film updateFilm(Film film);
	int deleteFilm(int id);
	List<Film> getFilmTitleById(int ID);
	List<Film> getFilmTitleByKeyword(String key);
	
}
