import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PSearch extends JFrame {
    PSearch() {
        setSize(800, 600);
        setTitle("Product Search");
        setLayout(null);
        setResizable(false);

        JLabel j1 = new JLabel("Category");
        j1.setBounds(30, 30, 150, 30);
        j1.setFont(new Font("Pacifico", Font.BOLD, 15));
        j1.setForeground(Color.BLACK);
        add(j1);

        JComboBox<String> categoryComboBox = new JComboBox<>();
        categoryComboBox.setBounds(30, 60, 150, 30);
        add(categoryComboBox);

        JTextField minPriceField = new JTextField();
        minPriceField.setBounds(200, 60, 100, 30);
        add(minPriceField);

        JLabel j2 = new JLabel("Min Price");
        j2.setBounds(200, 30, 100, 30);
        j2.setFont(new Font("Pacifico", Font.BOLD, 15));
        j2.setForeground(Color.BLACK);
        add(j2);

        JTextField maxPriceField = new JTextField();
        maxPriceField.setBounds(320, 60, 100, 30);
        add(maxPriceField);

        JLabel j3 = new JLabel("Max Price");
        j3.setBounds(320, 30, 100, 30);
        j3.setFont(new Font("Pacifico", Font.BOLD, 15));
        j3.setForeground(Color.BLACK);
        add(j3);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(450, 60, 100, 30);
        add(searchButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 120, 700, 400);
        add(scrollPane);

        JTable table = new JTable();
        scrollPane.setViewportView(table);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/charan", "root",
                "BhardwajSai@123");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT DISTINCT PCategory FROM products")) {
            while (rs.next()) {
                categoryComboBox.addItem(rs.getString("PCategory"));
            }
            categoryComboBox.setSelectedItem(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String category = (String) categoryComboBox.getSelectedItem();
                String minPriceStr = minPriceField.getText();
                String maxPriceStr = maxPriceField.getText();

                String query = "SELECT * FROM products WHERE 1=1";

                if (category != null && !category.isEmpty()) {
                    query += " AND PCategory='" + category + "'";
                }
                if (!minPriceStr.isEmpty()) {
                    double minPrice = Double.parseDouble(minPriceStr);
                    query += " AND PPrice >= " + minPrice;
                }
                if (!maxPriceStr.isEmpty()) {
                    double maxPrice = Double.parseDouble(maxPriceStr);
                    query += " AND PPrice <= " + maxPrice;
                }

                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/charan", "root",
                        "BhardwajSai@123");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query)) {
                    Vector<Vector<Object>> data = new Vector<>();
                    Vector<String> columnNames = new Vector<>();
                    int columnCount = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        columnNames.add(rs.getMetaData().getColumnName(i));
                    }
                    while (rs.next()) {
                        Vector<Object> row = new Vector<>();
                        for (int i = 1; i <= columnCount; i++) {
                            row.add(rs.getObject(i));
                        }
                        data.add(row);
                    }
                    table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
