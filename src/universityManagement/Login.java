package universityManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField inputname,passin;
    //JPasswordField passin;
    Login(){
     getContentPane().setBackground(Color.YELLOW);
     setLayout(null);
     JLabel lblusername=new JLabel("Username");
     lblusername.setBounds(40,20,100,20);
     add(lblusername);
      inputname=new JTextField();
     inputname.setBounds(150,20,150,20);
     add(inputname);
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,20);
        add(pass);
        passin=new JPasswordField();
        passin.setBounds(150,70,150,20);
        add(passin);

        login=new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);
        login.addActionListener(this);
        cancel=new JButton("Cancel");
        cancel.setBounds(200,140,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        cancel.addActionListener(this);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,20,100,100);
        add(image);
     setSize(600,300);
     setLocation(500,250);
     setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
      String username=inputname.getText();
      String password=passin.getText();
      String query="select * from login where username='"+username+"' and password='"+password+"'";
      try {
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery(query);
          if(rs.next()){
              setVisible(false);
              new Project();
          }else {
              JOptionPane.showMessageDialog(null,"FUCK YOU");
              setVisible(false);
          }
      c.s.close();

      }catch (Exception e){
          e.printStackTrace();
      }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
}

    public static void main(String[] args) {
     new Login();
    }
}
