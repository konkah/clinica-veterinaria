package controller;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Plinio Vilela
 */
public class Controller {
    
    public static void addCliente(String nome, String endereco, String email, String telefone, String cep){
        ClienteDAO.getInstance().addCliente(nome, endereco, email, telefone, cep);
    }
    
    public static List<Cliente> getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
    
    public static Cliente getClienteById(int id){
        return ClienteDAO.getInstance().getClienteById(id);
    }
    
    public static void deleteCliente(Cliente cliente){
        ClienteDAO.getInstance().deleteCliente(cliente);
    }
    
    public static void addAnimal(String nome, int anoNasc, String sexo, Cliente cliente){
        AnimalDAO.getInstance().addAnimal(nome, anoNasc, sexo, cliente);
    }
    
    public static List<Animal> getAllAnimais(){
        return AnimalDAO.getInstance().getAllAnimais();
    }
    
    public static Animal getAnimalById(int id){
        return AnimalDAO.getInstance().getAnimalById(id);
    }
    
    public static void deleteAnimal(Animal animal){
        AnimalDAO.getInstance().deleteAnimal(animal);
    }
}
