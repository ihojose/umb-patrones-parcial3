package com.ihojose.umb.parcial;

import com.ihojose.umb.parcial.singleton.Anime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestingConnection {

    public static void main(String[] args) {

        Anime anime = new Anime();

        try {
            ResultSet rs = anime.getAnimes();

            // Show anime list by Jose Buelvas in Heroku Database
            System.out.println("LISTA DE ANIMES POR JOSE BUELVAS Y MATT ORTIZ");
            while (rs.next()) {
                System.out.printf("%1$-50s%n", "--------------------------------------------------");
                System.out.printf("Nombre: %1$s%n", rs.getString("name"));
                System.out.printf("Japonés: %1$s%n", rs.getString("kanji"));
                System.out.printf("Sinopsis: %1$s%n", rs.getString("synopsis"));
                System.out.printf("Fecha de lanzamiento: %1$s%n", rs.getString("aired"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
