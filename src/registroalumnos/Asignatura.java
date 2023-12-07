/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;

/**
 *
 * @author eduar
 */
public class Asignatura {
    
    private String nombre; // Nombre de la asignatura
    private Integer creditos; // Creditos de la asignatura
    private Integer semestre; // Semestre al que pertenece la materia

    /* Constructor */
    public Asignatura(String nombre, Integer creditos, Integer semestre){
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
    }
    public Asignatura(){};
    /* Getters and Setters */
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getCreditos() {
        return this.creditos;
    }
    
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    public Integer getSemestre() {
        return this.semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

}

