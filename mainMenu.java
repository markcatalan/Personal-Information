import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class mainMenu extends JFrame implements ActionListener, MouseListener//, ItemListener
{  
   Container con = getContentPane();
   
   JPanel panel = new JPanel();
   
	String content[] = {"INSERT", "DELETE", "MODIFY", "DISPLAY", "SAVE"};
	String toolTip[] = {"Insert Personal Information", "Delete Existing Information",
	 						  "Modify Personal Information", "Display Personal Information", "Save Information"};
							  
	JLabel header = new JLabel("PERSONAL INFORMATION");
	int x = 90, y = 450, w = 100, h = 50; 
	
	JButton button[] = new JButton[5];
   JButton btnSave = new JButton("SAVE");
	
	Font font = new Font("Garamond", Font.BOLD, 15);
	//Color LSG = new Color(32, 178, 170); // Light Sea Green
	//Color DC = new Color(0, 139, 139); // Dark Cyan
   
   Color LSG = new Color(0,206,209);// Dark Turqoise
	Color DC = new Color(64,224,208); // Turqoise
   Color dflt;
   
   JMenuBar mainBar = new JMenuBar();
   JMenu menu = new JMenu("TRIAL");
   
   Icon image = new ImageIcon(getClass().getResource("unknown.jpg"));
   
 	JLabel imageLabel = new JLabel(image);  
   
   // ********************** INSERT ******************* //
   
   boolean check = true;
   
   String label[] = {"Last Name        ","First Name        ","Middle Name    ","Age                     ", 
                     "Sex                     ", "Address            ", 
                     "Birthdate           ", "Contact #          ", "Email Address ","Occupation      ", 
                     "Nationality        ", "Religion             ", "Marital Status  ", "Blood Type       "};
   
   JLabel lblInsert[] = new JLabel[14];
   JTextField fields[] = new JTextField[14];
   
   JRadioButton rbtnMale = new JRadioButton("MALE", true);
   JRadioButton rbtnFemale = new JRadioButton("FEMALE");
   
   ButtonGroup bgInsert = new ButtonGroup();
   
   int lblX = 10, lblY = 90, lblW = 97, lblH = 20;
   int fldX = 98, fldY = 92, fldW = 200, fldH = 15;
   
   String type[] = {"A+", "B+", "AB+",
                    "A-", "B-", "AB-",
                    "O+", "O-"};
  // JComboBox <String> bloodType = new JComboBox <String>(type);
  JComboBox bloodType = new JComboBox();
   
   // ***************** SAVE ****************
   JButton btnOk;
   JFrame success;
     
   JPanel genderPanel = new JPanel();
   JLabel gender[] = new JLabel[2];
   
   Icon male = new ImageIcon(getClass().getResource("Male.jpg"));
   Icon female = new ImageIcon(getClass().getResource("Female.png"));
   
   public mainMenu()
   {
      setTitle("MAIN MENU");
      setVisible(true);
      setBounds(340, 93, 680, 580);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);      
      
      panel.setLayout(null);
		panel.setBackground(DC);
      con.add(panel);
      
      setJMenuBar(mainBar);
		mainBar.setBackground(LSG);
      mainBar.add(menu);
      
		for(int i = 0; i < 5; ++i)
		{
   			button[i] = new JButton(content[i]); 
   			button[i].setFont(font);             
   			button[i].setToolTipText(toolTip[i]);
   			panel.add(button[i]);  
                       
         if(i == 4)
         {
   			button[i].setBounds(fldX + 112, 415, 88, fldH + 4); //375
            button[i].setVisible(false);
         }	
         else
   			button[i].setBounds(x, y, w, h);
            
   			button[i].addMouseListener(this);
   			button[i].addActionListener(this);       
   			x += 125;
         
         if(i > 0 && i < 4)
            button[i].setEnabled(false);
		}
      
		header.setBounds(150, 0, 400, 100);
		header.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		panel.add(header);
		
		imageLabel.setBounds(179, 50, 300, 350);
		panel.add(imageLabel); 
      
      rbtnMale.addActionListener(this);
      rbtnFemale.addActionListener(this);
      
      gender[0] = new JLabel(male);
      gender[1] = new JLabel(female);     
   }
	
   @Override
   public void actionPerformed(ActionEvent e)
   {
   	if(e.getSource() == button[0])
		{
			if(check)
         {
             insert();
		   }
      }
      if(e.getSource() == button[4])
      {
         save();
      }
      if(e.getSource() == btnOk)
      {
         success.setVisible(false);
         setVisible(true); // main frame
      }
      // Error pa
      
      if(rbtnMale.isSelected())
      {
         genderPanel.remove(gender[1]);
         genderPanel.add(gender[0]);
         addPic();

      }
      if(rbtnFemale.isSelected())
      {
         genderPanel.remove(gender[0]);
         genderPanel.add(gender[1]);
         addPic();      
      }
      

         invalidate();
         validate();
         repaint();
         
      
   }
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		e.getComponent().setBackground(dflt);		
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		dflt = button[0].getBackground();

      e.getComponent().setBackground(DC);         
      
	} 
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
	}		
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
      if(e.getSource() == fields[0])
         fields[0].setText("");
	}
	
	public void insert()
	{
 
		imageLabel.setVisible(false);
      
      
      for(int x = 0; x < 14; ++x)
      {
         //set button enabled
         if(x > 0 && x < 4)
            button[x].setEnabled(true);
         //display button Save
         if(x == 4)
            button[x].setVisible(true);
         
         lblInsert[x] = new JLabel(label[x]);
         fields[x] = new JTextField(40);
         
         
         
         if(x == 4)
         {
            lblInsert[x].setBounds(lblX, lblY, lblW, lblH);         
            bgInsert.add(rbtnMale);
            bgInsert.add(rbtnFemale);
            
            rbtnMale.setBounds(fldX, fldY + 4, 65, 10);
            rbtnMale.setBackground(DC);
            rbtnFemale.setBounds(fldX + 75 ,fldY + 4, 70, 10);
            rbtnFemale.setBackground(DC);
            
            panel.add(rbtnMale);
            panel.add(rbtnFemale);
            panel.add(lblInsert[x]);        
         }
         else if(x == 13)
         {
            lblInsert[x].setBounds(lblX, lblY, lblW, lblH);           
            bloodType.setBounds(fldX,fldY, 100, fldH + 2);
            
            panel.add(lblInsert[x]);
            panel.add(bloodType);
         }
         else
         {
            lblInsert[x].setBounds(lblX, lblY, lblW, lblH);
            fields[x].setBounds(fldX, fldY, fldW, fldH);  
            
            //fields[x].addMouseListener(this);
                  
            panel.add(lblInsert[x]);
            panel.add(fields[x]);         
         }
         
         lblY += 25;
         fldY += 25;
      }
         //fields[0].setText("LN   FN     MN");
           
         invalidate();
         validate();
         repaint();
		   
         check = false;
	}
	
   public void addPic()
   {
      panel.add(genderPanel);
      genderPanel.setBounds(329, 100, 277, 285); 
      genderPanel.setBackground(Color.WHITE); 
         
      invalidate();
      validate();
      repaint();             
   }
   
   public void save()
   {     
      boolean test = false;
      
      for(int a = 0; a < 13; ++a)
      {
         if(a != 4)
            if(fields[a].getText().equals(""))
            {
                test = true;
            }
      } 
      
      if(test)
        JOptionPane.showMessageDialog(null,"Empty field found!","ERROR",JOptionPane.ERROR_MESSAGE);  
      else
      {
         setVisible(false); // main frame
         
         JLabel lblSuccess = new JLabel("Successfully saved!");
         btnOk = new JButton("OK");
         
         success = new JFrame();
         Container con2 = success.getContentPane();
                  
         success.setVisible(true);
         success.setBounds(600, 300, 175, 105);
         success.setLayout(new FlowLayout());
         con2.setBackground(DC);
         
         con2.add(lblSuccess);
         con2.add(btnOk);
         con2.setFont(font);
         btnOk.addMouseListener(this);
         btnOk.addActionListener(this);     
         
         for(int z = 0; z < 13; ++z)
            fields[z].setText("");    
         
         
         
      }         

   }
 
   public static void main(String[] args)
   {
      mainMenu obj = new mainMenu();
   }   
}