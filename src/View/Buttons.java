package View;

import javax.swing.*;
import java.awt.*;

public class Buttons extends JPanel {
    public Buttons()
    {
        setLayout(new GridLayout(1,2));
        setPreferredSize((new Dimension(200,50)));

        JButton endTurnButton = new JButton("End Turn");
        JButton digButton = new JButton("Dig!");

        add(endTurnButton);
        add(digButton);
    }
}
