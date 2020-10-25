package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosterManagerTest {
    Poster first = new Poster(1, 1, "first", 1);
    Poster second = new Poster(2, 2, "second", 2);
    Poster third = new Poster(3, 3, "third", 3);
    Poster fourth = new Poster(4, 4, "fourth", 4);
    Poster fifth = new Poster(5, 5, "fifth", 5);
    Poster sixth = new Poster(6, 6, "sixth", 6);
    Poster seventh = new Poster(7, 7, "seventh", 7);
    Poster eighth = new Poster(8, 8, "eighth", 8);
    Poster ninth = new Poster(9, 9, "ninth", 9);
    Poster tenth = new Poster(10, 10, "tenth", 10);

    @Test
    public void addFilm() {
        PosterManager manager = new PosterManager(10);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);

        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLimit() {
        PosterManager manager = new PosterManager(5);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);

        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[] {fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }

}
