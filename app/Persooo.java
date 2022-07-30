package app;

import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID = 00000000001L;
    public String nombre;
    public String apellido;
    public transient int edad;

// el modificador transient le dice al JVM que dicho atributo debe ser exento de la serializacion, por lo tanto no lo guardara.
//    al igual que los static ya que pertenecen a la clase y no al objeto.

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
