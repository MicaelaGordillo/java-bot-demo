package bo.edu.ucb.est;

public class Persona {

    //Declaración de los atributos de la clase Persona.
    private int id;
    private int numeroDeMensaje;

    //Constructor de la clase Persona.
    public Persona (int id, int numeroDeMensaje) {
        this.id = id;
        this.numeroDeMensaje = numeroDeMensaje;
    }

    //Getters y setters de la clase Persona.
    public int getId() {
        return id;
    }

    public int getNumeroDeMensaje() {
        return numeroDeMensaje;
    }
    public void setNumeroDeMensaje(int numeroDeMensaje1) {
        this.numeroDeMensaje = numeroDeMensaje1;
    }

}
