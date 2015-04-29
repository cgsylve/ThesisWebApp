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
    public ArrayList findloginSTUID(String aSTUID);
    public ArrayList selectLoginFromStudent(String query);
    public boolean exist(String aSTUID);
    public ArrayList findBySTUID(String aSTUID);
    public int createUser(Users user);
}
