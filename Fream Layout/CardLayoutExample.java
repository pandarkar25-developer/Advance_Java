import javax.swing.*;
import java.awt.*;

public class CardLayoutExample extends JFrame {

    CardLayout cardLayout;
    JPanel cards;

    public CardLayoutExample() {

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel card1 = new JPanel();
        card1.add(new JLabel("This is Card 1"));

        JPanel card2 = new JPanel();
        card2.add(new JLabel("This is Card 2"));

        JPanel card3 = new JPanel();
        card3.add(new JLabel("This is Card 3"));

        cards.add(card1, "card1");
        cards.add(card2, "card2");
        cards.add(card3, "card3");

        JButton next = new JButton("Next");

        next.addActionListener(e -> {
            cardLayout.next(cards);
        });

        add(cards, BorderLayout.CENTER);
        add(next, BorderLayout.SOUTH);

        setTitle("CardLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CardLayoutExample();
    }
}