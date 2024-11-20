package com.xprod.xproddesktop02.DAO;

import com.xprod.xproddesktop02.model.Users;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public UserDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xproddb06", "root", "root");
            st = con.createStatement();

        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "La connection à la base de données a échoué, une erreur s'est produite"+e);
        }
    }

    public List rechercheLogin(String username, String password) {

        List logLogin = new ArrayList();
        //int result;
        sql = "select username, password, authorization from user where username='"+username+"' and password='"+password+"' ";


        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAuthorization(rs.getString("authorization"));


                logLogin.add(user);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors du login : \n"+e);

        }

        return logLogin;
    }
}
