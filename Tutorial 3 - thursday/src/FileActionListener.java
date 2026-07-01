// Import ActionListener interface (contract for button clicks)
import java.awt.event.*;
import javax.swing.JFileChooser; //import JFileChooser (file browser dialog) from Swing library

// This class promises to implement ActionListener interface
// implements = "I will write the required actionPerformed() method"
// Why? Because we're attaching this to a button, and buttons need ActionListener
public class FileActionListener implements ActionListener {

    // This method MUST exist because ActionListener requires it
    // It runs automatically when the File button is clicked
    // ActionEvent e = info about the button click (button source, time, etc.)
    public void actionPerformed(ActionEvent e) {
        
        // Create a file browser dialog (the "pick a file" window)
        // JFileChooser = built-in file picker for choosing files from your computer
        JFileChooser fc = new JFileChooser();
        
        // Show the file browser dialog
        // showOpenDialog(null) = display the "Open File" dialog on screen
        // null = no parent window (acceptable for simple programs)
        // int r = stores the result (what button user clicked: Open, Cancel, etc.)
        int r = fc.showOpenDialog(null);
        
        // NOTE: This code doesn't DO anything with the file yet
        // It just opens the browser and stores what the user clicked
        // To actually USE the file, you'd add more code here
    }
}