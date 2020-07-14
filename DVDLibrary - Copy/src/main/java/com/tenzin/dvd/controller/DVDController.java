package com.tenzin.dvd.controller;

import com.tenzin.dvd.dao.DVDDao;
import com.tenzin.dvd.dao.DVDDaoException;
import com.tenzin.dvd.dto.DVD;
import com.tenzin.dvd.ui.DVDView;
import java.util.List;

/**
 *
 * @author Tenzin Woesel May 17, 2020
 */
public class DVDController {

    private DVDDao dao;

    private DVDView view;
    

    public DVDController(DVDDao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {

        boolean keepGoing = true;

        try {
            while (keepGoing) {
                int menuSelection = 0;

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        viewParticularDVD();
                        break;
                    case 6:
                        searchDVDByTitle();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

//    private int editMenuSelection() {
//        return view.getEditMenuSelection();
//    }
    private void createDVD() throws DVDDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(),newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDDaoException {
        view.displayAllDVDBanner();
        List<DVD> DVDList = dao.getAllDVD();
        view.displayDVDList(DVDList);
    }

    private void viewParticularDVD() throws DVDDaoException {
        view.displayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getParticularDVD(title);
        view.displayParticularDVDInformation(dvd);
    }

    private void removeDVD() throws DVDDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemovedResult(removedDVD);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void editDVD() throws DVDDaoException {
        view.displayEditBanner();

        //ask user which title to edit. do in view
        String titleToEdit = view.getTitleChoice();
        //send this title to the dao and get the DVD
        DVD DVDToEdit = dao.getParticularDVD(titleToEdit);
        
        if (DVDToEdit != null) {
            //send this DVD to the view. collect the edited version.
            DVD editThisDVD = view.DVDToEditInfo(DVDToEdit);

            //now, send this back to the dao and place it there. 
            dao.addDVD(editThisDVD.getTitle(),editThisDVD);

            view.displayEditedBanner(DVDToEdit);
        } else {
            view.noSuchDVD();
        }

    }

    private void searchDVDByTitle() throws DVDDaoException {
        String DVDToSearch = view.getTitleChoice();

        DVD searchDVD = dao.getParticularDVD(DVDToSearch);

        view.searchDVDByTitle(searchDVD);
    }
}
