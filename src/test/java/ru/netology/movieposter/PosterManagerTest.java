package ru.netology.movieposter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    PosterItem item1 = new PosterItem(1, "Бладшот");
    PosterItem item2 = new PosterItem(2, "Вперед");
    PosterItem item3 = new PosterItem(3, "Отель Белград");

    @Test
    public void shouldAll() {
        PosterManager repo = new PosterManager();
        repo.saveMovie(item1);
        repo.saveMovie(item2);
        repo.saveMovie(item3);

        PosterItem[] expected = {item1, item2, item3};
        PosterItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastIfItemsLessLimit() {
        PosterManager repo = new PosterManager(3);
        repo.saveMovie(item1);
        repo.saveMovie(item2);
        repo.saveMovie(item3);

        PosterItem[] expected = {item3, item2, item1};
        PosterItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastIfItemsMoreLimit() {
        PosterManager repo = new PosterManager(6);
        repo.saveMovie(item1);
        repo.saveMovie(item2);
        repo.saveMovie(item3);

        PosterItem[] expected = {item3, item2, item1};
        PosterItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastIfItemsEqualsLimit() {
        PosterManager repo = new PosterManager(5);
        repo.saveMovie(item1);
        repo.saveMovie(item2);
        repo.saveMovie(item3);

        PosterItem[] expected = {item3, item2, item1};
        PosterItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
