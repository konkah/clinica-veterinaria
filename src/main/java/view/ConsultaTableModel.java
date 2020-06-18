/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.Consulta;
import model.ConsultaDAO;

/**
 *
 * @author User PC
 */
public class ConsultaTableModel extends GenericTableModel {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karlos
 */

    public ConsultaTableModel(ArrayList dados) {
        super(dados, new String[]{"dataConsulta","Histórico", "IdCliente", "IdAnimal"});
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
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return consulta.getData();
            case 1:
                return consulta.getCRVM();
            case 2:
                return consulta.getHistorico();
            case 3:
                return consulta.getIdAnimal();
            case 4:
                return consulta.GetIdCliente();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                consulta.setCRVM((String)aValue);
                break;
            case 1:
                consulta.setData((String)aValue);
                break;
            case 2:
                consulta.setHistorico((String)aValue);
                break;
            case 3:
                consulta.setIdAnimal((String)aValue);
                break;
                 case 4:
                 consulta.setIdCliente((String)aValue);
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
      //  ConsultaDAO.getInstance().update(consulta);
    }      
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}


