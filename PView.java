import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
// import javax.swing.table.TableColumn;

import java.sql.ResultSetMetaData;

public class PView extends JFrame {
    JScrollPane sc;

    PView() {
        setSize(1300, 1000);
        setTitle("All Products");
        setResizable(false);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/charan", "root",
                    "BhardwajSai@123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from products");
            Vector<Vector<Object>> data = new Vector<>();
            Vector<String> columnNames = new Vector<>();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            JTable table = new JTable(data, columnNames);
            // TableColumn c1 = table.getColumnModel().getColumn(1);
            // c1.setPreferredWidth(200);
            sc = new JScrollPane(table);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        add(sc);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
