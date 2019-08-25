package org.fasttrackit;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Game game = new Game();
        game.start();
    }
}
