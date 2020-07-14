package com.tenzin.dvd.dto;

/**
 *
 * @author Tenzin Woesel May 17, 2020
 */
public class DVD {

    private final String title;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String studio;
    private String userRating;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "DVD{" + "title=" + title + ", releaseDate=" + releaseDate + ", MPAARating=" + MPAARating + ", directorName=" + directorName + ", studio=" + studio + ", userRating=" + userRating + '}';
    }
    
    

}
