/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Bueno
 */
public class Utilidades {

    public static ArrayList<Alumno> getAlumnos(String grupo) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_mensajesAlumnos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM alumnos WHERE grupo='" + grupo + "'";
        Query q = manager.createNativeQuery(sql,Alumnos.class);
        List<Alumnos> alumnosBD =  q.getResultList();
        for ( Alumnos a: alumnosBD ){
            Alumno miAlumno = new Alumno(a.getId(),a.getNombre(),a.getApellidos(),a.getCorreo());
            alumnos.add(miAlumno);         
        }
        return alumnos;
        
    }
}
