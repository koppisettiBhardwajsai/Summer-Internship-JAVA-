import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PUpdate extends JFrame {
    String c1;
    JLabel q1, q2, q3, q4, q5, q6;
    JTextField jf1;

    PUpdate() {
        setSize(500, 630);
        setTitle("Product Update");
        setResizable(false);
        setLayout(null);

        Color code = new Color(2, 48, 32);
        getContentPane().setBackground(code);
        Color sadist_blue = new Color(196, 180, 84);

        JLabel cru = new JLabel();
        cru.setText("Enter the Product Id to view details");
        cru.setBounds(15, 30, 270, 30);
        cru.setFont(new Font("Pacifico", Font.BOLD, 15));
        cru.setForeground(Color.WHITE);

        jf1 = new JTextField();
        jf1.setBounds(300, 30, 80, 30);
        jf1.setFont(new Font("Pacifico", Font.BOLD, 15));
        jf1.setBackground(sadist_blue);

        JButton m = new JButton();
        m.setText("View");
        m.setBounds(400, 30, 70, 30);
        m.setBackground(Color.WHITE);
        m.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/charan", "root",
                            "BhardwajSai@123");
                    Statement st = con.createStatement();
                    c1 = jf1.getText();
                    String query = "select * from products where id=" + c1;
                    try {
                        ResultSet res = st.executeQuery(query);
                        if (res.next()) {
                            clearLabels();
                            setUpLabels();

                            int id = res.getInt("id");
                            String name = res.getString("PName");
                            int price = res.getInt("PPrice");
                            String brand = res.getString("PBrand");
                            String category = res.getString("PCategory");
                            int quantity = res.getInt("PQuantity");

                            q1.setText("ID:     " + id);
                            q2.setText("Name: " + name);
                            q3.setText("Price: " + price);
                            q4.setText("Brand: " + brand);
                            q5.setText("Category: " + category);
                            q6.setText("Quantity: " + quantity);

                            revalidate();
                            repaint();

                            add(q1);
                            add(q2);
                            add(q3);
                            add(q4);
                            add(q5);
                            add(q6);

                        } else {
                            throw new SQLException("No Data Found");
                        }
                    } catch (SQLException e4) {
                        JOptionPane.showMessageDialog(null,
                                "ERROR: " + e4.getMessage(),
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e3) {
                    JOptionPane.showMessageDialog(null,
                            "ERROR: " + e3.getMessage() + c1,
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel main = new JLabel("Enter only one Detail at a time to Update");
        main.setBounds(15, 230, 350, 30);
        main.setFont(new Font("Pacifico", Font.BOLD, 15));
        main.setForeground(Color.RED);
        add(main);

        JLabel j1 = new JLabel();
        j1.setBounds(15, 270, 200, 30);
        j1.setText("Enter ID of Product");
        j1.setFont(new Font("Pacifico", Font.BOLD, 15));
        j1.setForeground(Color.WHITE);

        JTextField t1 = new JTextField();
        t1.setBounds(220, 270, 110, 30);
        t1.setFont(new Font("Pacifico", Font.BOLD, 15));
        t1.setBackground(sadist_blue);

        JLabel j2 = new JLabel();
        j2.setBounds(15, 310, 150, 30);
        j2.setText("Enter Product Name");
        j2.setFont(new Font("Pacifico", Font.BOLD, 15));
        j2.setForeground(Color.WHITE);

        JTextField t2 = new JTextField();
        t2.setBounds(220, 310, 200, 30);
        t2.setFont(new Font("Pacifico", Font.BOLD, 15));
        t2.setBackground(sadist_blue);

        JLabel j3 = new JLabel();
        j3.setBounds(15, 350, 150, 30);
        j3.setText("Enter Product Price");
        j3.setFont(new Font("Pacifico", Font.BOLD, 15));
        j3.setForeground(Color.WHITE);

        JTextField t3 = new JTextField();
        t3.setBounds(220, 350, 200, 30);
        t3.setFont(new Font("Pacifico", Font.BOLD, 15));
        t3.setBackground(sadist_blue);

        JLabel j4 = new JLabel();
        j4.setBounds(15, 390, 170, 30);
        j4.setText("Enter Product Brand");
        j4.setFont(new Font("Pacifico", Font.BOLD, 15));
        j4.setForeground(Color.WHITE);

        JTextField t4 = new JTextField();
        t4.setBounds(220, 390, 200, 30);
        t4.setFont(new Font("Pacifico", Font.BOLD, 15));
        t4.setBackground(sadist_blue);

        JLabel j5 = new JLabel();
        j5.setBounds(15, 430, 180, 30);
        j5.setText("Enter Product Category");
        j5.setFont(new Font("Pacifico", Font.BOLD, 15));
        j5.setForeground(Color.WHITE);

        JTextField t5 = new JTextField();
        t5.setBounds(220, 430, 200, 30);
        t5.setFont(new Font("Pacifico", Font.BOLD, 15));
        t5.setBackground(sadist_blue);

        JLabel j6 = new JLabel();
        j6.setText("Enter Product Quantity ");
        j6.setBounds(15, 470, 180, 30);
        j6.setFont(new Font("Pacifico", Font.BOLD, 15));
        j6.setForeground(Color.WHITE);

        JTextField t6 = new JTextField();
        t6.setBounds(220, 470, 200, 30);
        t6.setFont(new Font("Pacifico", Font.BOLD, 15));
        t6.setBackground(sadist_blue);

        JButton a1 = new JButton("Submit");
        a1.setBounds(230, 510, 100, 30);
        a1.setBackground(Color.WHITE);
        a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/charan", "root",
                            "BhardwajSai@123");
                    Statement st = con.createStatement();

                    String s1 = t1.getText().trim();
                    String s2 = t2.getText().trim();
                    String s3 = t3.getText().trim();
                    String s4 = t4.getText().trim();
                    String s5 = t5.getText().trim();
                    String s6 = t6.getText().trim();

                    StringBuilder query = new StringBuilder("update products set ");

                    boolean updateNeeded = false;

                    if (!s1.isEmpty()) {
                        try {
                            int id = Integer.parseInt(s1);
                            query.append("id=").append(id).append(", ");
                            updateNeeded = true;
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a valid number for ID",
                                    "Input Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    if (!s2.isEmpty()) {
                        query.append("PName='").append(s2).append("', ");
                        updateNeeded = true;
                    }

                    if (!s3.isEmpty()) {
                        try {
                            int price = Integer.parseInt(s3);
                            query.append("PPrice=").append(price).append(", ");
                            updateNeeded = true;
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a valid number for Price",
                                    "Input Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    if (!s4.isEmpty()) {
                        query.append("PBrand='").append(s4).append("', ");
                        updateNeeded = true;
                    }

                    if (!s5.isEmpty()) {
                        query.append("PCategory='").append(s5).append("', ");
                        updateNeeded = true;
                    }

                    if (!s6.isEmpty()) {
                        try {
                            int quantity = Integer.parseInt(s6);
                            query.append("PQuantity=").append(quantity).append(", ");
                            updateNeeded = true;
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a valid number for Quantity",
                                    "Input Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    if (!updateNeeded) {
                        JOptionPane.showMessageDialog(null, "No fields to update", "Update Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    query.setLength(query.length() - 2);
                    query.append(" where id=").append(c1);
                    int result = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to submit this form?",
                            "Confirm Submit",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        int rs = st.executeUpdate(query.toString());
                        if (rs == 0) {
                            throw new SQLException("Data cannot be updated");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Data is updated in the table",
                                    "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            t6.setText("");
                        }
                    }
                } catch (SQLException e3) {
                    JOptionPane.showMessageDialog(null,
                            "ERROR: " + e3.getMessage(),
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton a2 = new JButton("Clear");
        a2.setBounds(90, 510, 100, 30);
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

        add(cru);
        add(jf1);
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
        add(m);
        add(a1);
        add(a2);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setUpLabels() {
        q1 = new JLabel();
        q1.setBounds(30, 50, 300, 30);
        q1.setFont(new Font("Pacifico", Font.BOLD, 15));
        q1.setForeground(Color.WHITE);

        q2 = new JLabel();
        q2.setBounds(30, 80, 300, 30);
        q2.setFont(new Font("Pacifico", Font.BOLD, 15));
        q2.setForeground(Color.WHITE);

        q3 = new JLabel();
        q3.setBounds(30, 110, 300, 30);
        q3.setFont(new Font("Pacifico", Font.BOLD, 15));
        q3.setForeground(Color.WHITE);

        q4 = new JLabel();
        q4.setBounds(30, 140, 300, 30);
        q4.setFont(new Font("Pacifico", Font.BOLD, 15));
        q4.setForeground(Color.WHITE);

        q5 = new JLabel();
        q5.setBounds(30, 170, 200, 30);
        q5.setFont(new Font("Pacifico", Font.BOLD, 15));
        q5.setForeground(Color.WHITE);

        q6 = new JLabel();
        q6.setBounds(30, 200, 200, 30);
        q6.setFont(new Font("Pacifico", Font.BOLD, 15));
        q6.setForeground(Color.WHITE);

        add(q1);
        add(q2);
        add(q3);
        add(q4);
        add(q5);
        add(q6);
    }

    public void clearLabels() {
        if (q1 != null)
            remove(q1);
        if (q2 != null)
            remove(q2);
        if (q3 != null)
            remove(q3);
        if (q4 != null)
            remove(q4);
        if (q5 != null)
            remove(q5);
        if (q6 != null)
            remove(q6);
        revalidate();
        repaint();
    }

}
