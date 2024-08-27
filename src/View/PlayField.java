package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import Controller.Controller;

/**
 *This class creates the buttons for the playing field
 * @author Daniel & Sarah
 */
public class PlayField extends JPanel {
    /**
     * Object of controller, used to call the dig method in the controller
     */
    private Controller controller;

    /**
     * Constructor for the PlayField class, creates all the buttons and places them.
     * @param map
     * @param controller
     * @author Daniel & Sarah
     */
    public PlayField(String[][] map, Controller controller) { //String[][] map, Controller controller) {
        this.controller = controller;
        setBackground(Color.BLUE);
        setLayout(new GridLayout(11, 11));
        setPreferredSize(new Dimension(500, 500));

        for (int i = 1; i <= 10; i++) {
            JLabel rowLabel = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            add(rowLabel);
            for (int j = 0; j < 10; j++) {
                //JButton button = new JButton(map[i-1][j]); //this shows traps and treasures on the field
                JButton button = new JButton(""); //this sets the initial value to be empty, traps and treasures visible when dug
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



    /**
     * This method gets the index of a pressed button on the playing field
     * @param component
     * @return Int cointaining the index of a pressed button.
     */
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

    /**
     * This method updates the buttons on the playing field, properly showing what was in a dug area.
     * @param row
     * @param col
     * @param
     * @author Sarah.
     */
    public void updateButton(int row, int col, String cellState) {
        int index = (row)* 11 + (col + 1);
        JButton button = (JButton) getComponent(index);
        updateButtonAppearance(button, cellState);

        /*
        if (Objects.equals(type, "T")) {
            button.setBackground(Color.GREEN);
        }
        else if (Objects.equals(type, "D")) {
            button.setBackground(Color.RED);
        }
        else {
            button.setBackground(Color.DARK_GRAY);
        }

         */
    }

    private void updateButtonAppearance(JButton button, String cellState) {
        switch (cellState) {
            case "T":
                button.setBackground(Color.GREEN);
                break;
            case "D":
                button.setBackground(Color.RED);
                break;
            case "DUG" :
                button.setBackground(Color.DARK_GRAY);
                break;
            default:
                button.setBackground(Color.white);
                break;
        }
    }
}

