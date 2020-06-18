/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.AnimalDAO;
import model.Cliente;
import model.Animal;
import view.GenericTableModel;

/**
 *
 * @author karlos
 */
public class AnimalTableModel extends GenericTableModel {

    public AnimalTableModel(ArrayList dados) {
        super(dados, new String[]{"Nome","Ano de Nascimento", "Sexo", "Cliente"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                 return String.class;
            case 1:
                return Integer.class;
            case 2:
                 return String.class;
            case 3:
                return Cliente.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getAnoNasc();
            case 2:
                return animal.getSexo();
            case 3:
                return animal.getCliente();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                animal.setNome((String)aValue);
                break;
            case 1:
                animal.setAnoNasc((Integer)aValue);
                break;
            case 2:
                animal.setSexo((String)aValue);
                break;
            case 3:
                animal.setCliente((Cliente)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        AnimalDAO.getInstance().update(animal);
    }      
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
