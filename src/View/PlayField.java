package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayField extends JPanel {
    public PlayField(String[][] map) {
        setBackground(Color.BLUE);
        setLayout(new GridLayout(11, 11));
        setPreferredSize(new Dimension(500, 500));

        for (int i = 1; i <= 10; i++) {
            JLabel rowLabel = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            add(rowLabel);
            for (int j = 0; j < 10; j++) {
                JButton button = new JButton(map[i-1][j]);
                button.setPreferredSize(new Dimension(50, 50));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();

                        int index = getComponentIndex(clickedButton);
                        int row = (index / 11) - 1;
                        int col = ((index - 1) % 11) - 1;
                        System.out.println("Button clicked at row " + (row + 1) + ", column " + (col + 1));
                    }
                });
                add(button);
            }
        }
        add(new JLabel());
        for (char col = 'A'; col <= 'J'; col++) {
            JLabel colLabel = new JLabel(String.valueOf(col), SwingConstants.CENTER);
            add(colLabel);
        }
    }
    private int getComponentIndex(Component component) {
        Container container = component.getParent();
        for (int i = 0; i < container.getComponentCount(); i++) {
            if (container.getComponent(i) == component) {
                return i;
            }
        }
        return -1;
    }
}