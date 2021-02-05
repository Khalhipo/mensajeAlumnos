/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author Bueno
 */
public class Utilidades {

    public static ArrayList<Alumno> getAlumnos(String fichero) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        try {

            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "utf-8"));
            String linea;
            try {

                while ((linea = buffer.readLine()) != null) {
                    String[] arrayDatos = linea.split(";");
                    Alumno nuevoAlumno = new Alumno(Integer.parseInt(arrayDatos[0]),arrayDatos[1],arrayDatos[2],arrayDatos[3]);
                    alumnos.add(nuevoAlumno);
                }

                buffer.close();
            } catch (IOException e) {

            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {

        }
        return alumnos;
    }
}
