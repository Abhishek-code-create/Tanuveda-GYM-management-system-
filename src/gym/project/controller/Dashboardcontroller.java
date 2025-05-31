/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.project.controller;

import gym.project.model.UserData;
import gym.project.view.Dashboardview;

/**
 *
 * @author ASUS
 */
public class Dashboardcontroller {
     private Dashboardview view;
    private UserData user;
    public Dashboardcontroller(Dashboardview view,UserData user){
        this.view=view;
        this.user = user;
        String name = user.getName();
        this.view.getWelcomeLabel().setText("welcome "+name);
        
    }
    public void open(){
        view.setVisible(true);
        
    }
    public void close(){
        view.dispose();
    }
    
}
