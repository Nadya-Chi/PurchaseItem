package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

public class PosterManager {
    private PosterRepository repository;

    int count = 10;

    public PosterManager(PosterRepository repository, int count) {
        if (count != 10){
            this.count = count;
        }
        this.repository = repository;
    }

    public void addFilm(Poster film) {
        repository.save(film);
    }

    public Poster[] getAll() {
        Poster[] films = repository.findAll();
        Poster[] result = new Poster[films.length];

        for (int i = 0; i < result.length; i++) {
            int index = result.length - 1 - i;
            result[i] = films[index];
        }

        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
