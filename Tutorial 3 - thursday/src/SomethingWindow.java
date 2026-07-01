// Import layout and graphics tools
import java.awt.*;
import javax.swing.*;// Import Swing components (JFrame, JPanel, JButton)

// extends = "this class extends JFrame" = "this class IS a JFrame"
public class SomethingWindow extends JFrame {
    
    // Constructor: runs when you do "new SomethingWindow()"
    public SomethingWindow() {
        
        // Call parent JFrame constructor with window title
        // super() = pass the title to the parent class (JFrame)
        super("This is my application");
        
        // Create a panel with FlowLayout as its layout manager
        // JPanel = invisible container for holding components
        // FlowLayout = layout manager that arranges components left-to-right (like text flow)
        // FlowLayout is the default, but we're being explicit here
        JPanel jp = new JPanel(new FlowLayout());
        
        // Create a button with label "Push me"
        JButton aButton = new JButton("Push me");
        
        // Add the button to the panel
        // jp.add() = put the button inside the JPanel container
        jp.add(aButton);
        
        // Add the panel to the window (JFrame)
        // add() is inherited from JFrame
        // This puts the panel (with the button inside) into the main window
        add(jp);
        
        // Set window size: 320 pixels wide, 150 pixels tall
        // Without this, window would be default size
        setSize(320, 150);
        
        // Display the window on screen
        // setVisible(true) = "show up, user can see you now"
        setVisible(true);
    }

    // Entry point: Java runs this first
    // main() is where the program starts
    public static void main(String[] args) {
        
        // Create a new SomethingWindow (triggers the constructor above)
        new SomethingWindow();
    }
}