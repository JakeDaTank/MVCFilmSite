package com.skilldistillery.film.data;

import java.util.List;

public interface FilmDao {
	List<Film> getFilmTitleById(int id);
	List<Film> getFilmTitleByKeyword(String key);
	Film addFilm(Film film);
	int deleteFilm(int id);
	Film updateFilm(Film film);
	
}
