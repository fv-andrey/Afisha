package ru.netology.manager;

import ru.netology.poster.Poster;

public class PosterManager {

    private Poster[] posters = new Poster[0];
    private int lastPosters;

    PosterManager(int lastPosters) {
        if (lastPosters < 0) {
            lastPosters = posters.length;
        }
        this.lastPosters = lastPosters;
    }

    PosterManager() {
        lastPosters = 5;
    }

    void addPoster(Poster poster) {
        Poster[] tmp = new Poster[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = poster;
        posters = tmp;
    }

    Poster[] findAllPosters() {
        return posters;
    }

    Poster[] findLastPosters() {
        int length;
        if (posters.length < lastPosters) {
            length = posters.length;
        } else {
            length = lastPosters;
        }
        Poster[] result = new Poster[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = posters[posters.length - 1 - i];
        }
        return result;
    }
}
