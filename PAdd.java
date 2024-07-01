import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PAdd extends JFrame {
    JButton a1, a2;

    PAdd() {
        setSize(450, 360);
        setTitle("Product Add");
        setResizable(false);
        setLayout(null);

        Color code = new Color(2, 48, 32);
        getContentPane().setBackground(code);
        Color sadist_blue = new Color(196, 180, 84);

        JLabel j1 = new JLabel();
        j1.setBounds(15, 10, 200, 30);
        j1.setText("Enter ID of Product");
        j1.setFont(new Font("Pacifico", Font.BOLD, 15));
        j1.setForeground(Color.WHITE);

        JTextField t1 = new JTextField();
        t1.setBounds(220, 10, 110, 30);
        t1.setFont(new Font("Pacifico", Font.BOLD, 15));
        t1.setBackground(sadist_blue);

        JLabel j2 = new JLabel();
        j2.setBounds(15, 50, 150, 30);
        j2.setText("Enter Product Name");
        j2.setFont(new Font("Pacifico", Font.BOLD, 15));
        j2.setForeground(Color.WHITE);

        JTextField t2 = new JTextField();
        t2.setBounds(220, 50, 200, 30);
        t2.setFont(new Font("Pacifico", Font.BOLD, 15));
        t2.setBackground(sadist_blue);

        JLabel j3 = new JLabel();
        j3.setBounds(15, 90, 150, 30);
        j3.setText("Enter Product Price");
        j3.setFont(new Font("Pacifico", Font.BOLD, 15));
        j3.setForeground(Color.WHITE);

        JTextField t3 = new JTextField();
        t3.setBounds(220, 90, 200, 30);
        t3.setFont(new Font("Pacifico", Font.BOLD, 15));
        t3.setBackground(sadist_blue);

        JLabel j4 = new JLabel();
        j4.setBounds(15, 130, 170, 30);
        j4.setText("Enter Product Brand");
        j4.setFont(new Font("Pacifico", Font.BOLD, 15));
        j4.setForeground(Color.WHITE);

        JTextField t4 = new JTextField();
        t4.setBounds(220, 130, 200, 30);
        t4.setFont(new Font("Pacifico", Font.BOLD, 15));
        t4.setBackground(sadist_blue);

        JLabel j5 = new JLabel();
        j5.setBounds(15, 170, 180, 30);
        j5.setText("Enter Product Category");
        j5.setFont(new Font("Pacifico", Font.BOLD, 15));
        j5.setForeground(Color.WHITE);

        JTextField t5 = new JTextField();
        t5.setBounds(220, 170, 200, 30);
        t5.setFont(new Font("Pacifico", Font.BOLD, 15));
        t5.setBackground(sadist_blue);

        JLabel j6 = new JLabel();
        j6.setText("Enter Product Quantity ");
        j6.setBounds(15, 210, 180, 30);
        j6.setFont(new Font("Pacifico", Font.BOLD, 15));
        j6.setForeground(Color.WHITE);

        JTextField t6 = new JTextField();
        t6.setBounds(220, 210, 200, 30);
        t6.setFont(new Font("Pacifico", Font.BOLD, 15));
        t6.setBackground(sadist_blue);

        a1 = new JButton("Submit");
        a1.setBounds(230, 280, 100, 30);
        a1.setBackground(Color.WHITE);
        a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/charan", "root",
                            "BhardwajSai@123");
                    Statement st = con.createStatement();
                    String s1 = t1.getText().toUpperCase();
                    String s2 = t2.getText().toUpperCase();
                    String s3 = t3.getText().toUpperCase();
                    String s4 = t4.getText().toUpperCase();
                    String s5 = t5.getText().toUpperCase();
                    String s6 = t6.getText();
                    String query = "insert into products values(" + s1 + ",'" + s2 + "'," + s3 + ",'" + s4 + "','" + s5
                            + "'," + s6 + ")";
                    int result = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to submit this form?",
                            "Confirm Submit",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        try {
                            int rs = st.executeUpdate(query);
                            if (rs == 0) {
                                throw new SQLException(
                                        "Data cannot be inserted");
                            }

                            else {
                                JOptionPane.showMessageDialog(null,
                                        "Data is inserted in the table",
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                t1.setText("");
                                t2.setText("");
                                t3.setText("");
                                t4.setText("");
                                t5.setText("");
                                t6.setText("");
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR: " + e1.getMessage(),
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            t6.setText("");
                        }
                    }
                } catch (SQLException e3) {

                }
            }

        });

        a2 = new JButton("Clear");
        a2.setBounds(90, 280, 100, 30);
        a2.setBackground(Color.WHITE);
        a2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int clr = JOptionPane.showConfirmDialog(null, "Are you sure", "Clear",
                        JOptionPane.YES_NO_OPTION);
                if (clr == JOptionPane.YES_OPTION) {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                }
            }
        });

        add(j1);
        add(j2);
        add(j3);
        add(j4);
        add(j5);
        add(j6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(a1);
        add(a2);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}