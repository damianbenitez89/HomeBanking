package Controlador;

import Models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class TFuncionario {
    List<Funcionario> lista = new ArrayList<>();

    public TFuncionario() { }

    public boolean ingresarFuncionario (Funcionario funcionario){

        lista.add(funcionario);
        return true;
    }

    public boolean modificarFuncionario (Funcionario funcionario, int pos){

        lista.set(pos,funcionario);
        return true;
    }

    public boolean eliminaFuncionario ( int pos){
        lista.remove(pos);
        return true;
    }

    public int buscanFuncionario(String id){
        int pos=-1;

        for(int i=0; i<lista.size();i++){
            if(lista.get(i).getId().equals("id")){
                pos=i;
            }
        }

        return pos;
    }

    public List<Funcionario> getLista() {
        return lista;
    }

    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }
}
