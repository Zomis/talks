package net.zomis.javatips.classes;

import javax.swing.*;

public class OldClassicJFrame extends JFrame {

    public OldClassicJFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new OldClassicJFrame();
    }

}
