package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.poster.Poster;

public class PosterManagerTest {

    Poster poster1 = new Poster(1, "Бладшот", "боевик");
    Poster poster2 = new Poster(2, "Вперёд", "Мультфильм");
    Poster poster3 = new Poster(3, "Отель Белград", "комедия");
    Poster poster4 = new Poster(4, "Джентельмены", "боевик");
    Poster poster5 = new Poster(5, "Человек невидимка", "ужасы");
    Poster poster6 = new Poster(6, "Тролли.Мировой тур ", "мультфильм");
    Poster poster7 = new Poster(7, "Номер один", "комедия");

    @Test
    public void addAndFindPosterTest() {
        PosterManager manager = new PosterManager();
        manager.addPoster(poster1);
        manager.addPoster(poster2);
        manager.addPoster(poster3);
        manager.addPoster(poster4);
        manager.addPoster(poster5);
        manager.addPoster(poster6);
        manager.addPoster(poster7);

        Poster[] expected = {poster1, poster2, poster3, poster4, poster5, poster6, poster7};
        Poster[] actual = manager.findAllPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reservedPosterByDefaultTest() {
        PosterManager manager = new PosterManager();
        manager.addPoster(poster1);
        manager.addPoster(poster2);
        manager.addPoster(poster3);
        manager.addPoster(poster4);
        manager.addPoster(poster5);
        manager.addPoster(poster6);
        manager.addPoster(poster7);

        Poster[] expected = {poster7, poster6, poster5, poster4, poster3};
        Poster[] actual = manager.findLastPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reservedPosterWithNumberBelowMaxTest() {
        PosterManager manager = new PosterManager(4);
        manager.addPoster(poster1);
        manager.addPoster(poster2);
        manager.addPoster(poster3);
        manager.addPoster(poster4);
        manager.addPoster(poster5);
        manager.addPoster(poster6);
        manager.addPoster(poster7);

        Poster[] expected = {poster7, poster6, poster5, poster4,};
        Poster[] actual = manager.findLastPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reservedPosterWithNumberAboveMaxTest() {
        PosterManager manager = new PosterManager(8);
        manager.addPoster(poster1);
        manager.addPoster(poster2);
        manager.addPoster(poster3);
        manager.addPoster(poster4);
        manager.addPoster(poster5);
        manager.addPoster(poster6);
        manager.addPoster(poster7);

        Poster[] expected = {poster7, poster6, poster5, poster4, poster3, poster2, poster1};
        Poster[] actual = manager.findLastPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reservedPosterWithNumberLessThenZeroTest1() {
        PosterManager manager = new PosterManager(-1);
        manager.addPoster(poster1);
        manager.addPoster(poster2);
        manager.addPoster(poster3);
        manager.addPoster(poster4);
        manager.addPoster(poster5);
        manager.addPoster(poster6);
        manager.addPoster(poster7);

        Poster[] expected = {};
        Poster[] actual = manager.findLastPosters();

        Assertions.assertArrayEquals(expected, actual);
    }
}
