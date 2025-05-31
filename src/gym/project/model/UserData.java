/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.project.model;

/**
 *
 * @author ASUS
 */
public class UserData {
    //privete attributes
    //public methods
    private String name;
    private String password;
    private String confirmPassword;
    private String ConfirmPassword;
    public UserData (String Username,String password){
        this.name=Username;
        
        this.password=password;
    }
   //setters
    public void setName(String name){
        this.name=name;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public void setconfirmpassword(String ConfirmPassword){
        this.ConfirmPassword=ConfirmPassword;
    }
   //getters
    public String getName(){
       return this.name;
    }
    
    public String getpassword(){
        return this.password;
    }
    public String getconfirmPassword(){
        return this.confirmPassword;
    }

    public String getConfirmpassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getname() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
