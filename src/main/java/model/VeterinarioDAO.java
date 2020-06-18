package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import model.DAO;
/**
 *
 * @author Plinio Vilela
 */
public class VeterinarioDAO extends DAO {
    private static VeterinarioDAO instance;
    private List<Veterinario> veterinarios;
    private int id;
    
    private VeterinarioDAO(){
        veterinarios = new ArrayList();
        id = 0;
    }
    
    // Singleton
    public static VeterinarioDAO getInstance(){
       if (instance == null) {
            instance = new VeterinarioDAO();
        }
        return instance;
    }
    private Veterinario buildObject(ResultSet rs) {
        Veterinario veterinario = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            veterinario = new Veterinario(rs.getInt("id"), rs.getString("nome"), rs.getString("CRM"),rs.getString("telefone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinario;
    }
    
// Partial CRUD    
    // Create
    public int addVeterinario(String nome, String cep, String telefone, String CRM){
        	Connection conn = null;
    
        		PreparedStatement st = null;
        		try {        			
        			conn = DAO.getConnection();
                         int newId = lastId("veterinario", "id") + 1;
                          st=conn.prepareStatement("INSERT INTO veterinario (id,nome,telefone,CRM) VALUES (?,?,?,?)");
        			 st.setInt(1, newId);
        			 st.setString(2, nome);
        			 st.setString(3, cep);
  
        			 st.setString(4, telefone);
                                 st.setString(5, CRM);
        	            executeUpdate(st);
                            return newId;
                        }catch(Exception e){
                            
                        }
        return -1;
    }

    // RetrieveAll
    public List getAllVeterinarios() {  
        Connection conn = null;
        Statement st=null;
        List<Veterinario> veterinarios = new ArrayList();
        
        try{
            conn=DAO.getConnection();
            st=conn.createStatement();
            ResultSet rs=getResultSet("Select * from veterinario");
            while(rs.next()){
                veterinarios.add(buildObject(rs));
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return veterinarios;
    }
    
    public void update(Veterinario veterinario) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE veterinario SET nome=?,  CRM=?, telefone=? WHERE id=?");
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getEndereco());
            stmt.setString(4, veterinario.getTelefone());
          
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    // Retrieve by ID
    public Veterinario getVeterinarioById(int id){
        for(Veterinario veterinario : veterinarios){
            if(veterinario.getId()==id){
                return veterinario;
            }
        }
        return null;
    }
    
    // Updade
    
    // Delete   
    public void deleteVeterinario(Veterinario veterinario){
        veterinarios.remove(veterinario);
    }

  
    
}
