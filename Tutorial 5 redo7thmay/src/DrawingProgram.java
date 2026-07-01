
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 
//# = lecturer's steps 

//to do 
//revise how #4 and #5 works
//our canvas will reset when switching tabs because no save

//DrawingProgram is a listener 
public class DrawingProgram extends JFrame implements ChangeListener{
//why DrawingProgram has an error? because of the extend JF is a container so DP is too 
  //implements is an interface aka a contract(meaning can be done but under a requiremnet) 
    //so we need to define the contracts and implement them
    //got rid of "Implements MouseMotionListener" *find out why 
    
//mousemotionlistener is declared in the library
    
    //got rid of this too*find out why 
    //private Point mousePnt=new Point(); //#3
    //we do this here so that the mouse can coordinate the x , y 
    //basically so that the mouse knows where its going
    
    private JSlider penSize = new JSlider(JSlider.HORIZONTAL,1,30,4); 
    
    public DrawingProgram() {
        super("Painter");
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT)); //component
        toolbar.add(new Label("Drag mouse to draw")); //component
        toolbar.add(penSize); 
        this.add(toolbar, BorderLayout.SOUTH); //component
        penSize.addChangeListener(this);
        
        //old components because its faulty(start the reset solution here)
        //JPanel jp = new JPanel(); //idk what this is #1
        //this.add(jp,BorderLayout.CENTER); // #2 
        //jp.addMouseMotionListener(this);//this adds this to the jp
        //with this it can LISTEN to all your dragging 
        //this is for the listerner*revise 
        //#7 
        
        MyPanel jp = new MyPanel(); 
        this.add(jp,BorderLayout.CENTER);
        //#11 from MyPanel.java
        
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void stateChanged(ChangeEvent e){
        JSlider source = (JSlider) e.getSource();  
        
        if(!source.getValueIsAdjusting()){
            MyPanel.pen = (int)source.getValue(); 
        }
    }
    public static void main(String[] a) {
        new DrawingProgram(); //creating the container
    }
}
