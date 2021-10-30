package Models;

public class Medico extends Funcionario{

    private String codigo;

    public Medico() {}

    public Medico(String id, String nombre, String apellido, String sueldo, String codigo) {
        super(id, nombre, apellido, sueldo);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() +" "+"Medico{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}
