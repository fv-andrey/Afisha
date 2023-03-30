package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterTest {

    @Test
    public void setIDTest() {
        Poster poster = new Poster();
        poster.setId(1);

        int expected = 1;
        int actual = poster.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setTitleTest() {
        Poster poster = new Poster();
        poster.setTitle("Вперёд");

        String expected = "Вперёд";
        String actual = poster.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setGenreTest() {
        Poster poster = new Poster();
        poster.setGenre("мультфильм");

        String expected = "мультфильм";
        String actual = poster.getGenre();

        Assertions.assertEquals(expected, actual);
    }
}