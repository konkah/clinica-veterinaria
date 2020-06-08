package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Tratamento {
    private Date dataInicial;
    private Date dataFinal;
    private List<Consulta> listaDeConsultas;

    public Tratamento(Date dataInicial) {
        this.dataInicial = dataInicial;
        listaDeConsultas = new ArrayList<Consulta>();
    }
    
    public void addConsulta(Consulta consulta){
        listaDeConsultas.add(consulta);
    }
    
    public List<Consulta> getConsultas(){
        return listaDeConsultas;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    
}
