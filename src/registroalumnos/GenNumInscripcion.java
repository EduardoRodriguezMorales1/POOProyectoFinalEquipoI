/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;

/**
 *
 * @author equipo I
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenNumInscripcion {
    /**
     * Metodo que genera el numero de inscripcion de los alumnos
     * @param promedio Toma como parametro el promedio de cada alumno para poder generar el numero de inscripcion
     * @return regresa el numero de inscripcion del alumno
     */
    public String generarIndicador(Double promedio){

        Double escolaridad;
        Double velocidad;
        Double indicador;
        String indicadorEscolar = "";

        escolaridad = Double.valueOf(100);
        // System.out.println("Escolareidad: "+escolaridad);
        velocidad = Double.valueOf(100);
        // System.out.println("Velocidad: "+velocidad);
        indicador = Double.valueOf(promedio*escolaridad*velocidad);

        indicadorEscolar = indicador.toString();
        // System.out.println("Indicador escolar: "+indicador);
        return indicadorEscolar;
    }

    /**
     * Metdo que ordena a los alumnos dependiendo de su numero de inscripcion
     * @param alumnos recibe como parametro el numero de inscripcion del array de alumnos
     */
    public static void ordenarPorNumInscripcion(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion).reversed();
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    
    /**
     * Segundo metodo que ordena a los alumnos agregados por su numero de inscripcion
     * @param alumnos recibe como parametro un alumno de la lista de alumnos
     */
    public static void ordenarPorNumInscripcion2(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion);
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    

    
    
}
