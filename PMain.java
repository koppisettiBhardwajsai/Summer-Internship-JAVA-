import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PMain extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6;

    PMain() {
        setSize(650, 300);
        setTitle("Product Management System");
        setResizable(false);
        setLayout(null);

        JLabel j1 = new JLabel("Product Management System");
        j1.setForeground(Color.BLUE);
        j1.setBounds(130, 10, 500, 80);
        j1.setFont(new Font("Arial", Font.BOLD, 24));

        Color code = new Color(2, 48, 32);
        getContentPane().setBackground(code);
        Color sadist_blue = new Color(196, 180, 84);

        b1 = new JButton("Add a Product");
        b1.setBounds(50, 100, 160, 30);
        b1.setFont(new Font("Pacifico", Font.BOLD, 15));
        b1.setForeground(Color.BLACK);
        b1.setBackground(sadist_blue);
        b1.addActionListener(this);

        b2 = new JButton("Update a Product");
        b2.setBounds(230, 100, 180, 30);
        b2.setFont(new Font("Pacifico", Font.BOLD, 15));
        b2.setForeground(Color.BLACK);
        b2.setBackground(sadist_blue);
        b2.addActionListener(this);

        b3 = new JButton("Delete a Product");
        b3.setBounds(430, 100, 160, 30);
        b3.setFont(new Font("Pacifico", Font.BOLD, 15));
        b3.setForeground(Color.BLACK);
        b3.setBackground(sadist_blue);
        b3.addActionListener(this);

        b4 = new JButton("Search a Product");
        b4.setBounds(110, 160, 180, 30);
        b4.setFont(new Font("Pacifico", Font.BOLD, 15));
        b4.setForeground(Color.BLACK);
        b4.setBackground(sadist_blue);
        b4.addActionListener(this);

        b5 = new JButton("Exit");
        b5.setBounds(270, 220, 100, 30);
        b5.setFont(new Font("Pacifico", Font.BOLD, 15));
        b5.setForeground(Color.BLACK);
        b5.setBackground(sadist_blue);
        b5.addActionListener(this);

        b6 = new JButton("View Data");
        b6.setBounds(340, 160, 200, 30);
        b6.setFont(new Font("Pacifico", Font.BOLD, 15));
        b6.setForeground(Color.BLACK);
        b6.setBackground(sadist_blue);
        b6.addActionListener(this);

        add(j1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)
            new PAdd();
        else if (e.getSource() == b2)
            new PUpdate();
        else if (e.getSource() == b3)
            new PDelete();
        else if (e.getSource() == b4)
            new PSearch();
        else if (e.getSource() == b5) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getSource() == b6)
            new PView();
    }
}
