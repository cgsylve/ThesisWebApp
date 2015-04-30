/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import model.Users;

/**
 *
 * @author Huan_Nguyen
 */
public interface StudentDAO {
    public ArrayList findAll();
    public ArrayList findAllPending();
    public ArrayList findloginSTUID(String aSTUID);
    public ArrayList selectLoginFromStudent(String query);
    public boolean exist(String aSTUID);
    public boolean pendingUserExists(String userID);
    public ArrayList findBySTUID(String aSTUID);
    public ArrayList findPendBySTUID(String aSTUID);
    public int createUser(Users user);
    public int pendingToUser(Users user);
    public boolean removePendingUser(Users pendingUser);
    public boolean removeUser(Users pendingUser);
}
