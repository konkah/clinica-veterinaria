package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import controller.Controller;
import model.Animal;
import model.Cliente;

import java.util.List;

/**
 *
 * @author vilela
 */
public class ClinicaVeterinaria{
    public void listaClientes(){
        List<Cliente> clientes = Controller.getAllClientes();
        for (Object cliente : clientes){
            System.out.println(cliente);
        }
    }

    public void listaAnimais(){
        List<Animal> animais = Controller.getAllAnimais();
        for (Object animal : animais){
            System.out.println(animal);
        }
    }

    public void menuPrincipal(){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("0- Encerrar");
            System.out.println("1- Insere Cliente");
            System.out.println("2- Lista Clientes");
            System.out.println("3- Deletar id 3");
            System.out.println("4- Insere Animal");
            System.out.println("5- Lista Animais");
            System.out.println("6- Deletar id 1");
            int opcao = in.nextInt();
            switch (opcao){
                case 1:
                    //Controller.addCliente("Plinio Vilela", "endereco", "plinio@vilela.com", "(19)98787-9988", "15675-900");
                    //Controller.addCliente("Ulisses Dias", "endereco", "ulisses@dias.com", "(19)98787-9988", "15675-900");
                    Controller.addCliente("Daiana Oliveira", "endereco", "daiana@oliveira.com", "(19)98787-9988", "15675-900");
                    break;
                case 2:
                    listaClientes();
                    break;
                case 3:
                    Controller.deleteCliente(Controller.getClienteById(3));
                    break;
                case 4:
                    Controller.addCliente("Adailton", "endereco", "email", "telefone", "cep");
                    Cliente cliente = Controller.getClienteById(1);
                    Controller.addAnimal("Hannimal", 2020, "M", cliente);
                    break;
                case 5:
                    listaAnimais();
                    break;
                case 6:
                    Controller.deleteAnimal(Controller.getAnimalById(1));
                    break;
                case 0:
                    in.close();
                    return;
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ClinicaVeterinaria().menuPrincipal();
    }
    
}
