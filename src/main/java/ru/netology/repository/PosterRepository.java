package ru.netology.repository;

import ru.netology.domain.Poster;

public class PosterRepository {
    private Poster[] films = new Poster[0];

    public void save(Poster film) {
        Poster[] tmp = new Poster[films.length + 1];

        System.arraycopy(films, 0, tmp, 0, films.length);

        int lastFilm = tmp.length - 1;
        tmp[lastFilm] = film;

        films = tmp;
    }

    public Poster[] findAll() {
        return films;
    }

    public void removeById(int id) {
        Poster[] tmp = new Poster[films.length - 1];

        int index = 0;
        for (Poster item: films) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }

        films = tmp;
    }

    public Poster findById(int id) {
        for (Poster film : films) {
            if (film.getFilmId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeAll() {
        films = new Poster[0];
    }
}
