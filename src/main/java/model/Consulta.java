package model;

import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Consulta {
    private int id;
    private String data,IdCliente, IdAnimal,exames,CRMV;
    private String historico;
    private Veterinario veterinario;
    private List listaDeExames;

    public Consulta(int id, String data, String historico,String IdCliente,String idAnimal, String exames, String CRMV) {
        this.id = id;
        this.data = data;
        this.historico = historico;
        this.IdCliente = IdCliente;
        this.IdAnimal=IdAnimal;
        this.exames=exames;
        this.CRMV=CRMV;
       
    }

    public int getId(){
        return id;
    }
    
    public int setId(){
        return id;
    }

  
    public String getListaDeExames() {
        return exames;
    }
    
    public void setListaDeExames(){
        this.listaDeExames = listaDeExames;
    }
    
    
    public String getData() {
        return data;
        
    }
    
    public void setData(String data){
        this.data=data;
    }

    public String getHistorico() {
        return historico;
    }
    
    public void setHistorico(String historico){
        this.historico=historico;
    }

    public String getCRVM() {
        return CRMV;
    }
    
    public void setCRVM(String CRVM){
        this.CRMV=CRMV;
    }
    
    public String getIdAnimal(){
        return IdAnimal;
    }
    public void setIdAnimal(String IdAnimal){
        this.IdAnimal=IdAnimal;
    }
    public String GetIdCliente(){
        return IdCliente;
    }
    
    public void setIdCliente(String IdCliente){
        this.IdCliente=IdCliente;
    }



    
    
}
