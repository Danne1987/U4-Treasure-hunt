package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;

public class PlayField extends JPanel {
    private Controller controller;

    public PlayField(String[][] map, Controller controller) {
        this.controller = controller;
        setBackground(Color.BLUE);
        setLayout(new GridLayout(11, 11));
        setPreferredSize(new Dimension(500, 500));

        for (int i = 1; i <= 10; i++) {
            JLabel rowLabel = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            add(rowLabel);
            for (int j = 0; j < 10; j++) {
                JButton button = new JButton(map[i-1][j]); //this shows traps and treasures on the field
                //JButton button = new JButton(""); //this sets the initial value to be empty, traps and treasures visible when dug
                button.setPreferredSize(new Dimension(50, 50));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();

                        int index = getComponentIndex(clickedButton);
                        int row = (index - 1) / 11;
                        int col = (index - 1) % 11;
                        System.out.println("Button clicked at row " + (row + 1) + ", column " + (col + 1));

                        controller.dig(row, col);
                        //TODO: research if needed here, or if it can be only logic in the controller calling to update boundary
                    }
                });
                add(button);
            }
        }
        add(new JLabel());
        for (int col = 1; col <= 10; col++) {
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


    //TODO: only if we want to indicate somehow that a square has been dug, and possibly what type?
    public void updateButton(int row, int col, String type) {
        int index = (row)* 11 + (col + 1);
        JButton button = (JButton) getComponent(index);

        if (type == "T") {
            button.setBackground(Color.GREEN);

        }
        else if (type == "D") {
            button.setBackground(Color.RED);
        }
        else {
            button.setBackground(Color.DARK_GRAY);
        }

        // button.setText("Clear!"); //does not show the whole text so better without
    }
}

