/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;
import java.io.RandomAccessFile;
import java.util.Random;
/**
 *
 * @author eduar
 */
public class Alumno {
    /* Atributos */
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Integer edad;
    private String direccion;
    private Integer semestre;
    private String numeroCuenta;
    private String numeroInscripcion;
    private RegistroAcadem historial;
    private Double promedio;

    
    /**
     * Constructor con parametros
     * @param nombre Nombre del Alumno
     * @param apelldioP Apellido Paterno del alumno
     * @param apellidoM Apellido Materno del alumno
     * @param edad Edad del alumno
     * @param direccion Direccion del alumno
     */
    public Alumno(Integer id,String nombre, String apellidoP, String apellidoM, Integer edad){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.setDireccion(id);
        // this.numeroCuenta = generarNumeroDeCuenta();
    }
    /** Constructor vacio */ 
    public Alumno(Integer id){
        this.setDireccion(id);
    };

    /* Getters and Setters */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return this.apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return this.apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Integer getEdad() {
        return this.edad;
    }

    /**
     * Determina la edad y le asocia un semestre que concuerde con su edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
        // this.semestre = calcularSemestre();
        // System.out.println("Edad: "+ this.edad+ " Semestre: " + this.semestre);
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccionManual(String direccion){
        this.direccion = direccion;
    }

    public void setDireccion(Integer id) {
        String nombreArchivo = "direcciones.txt"; // Ruta

        try(RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")){
            // archivo.seek(0);
            for(int i = 1; i < id; i++){
                archivo.readLine();
            }
            this.direccion = archivo.readLine();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getNumeroInscripcion(){
        return this.numeroInscripcion;
    }

    public void setNumeroInscripcion(String numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Integer getSemestre(){
        return this.semestre;
    }

    public void setSemestre() {
        this.semestre = this.calcularSemestre();
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(){
        this.numeroCuenta = generarNumeroDeCuenta();
    }

    public RegistroAcadem getHistorial(){
        return this.historial;
    }

    public Double getPromedio() {
        return promedio;
    }
    public void setPromedio() {
        this.promedio = this.historial.promedio;
    }

    /**
     * Metodo para calcular el semestre a partir de la edad.
     * Ademas se crea el registro de cada alumno a partir del semestre.
     * Genera numero de cuenta
     * Genera NoInscripcion
     * @return Retorna el semestre aleatorio
     */
    public Integer calcularSemestre(){
        Random random = new Random();
        Integer semestre = 1;
        if(this.edad == 18){
            semestre = random.nextInt(2)+1; // Genera numero [1,2]
        }else if(this.edad == 19){
            semestre = random.nextInt(4)+1; // Genera numero [1,4]
        }else if(this.edad == 20){
            semestre = random.nextInt(4)+3; // Genera numero [3,6]
        }else if(this.edad == 21){
            semestre = random.nextInt(4)+5; // Genera numero [5,8]
        }else{
            semestre = random.nextInt(4)+7; // Genera numero [6,10]
        }

        // Asinga el historial academico al alumno
        this.historial = new RegistroAcadem(semestre);
        // Asigna el numero de cuenta generado
        this.numeroCuenta = generarNumeroDeCuenta();
        // Asigna el promedio a la clase Alumno, ademas del historial
        setPromedio();
        GenNumInscripcion generadorIndicador = new GenNumInscripcion();
        this.numeroInscripcion = generadorIndicador.generarIndicador(this.historial.promedio);
        // System.out.println("Numero de inscripcion es: "+this.numeroInscripcion);
        return semestre;
    }

    /**
     * Funcion para generar un número de cuenta aleatorio
     * @return
     */ 
    private static String generarNumeroDeCuenta() {
        Random random = new Random();
        Integer numero = random.nextInt(1000000);
        String cadena = String.format("314%06d", numero);
        return cadena;
    }

    @Override
    public String toString() {
        String cadena = "------------------------------\n";
        cadena += this.nombre + " " + this.apellidoP + " " +  this.apellidoM;
        cadena += "\n------------------------------\n";
        cadena += "No. Cuenta: " + this.numeroCuenta + "\tEdad: " + this.edad;
        cadena += "\n------------------------------\n";
        cadena += "No. Semestre: " + this.semestre + "\tNo. Inscripcion: " + this.numeroInscripcion;
        cadena += "\n------------------------------\n";
        cadena += "Direccion: " + this.direccion;
        cadena += "\n------------------------------\n";
        cadena += this.historial;

        return cadena;
    }
}

