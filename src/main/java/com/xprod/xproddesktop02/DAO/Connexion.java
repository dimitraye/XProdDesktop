package com.xprod.xproddesktop02.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    Connection con;

    public Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xproddb06", "root", "root");
        } catch (Exception e) {
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
