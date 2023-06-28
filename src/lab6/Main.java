package lab6;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab6.controllers.CollectionController;
import lab6.controllers.LocaleController;
import lab6.controllers.RemoteController;
import lab6.model.User;
import lab6.model.UserCredentials;
import lab6.udp.UDPException;
import lab6.udp.UDPManager;
import lab6.view.LoginView;


public class Main {
    private static UDPManager udpManager = null;
    private static User currentUser = null;
    private static UserCredentials credentials = null;
    private static LocaleController localeController;
    private static CollectionController collectionController;
    public static void main(String[] args) {
        localeController = new LocaleController();
        try {
            udpManager = new UDPManager();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        collectionController = new RemoteController();
        try {
            LoginView.main(args);
        } catch(UDPException ex) {
            System.out.println(ex);
        }
    }

    public static UDPManager getUdpManager() {
        return udpManager;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Main.currentUser = currentUser;
    }

    public static UserCredentials getCredentials() {
        return credentials;
    }

    public static void setCredentials(UserCredentials credentials) {
        Main.credentials = credentials;
    }

    public static LocaleController getLocaleController() {
        return localeController;
    }

    public static void setLocaleController(LocaleController localeController) {
        Main.localeController = localeController;
    }

    public static CollectionController getCollectionController() {
        return collectionController;
    }

    public static void setCollectionController(CollectionController collectionController) {
        Main.collectionController = collectionController;
    }
    
}