package universityManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    JComboBox cbsemester,cbcourse,cbdept;
    JButton submit,cancel,pay;
    Choice crollno;
    JLabel lbltotal;
    StudentFeeForm(){
        setSize(600,700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading=new JLabel("Update Student Details:");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma", Font.ITALIC,30));
        add(heading);
        JLabel lblrollno=new JLabel("Select Roll :");
        lblrollno.setBounds(50,130,150,20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblrollno);


        crollno=new Choice();
        crollno.setBounds(210,130,150,20);
        add(crollno);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("roll"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname=new JLabel("Student Name:");
        lblname.setBounds(50,160,150,20);
        lblname.setFont(new Font("serif", Font.BOLD,20));
        add(lblname);
        JLabel name=new JLabel();
        name.setBounds(210,160,150,20);
        name.setFont(new Font("serif", Font.BOLD,20));
        add(name);
        JLabel lblfname=new JLabel("Father Name:");
        lblfname.setBounds(50,190,150,20);
        lblfname.setFont(new Font("serif", Font.BOLD,20));
        add(lblfname);
        JLabel fname=new JLabel();
        fname.setBounds(210,190,150,20);
        fname.setFont(new Font("serif", Font.BOLD,20));
        add(fname);

        String crsstring[]={"BSC","BBA","BA","MBA","MSC","PHD","Dr."};
        JLabel crs=new JLabel("Course :");
        crs.setBounds(50,220,150,20);
        crs.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(crs);

        cbcourse=new JComboBox(crsstring);
        cbcourse.setBounds(210,220,150,20);
        add(cbcourse);

        String strdept[]={"CSE","PHY","CHE","EEE","ME","CEE","SWE"};
        JLabel dept=new JLabel("Department :");
        dept.setBounds(50,250,150,20);
        dept.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(dept);

        cbdept=new JComboBox(strdept);
        cbdept.setBounds(210,250,150,20);
        add(cbdept);

        String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","7semester7","semester8"};
        JLabel lblsemester=new JLabel("Semester :");
        lblsemester.setBounds(50,280,150,20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(lblsemester);

        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(210,280,150,20);
        add(cbsemester);

        JLabel lblpay=new JLabel("Total Payable :");
        lblpay.setBounds(50,360,200,30);
        lblpay.setFont(new Font("serif", Font.BOLD,25));
        add(lblpay);
        lbltotal=new JLabel();
        lbltotal.setBounds(210,360,200,30);
        lbltotal.setFont(new Font("serif", Font.BOLD,25));
        add(lbltotal);

        submit=new JButton("Update");
        submit.setBounds(20,450,120,30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.GREEN);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        add(submit);

        cancel=new JButton("Back");
        cancel.setBounds(280,450,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20 ));
        add(cancel);

        pay=new JButton("Pay");
        pay.setBounds(150,450,120,30);
        pay.setBackground(Color.WHITE);
        pay.setForeground(Color.GREEN);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma",Font.BOLD,20));
        add(pay);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String course=(String) cbcourse.getSelectedItem();
            String semester=(String) cbsemester.getSelectedItem();
            try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from fee where corse ='"+course+"'");
                while(rs.next()){
                    lbltotal.setText(rs.getString(semester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource()==pay) {
            String course=(String) cbcourse.getSelectedItem();
            String semester=(String) cbsemester.getSelectedItem();
            String rollno=(String) crollno.getSelectedItem();
            String dept=(String) cbdept.getSelectedItem();
            String total=lbltotal.getText();
            try {
                Conn c=new Conn();
                String q="insert into clgfee values('"+rollno+"', '"+course+"', '"+dept+"', '"+semester+"', '"+total+"')";
                c.s.executeUpdate(q);
               JOptionPane.showMessageDialog(null,"College Fee Submitted successfully");
               setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
