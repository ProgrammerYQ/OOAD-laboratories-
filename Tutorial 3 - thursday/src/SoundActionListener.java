// Import ActionListener interface (for button clicks)
import java.awt.Toolkit;
import java.awt.event.*; // Import Toolkit (system-level tools, including sound)

// This class implements ActionListener interface
// When user clicks Sound button, this code runs
// ActionListener is a contract: "I will write actionPerformed(ActionEvent e)"
public class SoundActionListener implements ActionListener {
    
    // This method runs automatically when Sound button is clicked
    // ActionEvent e = info about the click (button source, timestamp, etc.)
    public void actionPerformed(ActionEvent e) {
        
        // Get the system's default toolkit (access to OS-level features)
        // Toolkit.getDefaultToolkit() = get system resources
        // .beep() = play the default system beep sound
        // This is the simplest way to play a sound in Java
        Toolkit.getDefaultToolkit().beep();
    }
}