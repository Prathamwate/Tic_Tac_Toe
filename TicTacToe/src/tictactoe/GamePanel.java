package tictactoe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.text.SimpleDateFormat;  
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;  
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class GamePanel implements ActionListener
{
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
   LocalDateTime now = LocalDateTime.now();
   String cdate=dtf.format(now);
    String winnerData,player,x;
    JFrame jf;
    JLabel timer_label,timer_label_end;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
        JLabel timer;  
            LocalTime start_time,end_time,end_data;

    int count=0;
    String xo_value="", title_str="";
    boolean win=false;
    Color color1;   
    String player1,player2,pcolor1,pcolor2;
    String player_who_wins;
    String player_who_looses;
    boolean player1_turn=true;
    String xo = "";
    
     GamePanel(String player1, String pcolor1, String player2, String pcolor2)
    {
        this.player1=player1;
        this.player2=player2;
        this.pcolor1=pcolor1;
        this.pcolor2=pcolor2;
        System.out.println("color came are "+pcolor1+"\t"+pcolor2);
    }
    
    
    void openGame()
    {
        start_time=LocalTime.now();
        jf=new JFrame();
        jf.setTitle(player1+" (X) turns");
        JPanel content = new JPanel(); // This is JPanel
        content.setLayout(new BorderLayout());
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(3,3));

        jf.setSize(600,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        //jf.setLayout(new GridLayout(3, 3)); 
        
        jb1=new JButton();
        jb1.addActionListener(this);
        buttonsPanel.add(jb1);
        
        jb2=new JButton();
        jb2.addActionListener(this);
        buttonsPanel.add(jb2);
        
        jb3=new JButton();
        jb3.addActionListener(this);
        buttonsPanel.add(jb3);
        
        jb4=new JButton();
        jb4.addActionListener(this);
        buttonsPanel.add(jb4);
        
        jb5=new JButton();
        jb5.addActionListener(this);
        buttonsPanel.add(jb5);
        
        jb6=new JButton();
        jb6.addActionListener(this);
        buttonsPanel.add(jb6);
        
        jb7=new JButton();
        jb7.addActionListener(this);
        buttonsPanel.add(jb7);
        
        jb8=new JButton();
        jb8.addActionListener(this);
        buttonsPanel.add(jb8);
        
        jb9=new JButton();
        jb9.addActionListener(this);
        buttonsPanel.add(jb9);
        jf.setVisible(true);
               
        timer_label = new JLabel("START TIME");
        timer_label_end=new JLabel("END TIME");
        timer_label.setText("START TIME : "+start_time+"");
      
       
       content.add(buttonsPanel, BorderLayout.CENTER);
       
       jf.setContentPane(content);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    
    { 
        
        count=count+1;
        if(player1_turn==true)
        {
            getPlayerColor(pcolor1);
            xo_value="X";
            title_str="0";
            jf.setTitle(player2+" ("+title_str+") turns");
            player1_turn=false;
        }
        else
        {
            xo_value="0";
            getPlayerColor(pcolor2);
            title_str="X";
            jf.setTitle(player1+" ("+title_str+") turns");
            
            player1_turn=true;
        }
        
        if(e.getSource()==jb1)
        {
            jb1.setBackground(color1);
            jb1.setFont(new Font("Arial", 1, 50));
            jb1.setText(xo_value);
            jb1.setEnabled(false);
        }
        if(e.getSource()==jb2)
        {
            jb2.setBackground(color1);
            jb2.setFont(new Font("Arial", 1, 50));
            jb2.setText(xo_value);
            jb2.setEnabled(false);
        }
        if(e.getSource()==jb3)
        {
            jb3.setBackground(color1);
            jb3.setFont(new Font("Arial", 1, 50));
            jb3.setText(xo_value);
            jb3.setEnabled(false);
        }
        if(e.getSource()==jb4)
        {
            jb4.setBackground(color1);
            jb4.setFont(new Font("Arial", 1, 50));
            jb4.setText(xo_value);
            jb4.setEnabled(false);
        }
        if(e.getSource()==jb5)
        {
            jb5.setBackground(color1);
            jb5.setFont(new Font("Arial", 1, 50));
            jb5.setText(xo_value);
            jb5.setEnabled(false);
        }
        if(e.getSource()==jb6)
        {
            jb6.setBackground(color1);
            jb6.setFont(new Font("Arial", 1, 50));
            jb6.setText(xo_value);
            jb6.setEnabled(false);
        }
        if(e.getSource()==jb7)
        {
            jb7.setBackground(color1);
            jb7.setFont(new Font("Arial", 1, 50));
            jb7.setText(xo_value);
            jb7.setEnabled(false);
        }
        if(e.getSource()==jb8)
        {
            jb8.setBackground(color1);
            jb8.setFont(new Font("Arial", 1, 50));
            jb8.setText(xo_value);
            jb8.setEnabled(false);
        }
        if(e.getSource()==jb9)
        {
            jb9.setBackground(color1);
            jb9.setFont(new Font("Arial", 1, 50));
            jb9.setText(xo_value);
            jb9.setEnabled(false);
        }
        winningPossibilities();
       try {
           whoWins();
       } catch (IOException ex) {
           Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParseException ex) {
           Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }

    void databaseAdd(String player, String method) throws ParseException {
    	try{  

            winnerData = player;
     
//    		Class.forName("com.mysql.cj.jdbc.Driver");  
//    		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root","Pratham@1129");  
            
    		String query = " insert into tic (player1,player2,result,date,start_time,end_time,duration)"
    		        + " values (?,?,?,?,?,?,?)";
            ConnectionString connn=new ConnectionString();
            
            Connection conn=connn.getConnection();
            end_time=LocalTime.now();
	        String format_st=start_time.toString().substring(0,8);
	        String format_et=end_data.toString().substring(0,8);
	    	SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss");
			Date date1 = simpleDateFormat.parse(format_st);
			Date date2 = simpleDateFormat.parse(format_et);
			long differenceInMilliSeconds= Math.abs(date2.getTime() - date1.getTime());
			long differenceInHours= (differenceInMilliSeconds / (60 * 60 * 1000))% 24;
			long differenceInMinutes= (differenceInMilliSeconds / (60 * 1000)) % 60;
			long differenceInSeconds= (differenceInMilliSeconds / 1000) % 60;
		String Difference=differenceInHours +" Hours "+ differenceInMinutes +" Minutes "+differenceInSeconds+" Seconds ";
                      PreparedStatement preparedStmt = conn.prepareStatement(query);
    		      preparedStmt.setString (1, player1);
                      preparedStmt.setString (2,player2);
                      preparedStmt.setString(3,winnerData+" Won");
                      preparedStmt.setString(4,cdate);
                      preparedStmt.setString(5,start_time.toString());
                      preparedStmt.setString(6,end_data.toString());
                      preparedStmt.setString(7,Difference);
    		      int i = preparedStmt.executeUpdate();
    		      if(i > 0) {
    		    	  System.out.println("winner data added to db!!!!!!");
    		      }
    		      conn.close();
    		}catch(Exception e){ System.out.println(e);} 
        
     
    }
    
    
    void gameDrawDb() throws ParseException {
    	try{  
    		 ConnectionString connn=new ConnectionString();
             
             Connection conn=connn.getConnection(); 
             
    		String query = " insert into tic (player1,player2,result,date,start_time,end_time,duration)"
    		        + " values (?,?,?,?,?,?,?)";

                 end_time=LocalTime.now();
        String format_st=start_time.toString().substring(0,8);
        String format_et=end_data.toString().substring(0,8);
    	SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss");
		Date date1 = simpleDateFormat.parse(format_st);
		Date date2 = simpleDateFormat.parse(format_et);
		long differenceInMilliSeconds
			= Math.abs(date2.getTime() - date1.getTime());
		long differenceInHours
			= (differenceInMilliSeconds / (60 * 60 * 1000))
			% 24;
		long differenceInMinutes
			= (differenceInMilliSeconds / (60 * 1000)) % 60;
		long differenceInSeconds
			= (differenceInMilliSeconds / 1000) % 60;
		String Difference=differenceInHours +" Hours "+ differenceInMinutes +" Minutes "+differenceInSeconds+" Seconds ";
    		     
                
                PreparedStatement preparedStmt = conn.prepareStatement(query);
    		      preparedStmt.setString (1,player1);
                      preparedStmt.setString (2,player2);
                      preparedStmt.setString (3,"GAME DRAW");
                      preparedStmt.setString (4,cdate);
                      preparedStmt.setString(5,start_time.toString());
                      preparedStmt.setString(6,end_data.toString());
                      preparedStmt.setString (7,Difference);
                      
    		     
    		      int i = preparedStmt.executeUpdate();
    		      if(i > 0) {
    		    	  System.out.println("winner data added to db!!!!!!");
    		      }
    		      conn.close();
    		}catch(Exception e){ System.out.println(e);} 
       
      timer_label_end.setText("END TIME : "+end_data);
     

    }
    
    void winningPossibilities()
    {
        //horizontal winning possibilities
        if(jb1.getText()==jb2.getText() && jb2.getText()==jb3.getText() && jb3.getText() != "")
        {
            win=true;
        }
        else if(jb4.getText()==jb5.getText() && jb5.getText()==jb6.getText() && jb6.getText() != "")
        {
            win=true;
        }
        else if(jb7.getText()==jb8.getText() && jb8.getText()==jb9.getText() && jb9.getText() != "")
        {
            win=true;
        }
        //vergame_dataal winning possibilities
        else if(jb1.getText()==jb4.getText() && jb4.getText()==jb7.getText() && jb7.getText() != "")
        {
            win=true;
        }
        else if(jb2.getText()==jb5.getText() && jb5.getText()==jb8.getText() && jb8.getText() != "")
        {
            win=true;
        }
        else if(jb3.getText()==jb6.getText() && jb6.getText()==jb9.getText() && jb9.getText() != "")
        {
            win=true;
        }
        //diagonal winning possibilities
        else if(jb1.getText()==jb5.getText() && jb5.getText()==jb9.getText() && jb9.getText() != "")
        {
            win=true;
        }
        else if(jb3.getText()==jb5.getText() && jb5.getText()==jb7.getText() && jb7.getText() != "")
        {
            win=true;
        }
        //game draw
        else
        {
            win=false;
            
        }
    }
    void whoWins() throws IOException, ParseException
    {
        if(win==true)
        {       
            if(xo_value.equals("X"))
            {
                player_who_wins=player1;
                
                xo = "X";
            }
            else 
            {
                player_who_wins=player2;
                xo = "O";
            }

             databaseAdd(player_who_wins, xo);
            
            String win_title=player_who_wins+" ("+xo_value+")"+" wins";
            jf.setTitle(win_title);
           JOptionPane.showMessageDialog(jf, win_title, "RESULT", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("show.png"));
           UserPanel up=new UserPanel();
           end_data = LocalTime.now();
String format_st=start_time.toString().substring(0,8);
String format_et=end_data.toString().substring(0,8);
	SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss");
		Date date1 = simpleDateFormat.parse(format_st);
		Date date2 = simpleDateFormat.parse(format_et);
		long differenceInMilliSeconds
			= Math.abs(date2.getTime() - date1.getTime());
		long differenceInHours
			= (differenceInMilliSeconds / (60 * 60 * 1000))
			% 24;
		long differenceInMinutes
			= (differenceInMilliSeconds / (60 * 1000)) % 60;
		long differenceInSeconds
			= (differenceInMilliSeconds / 1000) % 60;
		String Difference=differenceInHours +""+ differenceInMinutes +""+differenceInSeconds+"";


        }
       
        else if(win==false && count==9)
        {
                JOptionPane.showMessageDialog(jf, "Match Draw");
            gameDrawDb();
            restartGame();
            end_data=LocalTime.now();
        }
        else if(win==false && count!=9)
        {

            if(xo_value.equals("X"))
            {
                player_who_looses=player1;
                
                xo = "X";
            }
            else 
            {
                player_who_looses=player2;
                xo = "O";
            }
      
            end_data=LocalTime.now();
            timer_label_end.setText("END TIME : "+end_data);
       // System.out.println("This is end time : "+end_data);
        }
    
    }
     void getPlayerColor(String playerColor)
    {
    	switch (playerColor) 
        {
		case "Red":
			color1=Color.red;
			break;
		case "Orange":
			color1=Color.orange;
			break;
		case "Green":
			color1=Color.green;
			break;
		case "Yellow":
			color1=Color.yellow;
			break;
		case "Pink":
			color1=Color.pink;
			break;
		case "Blue":
			color1=Color.blue;
			break;
		default:
			break;
	}
    }

     void restartGame()
    {
    	int i=JOptionPane.showConfirmDialog(jf, "Do you want to restart the game ?");
        if(i==0)
        {
            jb1.setText("");
            jb2.setText("");
            jb3.setText("");
            jb4.setText("");
            jb5.setText("");
            jb6.setText("");
            jb7.setText("");
            jb8.setText("");
            jb9.setText("");

            jb1.setBackground(null);
            jb2.setBackground(null);
            jb3.setBackground(null);
            jb4.setBackground(null);
            jb5.setBackground(null);
            jb6.setBackground(null);
            jb7.setBackground(null);
            jb8.setBackground(null);
            jb9.setBackground(null);

            btnSetEnabling(true);
            count=0;
            win=false;

            if(player_who_wins.equals(player1))
            {
                player1_turn=true;
            }
            else
            {
                player1_turn=false;
            }

            jf.setTitle(player_who_wins+" ("+xo_value+") turns");

        }
        else if(i==1)
        {
            System.exit(0);
        }
        else
        {
            btnSetEnabling(false);
        }
    }

    void btnSetEnabling(boolean b)
    {
        jb1.setEnabled(b);
        jb2.setEnabled(b);
        jb3.setEnabled(b);
        jb4.setEnabled(b);
        jb5.setEnabled(b);
        jb6.setEnabled(b);
        jb7.setEnabled(b);
        jb8.setEnabled(b);
        jb9.setEnabled(b);
    }
    

}