import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PDelete extends JFrame {
    PDelete() {
        setSize(500, 300);
        setTitle("Product Delete");
        setResizable(false);
        setLayout(null);

        Color code = new Color(2, 48, 32);
        getContentPane().setBackground(code);
        Color sadist_blue = new Color(196, 180, 84);

        JLabel l1 = new JLabel();
        l1.setText("Enter the Product ID");
        l1.setBounds(30, 100, 200, 30);
        l1.setFont(new Font("Pacifico", Font.BOLD, 15));
        l1.setForeground(Color.WHITE);

        JTextField t1 = new JTextField();
        t1.setBounds(220, 100, 110, 30);
        t1.setFont(new Font("Pacifico", Font.BOLD, 15));
        t1.setBackground(sadist_blue);

        JButton d = new JButton("Delete");
        d.setBounds(250, 170, 100, 30);
        d.setBackground(Color.WHITE);
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/charan", "root",
                            "BhardwajSai@123");
                    Statement st = con.createStatement();
                    String getid = t1.getText();
                    String query = "delete from products where id=" + getid;
                    int result = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete this Product?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        try {
                            int rs = st.executeUpdate(query);
                            if (rs == 0) {
                                throw new SQLException(
                                        "Table does not contains the data with the id:" + getid);
                            }

                            else {
                                JOptionPane.showMessageDialog(null,
                                        "Data is deleted from the table",
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                t1.setText("");
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null,
                                    "ERROR: " + e1.getMessage(),
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                            t1.setText("");
                        }
                    }

                } catch (SQLException e2) {

                }
            }
        });

        JButton d1=new JButton("Clear");
        d1.setBounds(130, 170, 80, 30);
        d1.setBackground(Color.WHITE);
        d1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int clr = JOptionPane.showConfirmDialog(null, "Are you sure", "Clear",
                        JOptionPane.YES_NO_OPTION);
                if (clr == JOptionPane.YES_OPTION) {
                    t1.setText("");
                }
            }
        });

        add(d);
        add(d1);
        add(l1);
        add(t1);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
