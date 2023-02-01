package tictactoe;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;


public class UserPanel implements ActionListener
{
    JFrame jf ;
    JLabel jl1, jl2, jl3,jl4;
    JTextField jt1, jt2;
    JButton jb,jdata;
    private Color oColor=Color.BLUE;
   @SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cb, cb1;
    String color[]={"Red", "Orange", "Green", "Yellow", "Pink", "Blue"};        
    String color1[]={"Red", "Orange", "Green", "Yellow", "Pink", "Blue"}; 
  
  
	UserPanel() throws IOException
    {
        jf=new JFrame("TicTacToe Game ");
        jf.setSize(600,600);	
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        jf.getContentPane().setBackground(Color.pink);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        
        jl1=new JLabel("Enter Player One:(X) ");
        jl1.setBounds(50, 50, 120, 30);
        jl1.setForeground(Color.blue);
        jf.add(jl1);
        
        jt1=new JTextField();
        jt1.setBounds(200, 50, 250, 40);
        jf.add(jt1);
        
        jl3=new JLabel("choose the color: ");
        jl3.setBounds(50, 210, 120, 30);
        jf.add(jl3);
	    cb=new JComboBox(color);    
	    cb.setBounds(200, 100, 250, 40);    
	    jf.add(cb);        
	    jf.setLayout(null);       
	    jf.setVisible(true); 
                
        jl2=new JLabel("Enter Player Two:(0) ");
        jl2.setBounds(50, 160, 120, 30);
        jl2.setForeground(Color.blue);
        jf.add(jl2);
        
        jt2=new JTextField();
        jt2.setBounds(200, 160, 250, 40);
        jf.add(jt2);
        
        jl4=new JLabel("choose the color: ");
        jl4.setBounds(50, 100, 120, 30);
        jf.add(jl4);
	    cb1=new JComboBox(color1);    
	    cb1.setBounds(200, 210, 250, 40);    
	    jf.add(cb1);        
	    jf.setLayout(null);     
	    jf.setVisible(true);


        jb=new JButton();
        Image img = ImageIO.read(getClass().getResource("start.png"));
        jb.setIcon(new ImageIcon(img));
        jb.setBounds(200, 280, 150, 50);
        jb.addActionListener(this);
        jf.add(jb);
        
        jdata=new JButton();
        Image img2 = ImageIO.read(getClass().getResource("show.png"));
        jdata.setIcon(new ImageIcon(img2));
        jdata.setBounds(200,350,150,50);
        jdata.addActionListener(this);
        jf.add(jdata);
        jf.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jb)
        {   
            
            String player1=jt1.getText();
            String player2=jt2.getText();
            String pcolor1=(String) cb.getItemAt(cb.getSelectedIndex());
            String pcolor2=(String) cb1.getItemAt(cb1.getSelectedIndex());
            
           
            
             if(pcolor1==pcolor2)
            {
             JOptionPane.showMessageDialog(jf, "Please Enter diffrent color", "Incomplete Information" , JOptionPane.ERROR_MESSAGE);
            
            }
             else
            {
            GamePanel gp = new GamePanel(player1, pcolor1, player2, pcolor2);
            gp.openGame();
           // gp.whoLost();
            jf.setVisible(false);
            }


        }
        
        if(e.getSource()==jdata)
        {

        Whole openDataBase=new Whole();
        jf.setVisible(false);
        openDataBase.createUI2();
        
        }
    }
    
    public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);

		new UserPanel();

	}

    private ImageIcon createImageIcon(String t22png, String java) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

   