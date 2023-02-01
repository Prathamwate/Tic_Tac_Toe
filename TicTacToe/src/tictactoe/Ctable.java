package tictactoe;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.table.TableColumn;


public class Ctable extends JFrame 
{
   private JTable table;
   private TableColumn col;
   String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/test";
String userName = "root";
String password = "root";
String[] columnNames = {"ID","WINNER","LOOSER","DATE"};

   

   public static void main(String [] args) {
      new Ctable();
   }
}
// Customize the code to set the color for each column in JTable
class MyRenderer extends DefaultTableCellRenderer 
{
   Color bg, fg;
   public MyRenderer(Color bg, Color fg) {
      super();
      this.bg = bg;
      this.fg = fg;
   }
   public Component getTableCellRendererComponent(JTable table, Object 
   value, boolean isSelected, boolean hasFocus, int row, int column) 
   {
      Component cell = super.getTableCellRendererComponent(table, value, 
      isSelected, hasFocus, row, column);
      cell.setBackground(bg);
      cell.setForeground(fg);
      return cell;
   }
}