/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Users;

/**
 *
 * @author admin
 */
public interface ProfileDAO {
    
    public int createProfile(Users newUser);
    public ArrayList findAll();
    public ArrayList findByUserID(String userID); // either get one back or several if multiple same name allowed 
    public boolean userIDExists(String userID);
    
}
