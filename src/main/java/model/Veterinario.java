package model;

/**
 *
 * @author Plinio Vilela
 */
public class Veterinario {
    private String nome;
    private String endereco;
    private String telefone;
private int id;

    public Veterinario(int id, String nome, String endereco, String telefone) {
    	this.id=id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
      public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
public int getId() {
	return id;
}
    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    
}
