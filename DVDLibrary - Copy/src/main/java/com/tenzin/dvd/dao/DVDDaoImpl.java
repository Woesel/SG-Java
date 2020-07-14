package com.tenzin.dvd.dao;

import com.tenzin.dvd.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Tenzin Woesel May 18, 2020
 */
public class DVDDaoImpl implements DVDDao {

    private Map<String, DVD> dvds = new HashMap<>();

    public static final String DVD_FILE = "DVDlibrary.txt";
    public static final String DELIMETER = "::";

    //We put the suppllied DVD into our map using the supplied DVDTitle as the key
    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDDaoException {
        loadLibrary();
        DVD prevDVD = dvds.put(dvd.getTitle(), dvd);
        writeLibrary();
        return prevDVD;
    }

    @Override
    public List<DVD> getAllDVD() throws DVDDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getParticularDVD(String title) throws DVDDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    private DVD unmarshallDVD(String DVDlibraryAsText) {

        String[] DVDtokens = DVDlibraryAsText.split(DELIMETER);
        String title = DVDtokens[0];
        DVD DVDfromFile = new DVD(title);

        //Index 1 - releaseDate
        DVDfromFile.setReleaseDate(DVDtokens[1]);
        //Index 2 - MPAARating
        DVDfromFile.setMPAARating(DVDtokens[2]);
        //Index 3 - directorName
        DVDfromFile.setDirectorName(DVDtokens[3]);
        //Index 4 - studio
        DVDfromFile.setStudio(DVDtokens[4]);
        //Index 5 - userRating
        DVDfromFile.setUserRating(DVDtokens[5]);

        return DVDfromFile;
    }

    private void loadLibrary() throws DVDDaoException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));

        } catch (FileNotFoundException e) {
            throw new DVDDaoException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        DVD currentDVD;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentDVD = unmarshallDVD(currentLine);

            //Use title as the map key for our DVD object
            //put currentDVD into the map using title as the key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();
    }

    private String marshallDVD(DVD aDVD) {

        String DVDlibraryAsText = aDVD.getTitle() + DELIMETER;

        DVDlibraryAsText += aDVD.getReleaseDate() + DELIMETER;
        DVDlibraryAsText += aDVD.getMPAARating() + DELIMETER;
        DVDlibraryAsText += aDVD.getDirectorName() + DELIMETER;
        DVDlibraryAsText += aDVD.getStudio() + DELIMETER;
        DVDlibraryAsText += aDVD.getUserRating();

        return DVDlibraryAsText;
    }

    private void writeLibrary() throws DVDDaoException {

        PrintWriter out;

        try {

            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDDaoException("Could not save library.", e);

        }

        String DVDlibraryAsText;
        List<DVD> DVDlist = new ArrayList(dvds.values());
        for (DVD currentDVD : DVDlist) {

            //turn a DVD into a String
            DVDlibraryAsText = marshallDVD(currentDVD);

            //write the DVD object to the file
            out.println(DVDlibraryAsText);

            //force PrintWriter to write line to the file.
            out.flush();
        }

        out.close();

    }

}
