package Models;

public class Especialista extends Medico{
    private String espec;

    public Especialista() {
    }

    public Especialista(String id, String nombre, String apellido, String sueldo, String codigo, String espec) {
        super(id, nombre, apellido, sueldo, codigo);
        this.espec = espec;
    }

    public String getEspec() {
        return espec;
    }

    public void setEspec(String espec) {
        this.espec = espec;
    }

    @Override
    public String toString() {
        return super.toString()+" "+"Especialista{" +
                "espec='" + espec + '\'' +
                '}';
    }
}
