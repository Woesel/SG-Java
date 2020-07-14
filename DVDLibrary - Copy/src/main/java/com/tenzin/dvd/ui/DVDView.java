package com.tenzin.dvd.ui;

import com.tenzin.dvd.dto.DVD;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tenzin Woesel May 17, 2020
 */
public class DVDView {

    private UserIO io;

    public DVDView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. Add DVD.");
        io.print("2. Remove DVD.");
        io.print("3. Edit DVD information.");
        io.print("4. List DVD.");
        io.print("5. Display information for a DVD");
        io.print("6. Search DVD by title.");
        io.print("7. Exit.");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD getNewDVDInfo() {

        String title = io.readString("Please enter DVD title.");
        String releaseDate = io.readString("Please enter the release date for DVD.");
        String MPAARating = io.readString("Enter the MPAARating for the DVD.");
        String directorName = io.readString("Enter the director name for DVD.");
        String studio = io.readString("Enter the studio name for DVD.");
        String userRating = io.readString("Enter your rating or short note for the DVD");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=====Create DVD=====");
    }

    public void displayCreateSuccessBanner() {
        io.pressEnterToContinue("DVD successfully created. Please hit enter to continue.");
    }

    public void displayDVDList(List<DVD> dvdList) {

        for (DVD currentDVD : dvdList) {

            String DVDInfo = String.format("DVD Title : %s", currentDVD.getTitle());
            io.print(DVDInfo);
        }
        io.pressEnterToContinue("Please hit enter to continue.");
    }

    public void displayAllDVDBanner() {
        io.print("===== Display All DVD =====");
    }

    public void displayDVDBanner() {
        io.print("===== Display DVD =====");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }

    public void displayParticularDVDInformation(DVD dvd) {
        if (dvd != null) {
            io.print("DVD Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAARating: " + dvd.getMPAARating());
            io.print("Director Name: " + dvd.getDirectorName());
            io.print("Studio: " + dvd.getStudio());
            io.print("User Rating: " + dvd.getUserRating());
        } else {
            io.print("No such DVD in the library.");
        }
        io.pressEnterToContinue("Please hit Enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("==== Remove DVD ====");
    }

    public void displayRemovedResult(DVD DVDRecord) {

        if (DVDRecord != null) {

            io.print("DVD successfully removed.");
        } else {
            io.print("No such dvd in the library.");
        }
        io.pressEnterToContinue("Please hit Enter to continue.");
    }

    public void displayExitBanner() {

        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {

        io.print("====Error====");
        io.print(errorMsg);
    }

    public void searchDVDByTitle(DVD dvd) {

        if (dvd != null) {

            io.print(dvd.getTitle() + " is available in the library.");

        } else {
            io.print("No such DVD in the library.");
        }
        io.pressEnterToContinue("Please hit Enter to continue.");

    }

    public void displayEditBanner() {

        io.print("=====Edit DVD=====");
    }

    public void displayEditedBanner(DVD edit) {
        io.print("DVD successfully edited.");
    }

    public DVD DVDToEditInfo(DVD DVDToEdit) {

        String editMore;
        do {

            io.print("Edit Menu");
            io.print("1. Release Date");
            io.print("2. MPAARating");
            io.print("3. Director Name");
            io.print("4. Studio");
            io.print("5. User Rating");

            int menuSelection = io.readInt("Please select from the above choice", 0, 6);

            switch (menuSelection) {
                case 1:
                    //System.out.println("Works");
                    String releaseDate = io.readString("Please enter the release date for DVD.");
                    DVDToEdit.setReleaseDate(releaseDate);
                    break;
                case 2:
                    String MPAARating = io.readString("Enter the MPAARating for the DVD.");
                    DVDToEdit.setMPAARating(MPAARating);
                    break;
                case 3:
                    String directorName = io.readString("Enter the director name for DVD.");
                    DVDToEdit.setDirectorName(directorName);
                    break;
                case 4:
                    String studio = io.readString("Enter the studio name for DVD.");
                    DVDToEdit.setStudio(studio);
                    break;
                case 5:
                    String userRating = io.readString("Enter your rating or short note for the DVD");
                    DVDToEdit.setUserRating(userRating);
                    break;

            }

            editMore = io.readString("Do you want to edit any other information? y/n");

        } while (editMore.equals("y"));

        return DVDToEdit;
    }

    public void noSuchDVD() {
        io.print("No such DVD in the library.");
    }
}
