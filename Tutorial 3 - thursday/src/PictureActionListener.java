//Import ActionListener interface (for button clicks)
import java.awt.event.*;
import java.io.IOException;// Import Swing components (JDialog, JLabel)
import javax.imageio.ImageIO;// Import ImageIO (reads image files from disk)
import javax.swing.*;// Import IOException (error handling for file problems)


// This class implements ActionListener (it has actionPerformed method)
// When user clicks Picture button, this code runs
public class PictureActionListener implements ActionListener {

    // This method runs automatically when Picture button is clicked
    // ActionEvent e = info about the click (not used here, but required by interface)
    public void actionPerformed(ActionEvent e) {
        
        // Create a popup dialog window (smaller than full JFrame)
        // JDialog = temporary window, not the main app window
        JDialog dialog = new JDialog();
        
        // When user closes this popup, destroy it completely (free up memory)
        // DISPOSE_ON_CLOSE = throw it away when closed (good practice)
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        // TRY this code block. If something goes wrong, CATCH the error and handle it
        // Why? Reading files can fail (file missing, corrupted, wrong format)
        // Without try-catch, program would crash
        try {
            
            // Load the image file and display it:
            // getClass() = "this class"
            // .getResourceAsStream("mmulogo.jpg") = find the image file named "mmulogo.jpg"
            // ImageIO.read(...) = read the image file from disk into memory
            // new ImageIcon(...) = wrap the image so Swing can display it
            // new JLabel(...) = create a label (JLabel can hold text OR images)
            // dialog.add(...) = put the label (with image) inside the dialog window
            dialog.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("mmulogo.jpg")))));
            
        // CATCH: if something goes wrong (file not found, corrupted, etc.)
        // IOException = file-related error
        // ex = the error object (contains details about what went wrong)
        } catch (IOException ex) {
            
            // Instead of crashing, show an error message
            // Create a label that says "Couldn't load the image" and add it to dialog
            // This way, the window still appears, just with error text instead of image
            dialog.add(new JLabel("Couldn't load the image"));
        }
        
        // Shrink the dialog window to fit the image size
        // pack() = auto-size the window (no wasted empty space)
        dialog.pack();
        
        // Let the operating system (Windows/Mac/Linux) decide where to place the window
        // setLocationByPlatform(true) = use OS default placement (usually top-left or center)
        // This is better than hardcoding a position
        dialog.setLocationByPlatform(true);
        
        // Show the dialog window on screen
        // Without this, everything exists but is invisible
        dialog.setVisible(true);
    }
}