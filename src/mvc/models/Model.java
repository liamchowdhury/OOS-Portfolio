package mvc.models;

import java.awt.*;
import javax.swing.*;

//The content of the application!!
//Creates the dataset

public class Model {
    
    private int x;
    
    public Model(){
        x = 2;
    }
    
    public Model(int x){
        this.x = x;
    }
    
    public void incX(){
        x--;
    }
    
    public int getX(){
        return x;   
    }
}
