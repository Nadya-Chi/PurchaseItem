package ru.netology.manager;

import ru.netology.domain.Poster;

public class PosterManager {
    private Poster[] films = new Poster[0];

    int count = 10;
    public PosterManager(int count) {
        if (count < 10) {
            this.count = count;
        }
    }

    public void addFilm(Poster film) {
        Poster[] tmp = new Poster[films.length + 1];

        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }

        int lastFilm = tmp.length - 1;
        tmp[lastFilm] = film;
        films = tmp;
    }

    public Poster[] getAll() {
        Poster[] result = new Poster[films.length];

        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Poster[] getLimit() {
        Poster[] limit = new Poster[films.length];

        for (int i = 0; i < limit.length; i++) {
            int index = films.length - i - 1;
            limit[i] = films[index];
        }
        return limit;
    }
}
