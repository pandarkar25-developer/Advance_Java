import javax.swing.*;

public class menu extends JFrame {

    menu() {

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem exit = new JMenuItem("Exit");

        JMenu home =new JMenu("Home");

        JMenuItem saveAs = new JMenuItem("Save As");
        JMenuItem save = new JMenuItem("Save");

        home.add(save);
        home.add(saveAs);   

        file.add(newFile);
        file.add(open);
        file.add(exit);

        bar.add(home);
        bar.add(file);
        bar.add(edit);

        
        setJMenuBar(bar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new menu();
    }
}