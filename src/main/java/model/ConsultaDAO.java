package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Logger;




public class ConsultaDAO extends DAO{
 private static ConsultaDAO instance;

 private int id;

 private ConsultaDAO(){
     DAO.getConnection();
 }
 
 //Singleton
 public static ConsultaDAO getInstance(){
 if (instance == null) {
 instance = new ConsultaDAO();
 }
 return instance;
 }
 
 
// Partial CRUD
 //Create
 public int addConsulta(String data, String historico,String IdCliente,String idAnimal  ) throws SQLException{
Connection conn =null;
PreparedStatement st=null;
try{
    conn=DAO.getConnection();
    int newId=lastId("consulta","id")+1;
    
    st=conn.prepareStatement("insert Into consulta (id, dataConsulta,historico,IdCliente,IdAnimal) VALUES ( ?,?,?,?,?) ");
    st.setInt(1, newId);
    st.setString(2,data);
    st.setString(3,historico);
    st.setString(4,IdCliente);
    st.setString(5,idAnimal);
    
    executeUpdate(st);
    
    return newId;
    
}catch(SQLException e){
    Logger.getLogger(historico);
    
}
 return -1;
 
 }

  private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            consulta = new Consulta(rs.getInt("id"), rs.getString("data"), rs.getString("historico"), rs.getString("IdCliente"), rs.getString("IdAnimal"),rs.getString("exames"),rs.getString("CRVM"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

 //RetrieveAll
 public List getAllConsultas() throws SQLException{
     Connection conn = null;
     Statement st=null;
     
     
    List<Consulta> consulta = new ArrayList<>();
    try{
        conn=DAO.getConnection();
        st=conn.createStatement();
        ResultSet rs=getResultSet("Select * from consulta");
        while(rs.next()){
            consulta.add(buildObject(rs));
        }
        System.out.println("");
    }catch(SQLException e){
        e.printStackTrace();
    }
return consulta;
 }
 
 //RetrieveByID
 public Consulta getConsultaById(int id){
     Consulta consulta = null;
     ResultSet rs=getResultSet("select * from consulta where id ="+id);
     try{
         if(rs.next()){
             consulta=buildObject(rs);  
         }
         rs.close();
     }catch(SQLException e){
         e.printStackTrace();
     } 
     return consulta;
 }
 //Update
 //Delete
 public void deleteConsulta(Consulta consulta){

 }
}

