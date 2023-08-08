package ru.netology.movieposter;

public class PosterManager {
    private int viewLimit = 5;

    public PosterManager(int viewLimit) {
        this.viewLimit = viewLimit;
    }

    private PosterItem[] items = new PosterItem[0];


    public int getViewLimit() {
        return viewLimit;
    }

    public PosterManager() {
    }

    public void saveMovie(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public PosterItem[] findAll() {

        return items;
    }

    public PosterItem[] findLast() {
        int resultLength;
        if (viewLimit > items.length) {
            resultLength = items.length;
        } else {
            resultLength = viewLimit;
        }

        PosterItem[] result = new PosterItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }

}
