import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class jtree extends JFrame {

    jtree() {

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        DefaultMutableTreeNode root =
                new DefaultMutableTreeNode("Computer");

        DefaultMutableTreeNode documents =
                new DefaultMutableTreeNode("Documents");

        DefaultMutableTreeNode downloads =
                new DefaultMutableTreeNode("Downloads");

        DefaultMutableTreeNode pictures =
                new DefaultMutableTreeNode("Pictures");

        DefaultMutableTreeNode prasanna =
                new DefaultMutableTreeNode("Prasanna");
        root.add(documents);
        root.add(downloads);
        root.add(pictures);
        pictures.add(prasanna);

        JTree tree = new JTree(root);

        tree.setBounds(50, 50, 200, 300);

        add(tree);

        setVisible(true);
    }

    public static void main(String[] args) {
        new jtree();
    }
}