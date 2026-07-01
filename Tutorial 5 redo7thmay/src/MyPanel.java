import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class MyPanel extends JPanel implements MouseMotionListener, MouseListener{

     Point oldPoint=new Point(); 
    Point newPoint=new Point();
    Image image; 
    Graphics2D graphics2D; 
    public static Color penColor = new Color(0,0,0); 
    public static int pen =4;//this will allow two sides to talk to each other(see each other)
    MyPanel() {
        this.addMouseMotionListener(this); 
        this.addMouseListener(this); 
    }

    public void mouseClicked (MouseEvent e){
        if (e.getModifiers() == MouseEvent.BUTTON3_MASK){
            //these lines r becuase of old code with low security*i think 
                                            //button3 is right
            penColor = JColorChooser.showDialog(null, "Change pen color", penColor); 
        }
    }
    public void mousePressed (MouseEvent e){
        
    }
    public void mouseReleased (MouseEvent e){
        
    }
    public void mouseEntered (MouseEvent e){
        
    }
    public void mouseExited (MouseEvent e){
        
    }


    public void mouseDragged(MouseEvent me) {
        graphics2D.setStroke(new BasicStroke(pen));
        graphics2D.setColor(penColor);//this makes it so whatever color u made in mouseclicked is here too
        newPoint = me.getPoint();
        if (graphics2D != null) { 
            graphics2D.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
        }
        repaint();
        oldPoint = newPoint; 
    }

 

    public void mouseMoved(MouseEvent me) {
        oldPoint=me.getPoint(); 
    }

 

    protected void paintComponent(Graphics g) {

        if (image == null) {

            image = createImage(getSize().width, getSize().height);

 

            graphics2D = (Graphics2D) image.getGraphics();

 

        } else {

 

            g.drawImage(image, 0, 0, null);

 

        }

 

    }

 

 

}


