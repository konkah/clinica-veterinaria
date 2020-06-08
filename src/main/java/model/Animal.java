package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Animal {
    private int id;
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setListaDeTratamentos(List<Tratamento> listaDeTratamentos) {
        this.listaDeTratamentos = listaDeTratamentos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    private int anoNasc;
    private String sexo;
    private List<Tratamento> listaDeTratamentos;
    private Cliente cliente;

    public Animal(int id, String nome, int anoNasc, String sexo, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.sexo = sexo;
        this.cliente = cliente;
        listaDeTratamentos = new ArrayList<Tratamento>();
    }
    
    public void addTratamento(Tratamento tratamento){
        listaDeTratamentos.add(tratamento);
    }
    
    public List<Tratamento> getTratamentos(){
        return listaDeTratamentos;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public String getSexo() {
        return sexo;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public String toString() {
        return nome;
    }
}
