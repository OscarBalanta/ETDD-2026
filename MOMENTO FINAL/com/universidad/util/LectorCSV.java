package com.universidad.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorCSV {

    public static ArrayList<String[]> leer(String ruta) {

        ArrayList<String[]> datos = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                datos.add(linea.split(","));
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

        return datos;
    }
}
