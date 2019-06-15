package sg.edu.rp.c346.pdapp4;

import java.io.Serializable;

public class Show implements Serializable {
    private int id;
    private String shows;
    private String language;
    private String genre;
    private int stars;

    public Show(int id, String shows, String language, String genre, int stars) {
        this.id = id;
        this.language = language;
        this.shows = shows;
        this.genre = genre;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShows() {
        return shows;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", " + "Title: " + shows + ", " + "Language: " + language + ", " + "Genre: " + genre + ", " + "Stars: " +stars;
    }

}
