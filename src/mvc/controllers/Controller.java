package mvc.controllers;

import java.awt.event.ActionEvent;

//CONNECTS Model AND View

import java.awt.event.ActionListener;
import mvc.models.*;   //.* means import everything from it
import mvc.views.*;

public class Controller {
    private Model model;
    private View view;
    private ActionListener actionListener;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;                  
    }
    
    public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
              }
        };                
    }
}