/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.project.dao;
import com.sun.jdi.connect.spi.Connection;
import gym.project.database.MysqlConnection;
import gym.project.model.LoginRequest;
import gym.project.model.UserData;
import java.sql.*;


/**
 *
 * @author ASUS
 */

    
public class UserDao {
    MysqlConnection mysql =new MysqlConnection();
    public boolean register(UserData user){{
        String query="INSERT INTO users(fname,fPassword,fConfirmpassword)VALUES(?,?,?)";
        Connectionconn = mysql.openConnection();
       try{
           PreparedStatement stmnt= conn.prepareStatement(query);
           stmnt.setString(1,user.getName()); 
           stmnt.setString(2,user.getPassword());
           stmnt.setString(3,user.getConfirmpassword());
           int result= stmnt.executeUpdate();
       } catch(Exception e){
           return false;
           
       } finally{
           mysql.closeConnection(conn);
       }
    }
   
   
  public UserData Login(login(LoginRequest){
      String  Query="SELECT" * FROM users WHERE Password=? and Confirmpassword=?;
       Connection conn = mysql.openConnection();
       try{
          Connection Conn = null;
           
      //    step3:start prepared statement
       
        PreparedStatement stmnt = Conn.PreparedStatement(Query);
        
        //   set 4:clean query if needed
        stmnt.setString (1,LoginRequest.getPassword());
        stmnt.setString(2,LoginRequest.getConfirmPassword());
       //  step 5:execute query or update 
       //  always use executeQuery for select query
       //  it returns rows so,use ResultSet
       ResultSet result = stmnt.executeQuery();
      //   step6:Check returned data from query
            if (result.next()){
           // the string inside getstring should match the name of column in database

           String name = result.getString("fname");
           String Password = result.getString("Password");
           String ConfirmPassword = result.getString("ConfirmPassword");
           UserData user = NewUserdata (name,Password,ConfirmPassword);
           return user;
         }else{
            return null;
            }
       }catch (SQLException e){
           return null;
           
       } finally{
          Connection Conn = null;
           mysql.closeConnection(Conn );
       }  
  }

   
}
          public boolean checkEmail(String email){
    String query = "SELECT * FROM users WHERE email=?";
    Connection conn = mysql.openConnection();
    try{
        PreparedStatement stmnt= conn.prepareStatement(query);
        stmnt.setString(1,email);
 ResultSet result= stmnt.executeQuery();
if (result.next()){
  return true;
}else{
   return false;
}

}catch (Exception e){
  return false;

}finally{
mysql.closeconnection(conn);

}
}
public boolean resetPassword(RestPasswordRequest reset){
 String query="UPDATE user SET fPassword=?" Where email=?;
Connection conn = mysql.openConnection();
try{
} 
 preparedStatement stmnt=conn.prepareStatement(query);
stmnt.setString(1,reset.getPassword());
stmnt.setString(2,reset.getEmaiul());
int rresult = stmnt.executeUpdate();
     int result;
return result>0;
}catch(Exception e){
return false;
}finally{
   mysql.closeConnection(conn);
 }
  }
  
    

