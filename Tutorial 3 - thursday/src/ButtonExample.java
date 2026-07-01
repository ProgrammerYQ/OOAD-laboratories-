// Import GUI components (buttons, frames, panels)
import javax.swing.*;

// Create a class that IS-A JFrame (a window container)
// extends = inherit all window powers from JFrame
public class ButtonExample extends JFrame {

    // Constructor: runs when you do "new ButtonExample()"
    public ButtonExample() {
        // Call parent JFrame constructor with window title "Button Example"
        // super() = pass control to parent class (JFrame)
        super("Button Example");
        
        // Create an invisible container (JPanel) to hold buttons
        // JPanel = Tupperware box for organizing components
        JPanel p = new JPanel();
        
        // Add the panel to the window (JFrame)
        // add() is inherited from JFrame
        add(p);
        
        // Set window size: 250 pixels wide, 80 pixels tall
        // Without this, window would be tiny or default size
        setSize(250, 80);
        
        // Create first button with label "Picture"
        JButton pb = new JButton("Picture");
        
        // Create second button with label "Sound"
        JButton sb = new JButton("Sound");
        
        // Create third button with label "File"
        JButton fb = new JButton("File");
        
        // Add Picture button to the panel (so it appears on screen)
        p.add(pb);
        
        // Add Sound button to the panel
        p.add(sb);
        
        // Add File button to the panel
        p.add(fb);
        
        // Wire File button to FileActionListener
        // When user clicks fb, FileActionListener.actionPerformed() runs automatically
        fb.addActionListener(new FileActionListener());
        
        // Wire Picture button to PictureActionListener
        // When user clicks pb, PictureActionListener.actionPerformed() runs automatically
        pb.addActionListener(new PictureActionListener());
        
        // Wire Sound button to SoundActionListener
        // When user clicks sb, SoundActionListener.actionPerformed() runs automatically
        sb.addActionListener(new SoundActionListener());
        
        // Display the window on screen
        // Without this, all components exist but are invisible
        setVisible(true);
        
        // When user clicks the red X button, close the entire program (EXIT_ON_CLOSE)
        // Without this: window closes but program still runs in background (wastes memory)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    // This is the entry point (starting point) for the entire program
    // Java looks for main() first and runs whatever is inside
    public static void main(String[] args) {
        // Create a new ButtonExample window (this triggers the constructor above)
        new ButtonExample();
    }
}