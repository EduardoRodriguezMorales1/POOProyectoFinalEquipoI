/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;
/**
*
* @author equipo I
 */

import java.io.RandomAccessFile; // 
import java.util.Random; // Numeros aleatorios
import java.io.IOException; // Excepciones
public class GenNombres {
    
    /**
     * Metodo que genera aleatoreamente la edad de los alumnos de entre 18 y 28 años
     * @return regresa la edad de los alumnos
     */
    public static Integer generadorEdad(){
        Random random = new Random();
        // Generar edades entre 18 y 27 
        Integer edad = random.nextInt(18, 28);

        return edad;
    }


    // Genera un alumno con su nombre y apellidos
    /**
     * Método que genera datos de un alumno con los archivos .txt
     * @param id parametro identificador del alumno
     * @return regresa un alumno con nombre, direccion, edad, promedio, num. inscripcion, num cuenta y semestre
     */
    public static Alumno generarAlumno(Integer id){
        Alumno alumno = new Alumno(id);
        alumno.setNumeroCuenta(); // Genera un numero de cuenta

        String rutaArchivo; // Ruta de los archivos de texto
        String linea = ""; // Almacena la linea del archivo

        // Se intancia RANDOM
        Random random = new Random();
        
        /* Genera hombre o mujer */
        int numAleatorio = random.nextInt(2); // Determina si es hombre o mujer

        // 0 : Hombre      1 : Mujer
        if (numAleatorio == 0){
            //System.out.println("Es hombre");
            rutaArchivo = "src/nombreH.txt";
        }else{
            //System.out.println("Es mujer");
            rutaArchivo = "src/nombreM.txt";
        }

        
        /* Genera el nombre del alumno */ 
        numAleatorio = random.nextInt(50) + 1; // Genera numero aleatorio del 1 al 50
        
        // Captura la linea que se encuentra en el renglon(numAleatorio)
        try(RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")){
            for (int i = 1; i <= numAleatorio; i++) {
                linea = archivo.readLine();
            }
            // Le asigna el nombre obtenido al alumno
            alumno.setNombre(linea);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        /* Genera los apellidos del alumno */
        rutaArchivo = "src/apellidos.txt";
        
        // Primer apellido
        numAleatorio = random.nextInt(50) + 1; // Genera numero aleatorio del 1 al 50
        
        try(RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")){
            // Captura el apellido en la linea numAleatorio
            for (int i = 1; i <= numAleatorio; i++) {
                linea = archivo.readLine();
            }
            // Asigna el primer apellido al alumno
            alumno.setApellidoP(linea);
            
            // Segundo apellido
            archivo.seek(0); // Posiciona el cursor al inicio del archivo
            numAleatorio = random.nextInt(50) + 1; // Genera numero aleatorio del 1 al 50
            
            for (int i = 1; i <= numAleatorio; i++) {
                linea = archivo.readLine();
            }
            // Asigna el segundo apellido al alumno
            alumno.setApellidoM(linea);

        }catch(IOException e){
            e.printStackTrace();
        }

        /* Se asigna edad */
        alumno.setEdad(generadorEdad());
        alumno.setSemestre();
        
        return alumno;
        
    }

}

