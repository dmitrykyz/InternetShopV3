package by.pvt.logic;

import by.pvt.entity.Admin;
import by.pvt.entity.Client;
import by.pvt.services.impl.AdminServiceImpl;
import by.pvt.services.impl.ClientServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class LoginLogic {
    private static Logger log = Logger.getLogger(LoginLogic.class);
    private static int ID = 1;
    private static String LOGIN = "";
    private static String PASS = "";
    private static int USER_TYPE = 0;
    private static int IN_BLACK_LIST = 0;
    private static boolean isClient = false;
    private static boolean isAdmin = false;


    public static boolean checkLogin(String enterLogin, String enterPass) {
        log.info("Checking Login in class LoginLogic");
        isClient = false;
        isAdmin = false;

        ClientServiceImpl clientService = new ClientServiceImpl();
        List<Client> clients = (List<Client>)clientService.getClientByLogin(enterLogin);
        if (clients == null) isClient = false;
        for (Client client: clients) {
            ID = client.getIdUser();
            LOGIN = client.getLogin();
            PASS = client.getPassword();
            USER_TYPE = client.getUserType();
            IN_BLACK_LIST = client.getInBlackList();
            if (LOGIN.equals(enterLogin) && PASS.equals(enterPass) && IN_BLACK_LIST==0) isClient = true;
        }
        AdminServiceImpl adminService = new AdminServiceImpl();
        List<Admin> admins = (List<Admin>)adminService.getAdminByLogin(enterLogin);
        if (admins == null) isAdmin = false;
        for (Admin admin: admins) {
            ID = admin.getIdUser();
            LOGIN = admin.getLogin();
            PASS = admin.getPassword();
            USER_TYPE = admin.getUserType();
            if (LOGIN.equals(enterLogin) && PASS.equals(enterPass)) isAdmin = true;
        }

        return isAdmin == true || isClient == true;
    }

    public static int getUserType() {
        return USER_TYPE;
    }

    public static int getInBlackList() {
        return IN_BLACK_LIST;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static boolean getIsClient() {
        return isClient;
    }

    public static boolean getIsAdmin() {
        return isAdmin;
    }

    public static int getID() {
        return ID;
    }
}
