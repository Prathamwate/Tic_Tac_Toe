
package tictactoe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.table.TableColumn;

public class Whole{
static JTable table;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/tictactoe";
String userName = "root";
String password = "Pratham@1129";

public void createUI2()
{
try{
    Connection con = null;
Statement st = null; 
 ResultSet rs = null; String s;
 con = DriverManager.getConnection("jdbc:mysql://localhost/tictactoe","root","Pratham@1129");
 st = con.createStatement();
 s = "select * from tic"; 
 rs = st.executeQuery(s);
 ResultSetMetaData rsmt = rs.getMetaData(); 
 int c = rsmt.getColumnCount();
 Vector column = new Vector(c);

 for(int i = 1; i <= c; i++) {
 column.add(rsmt.getColumnName(i)); 
 } 

 Vector data = new Vector(); 
 Vector row = new Vector(); 

 while(rs.next()) { 
 row = new Vector(c); 

 for(int i = 1; i <= c; i++){
 row.add(rs.getString(i)); 
 } 
data.add(row); 
 } 
 JFrame frame = new JFrame(); 
 frame.setSize(600,300); 
 frame.setLocationRelativeTo(null); 
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 JPanel panel = new JPanel(); 
 JTable table = new JTable(data,column);
  TableColumn col,col2,col4,col6;
 col = table.getColumnModel().getColumn(1);
 col.setCellRenderer(new MyRenderer(Color.green, Color.white));

 col2 = table.getColumnModel().getColumn(3);
 col2.setCellRenderer(new MyRenderer(Color.green, Color.white));
 
  col4 = table.getColumnModel().getColumn(5);
 col4.setCellRenderer(new MyRenderer(Color.green, Color.white));
 
  col6 = table.getColumnModel().getColumn(7);
 col6.setCellRenderer(new MyRenderer(Color.green, Color.white));
 JScrollPane jsp = new JScrollPane(table); 
 panel.setLayout(new BorderLayout()); 
 panel.add(jsp,BorderLayout.CENTER); 
 frame.setContentPane(panel); 
 frame.setVisible(true); 

 }catch(Exception e){ JOptionPane.showMessageDialog(null, "ERROR"); }
} 

    public static void main(String args[])
{
Whole w=new Whole();
w.createUI2();
}
}

