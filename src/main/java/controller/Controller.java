package controller;

import java.util.List;

import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;

public class Controller {
    
    public static void addCliente(String nome, String endereco,  String telefone, String cep){
        ClienteDAO.getInstance().addCliente(nome, endereco, telefone, cep);
    }
    
      public static void addAnimal(String nome, int anoNasc, String sexo, Cliente cliente){
        AnimalDAO.getInstance().addAnimal(nome, anoNasc, sexo, cliente);
    }
    
    
    
    public List getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
    
    public static void getClienteById(int id){
         ClienteDAO.getInstance().getClienteById(id);
    }
    
    public static void deleteCliente(Cliente cliente){
        ClienteDAO.getInstance().deleteCliente(cliente);
    }

	public static Animal getAnimalById(int idAnimal) {
		return AnimalDAO.getInstance().getAnimalById(idAnimal);
	}
}
