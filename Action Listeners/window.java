import javax.swing.*;
import java.awt.event.*;

public class window extends JFrame implements WindowListener {

    window() {

        setSize(500, 500);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(this);

        setVisible(true);
    }

    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened");
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");

        int result = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?"
        );

        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("Window Minimized");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Restored");
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");
    }

    public static void main(String[] args) {
        new window();
    }
}