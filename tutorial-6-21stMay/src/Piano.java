
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.sound.midi.*;//#12

                   //#1                       //#16 
public class Piano implements ChangeListener, KeyListener {
 
    int keypress; //#8 
    boolean isPlaying = false; //#9 
    Synthesizer midiSynth;//#10
    MidiChannel[] mChannels; //#11
    
    Piano() {
        JFrame frame = new JFrame("Pea-Air-Know");
        JButton[] w = new JButton[7];
        JButton[] b = new JButton[6]; //there's 6 eventhough there's five because one of them is invisible and used as a space
        JLayeredPane panel = new JLayeredPane();//this container allows u to control which color comes first
        frame.add(panel);
        
        frame.addKeyListener(this); //#18
        frame.setFocusable(true); //#19

        for (int i = 0; i < 7; i++) {
            w[i] = new JButton();
            w[i].setBackground(Color.WHITE);
            w[i].setLocation(i * 70, 0);
            w[i].setSize(70, 300);
            
            w[i].setName("w"+Integer.toString(i));//#3
            
            w[i].addChangeListener(this);//#14
            
            panel.add(w[i], 0, -1);
        }

        for (int i = 0; i < 6; i++) {
            if (i == 2) {
                continue;
            }
            b[i] = new JButton();
            b[i].setBackground(Color.BLACK);
            b[i].setLocation(35 + i * 70, 0);//offset of 35, we do this so that there's a gap between keyboards
            b[i].setSize(70, 150);
            
            b[i].setName("b"+Integer.toString(i));//#4
            
            b[i].addChangeListener(this);//#15
            
            panel.add(b[i], 1, -1);
        }
        
        try{
            midiSynth = MidiSystem.getSynthesizer(); 
            midiSynth.open(); 
            mChannels = midiSynth.getChannels(); 
        }catch (MidiUnavailableException e){
            
        }//#13 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 320);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public void stateChanged(ChangeEvent e){
        JButton temp = (JButton)e.getSource(); //#5
        String btnName = temp.getName(); //#6
        
        //from here #7 
        if (temp.getModel().isPressed()) {
            System.out.println(btnName + " pressed");
            isPlaying = true;
            switch (btnName) {
                case "w0":
                    keypress = 60;
                    mChannels[0].noteOn(60, 127);
                    break;
                case "b0":
                    keypress = 61;
                    mChannels[0].noteOn(61, 127);
                    break;
                case "w1":
                    keypress = 62;
                    mChannels[0].noteOn(62, 127);
                    break;
                case "b1":
                    keypress = 63;
                    mChannels[0].noteOn(63, 127);
                    break;
                case "w2":
                    keypress = 64;
                    mChannels[0].noteOn(64, 127);
                    break;
                case "w3":
                    keypress = 65;
                    mChannels[0].noteOn(65, 127);
                    break;
                case "b3":
                    keypress = 66;
                    mChannels[0].noteOn(66, 127);
                    break;
                case "w4":
                    keypress = 67;
                    mChannels[0].noteOn(67, 127);
                    break;
                case "b4":
                    keypress = 68;
                    mChannels[0].noteOn(68, 127);
                    break;
                case "w5":
                    keypress = 69;
                    mChannels[0].noteOn(69, 127);
                    break;
                case "b5":
                    keypress = 70;
                    mChannels[0].noteOn(70, 127);
                    break;
                case "w6":
                    keypress = 71;
                    mChannels[0].noteOn(71, 127);
                    break;
            }
        } else {
            if (isPlaying) {
                mChannels[0].noteOff(keypress);
            }
            isPlaying = false;
        }//#7 
        
    }//this helps make piano in the public class not red #2
    
    //#17 from here
    public void keyTyped(KeyEvent e) {
        
    }
    public void keyPressed(KeyEvent e) {

        char c = e.getKeyChar();

        System.out.println(c + " pressed");

        if (!isPlaying) {

            isPlaying = true;

            switch (c) {

                case 'z':

                    keypress = 60;

                    mChannels[0].noteOn(60, 127);

                    break;

                case 's':

                    keypress = 61;

                    mChannels[0].noteOn(61, 127);

                    break;

                case 'x':

                    keypress = 62;

                    mChannels[0].noteOn(62, 127);

                    break;

                case 'd':

                    keypress = 63;

                    mChannels[0].noteOn(63, 127);

                    break;

                case 'c':

                    keypress = 64;

                    mChannels[0].noteOn(64, 127);

                    break;

                case 'v':

                    keypress = 65;

                    mChannels[0].noteOn(65, 127);

                    break;

                case 'g':

                    keypress = 66;

                    mChannels[0].noteOn(66, 127);

                    break;

                case 'b':

                    keypress = 67;

                    mChannels[0].noteOn(67, 127);

                    break;

                case 'h':

                    keypress = 68;

                    mChannels[0].noteOn(68, 127);

                    break;

                case 'n':

                    keypress = 69;

                    mChannels[0].noteOn(69, 127);

                    break;

                case 'j':

                    keypress = 70;

                    mChannels[0].noteOn(70, 127);

                    break;

                case 'm':

                    keypress = 71;

                    mChannels[0].noteOn(71, 127);

                    break;

            }

        }

    }

    public void keyReleased(KeyEvent e) {

        mChannels[0].noteOff(keypress);

        isPlaying = false;

    }
    //till here #17

    public static void main(String[] args) {
        new Piano();
    }
}
