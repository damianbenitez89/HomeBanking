package Models;

public class Enfermera extends Funcionario {

    private String turno;

    public Enfermera() {}

    public Enfermera(String id, String nombre, String apellido, String sueldo, String turno) {
        super(id, nombre, apellido, sueldo);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }


    @Override
    public String toString() {
        return super.toString()+" "+"Enfermera{" +
                "turno='" + turno + '\'' +
                '}';
    }
}
