package universityManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class AddTeacher extends JFrame implements ActionListener {
    Random r=new Random();
    long first4= Math.abs((r.nextLong()%9000)+1000L);
    JTextField tfname,tffname,address,phone,tfemail,tfssc,tfhsc,tfnid;
    JLabel tfimplyid;
    JDateChooser birth;
    JComboBox qualification,tfdeptname;
    JButton submit,cancel;
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        JLabel heading=new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        JLabel lblname=new JLabel("Teacher Name:");
        lblname.setBounds(30,150,150,20);
        lblname.setFont(new Font("serif", Font.BOLD,20));
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(220,150,300,20);
        add(tfname);

        JLabel fathername=new JLabel("Father's Name:");
        fathername.setBounds(30,180,150,20);
        fathername.setFont(new Font("serif", Font.BOLD,20));
        add(fathername);
        tffname=new JTextField();
        tffname.setBounds(220,180,300,20);
        add(tffname);

        JLabel roll=new JLabel("Teacher ID:");
        roll.setBounds(30,210,150,20);
        roll.setFont(new Font("serif", Font.BOLD,20));
        add(roll);
        tfimplyid =new JLabel("1001"+first4);
        tfimplyid.setBounds(220,210,300,20);
        tfimplyid.setFont(new Font("serif", Font.BOLD,20));
        add(tfimplyid);

        JLabel db=new JLabel("Date of Birth:");
        db.setBounds(30,240,150,20);
        db.setFont(new Font("serif", Font.BOLD,20));
        add(db);
        birth=new JDateChooser();
        birth.setBounds(220,240,150,20);
        add(birth);

        JLabel addr=new JLabel("Address:");
        addr.setBounds(30,300,150,20);
        addr.setFont(new Font("serif", Font.BOLD,20));
        add(addr);
        address=new JTextField();
        address.setBounds(220,300,300,20);
        add(address);

        JLabel phn=new JLabel("Phone:");
        phn.setBounds(30,270,150,20);
        phn.setFont(new Font("serif", Font.BOLD,20));
        add(phn);
        phone=new JTextField();
        phone.setBounds(220,270,300,20);
        add(phone);

        JLabel emil=new JLabel("Email:");
        emil.setBounds(30,330,150,20);
        emil.setFont(new Font("serif", Font.BOLD,20));
        add(emil);
        tfemail=new JTextField();
        tfemail.setBounds(220,330,300,20);
        add(tfemail);

        JLabel ssc=new JLabel("SSC GPA:");
        ssc.setBounds(30,360,150,20);
        ssc.setFont(new Font("serif", Font.BOLD,20));
        add(ssc);
        tfssc=new JTextField();
        tfssc.setBounds(220,360,300,20);
        add(tfssc);

        JLabel hsc=new JLabel("HSC GPA:");
        hsc.setBounds(30,390,150,20);
        hsc.setFont(new Font("serif", Font.BOLD,20));
        add(hsc);
        tfhsc=new JTextField();
        tfhsc.setBounds(220,390,300,20);
        add(tfhsc);

        JLabel nid=new JLabel("NID NO:");
        nid.setBounds(30,420,150,20);
        nid.setFont(new Font("serif", Font.BOLD,20));
        add(nid);
        tfnid=new JTextField();
        tfnid.setBounds(220,420,300,20);
        add(tfnid);

        JLabel hedu=new JLabel("Qualification:");
        hedu.setBounds(30,450,150,20);
        hedu.setFont(new Font("serif", Font.BOLD,20));
        add(hedu);
        String coursename[]={"BSC","BBA","BA","MSC","MBA","PHD"};
        qualification =new JComboBox(coursename);
        qualification.setBackground(Color.WHITE);
        qualification.setBounds(220,450,300,20);
        add(qualification);

        JLabel dept=new JLabel("Department:");
        dept.setBounds(30,480,150,20);
        dept.setFont(new Font("serif", Font.BOLD,20));
        add(dept);
        String deptname[]={"CSE","SWE","EEE","ME","IPE","ANTHOPOLOGY","BBA","FET","FES","CEE","CEP","ENG","BNG","GEE","PHY","CHE"};
        tfdeptname =new JComboBox(deptname);
        tfdeptname.setBackground(Color.WHITE);
        tfdeptname.setBounds(220,480,300,20);
        add(tfdeptname);

        submit=new JButton("Submit");
        submit.setBounds(200,550,120,30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.GREEN);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(500,550,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20 ));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name= tfname.getText();
            String fname= tffname.getText();
            String id= tfimplyid.getText();
            String date= ((JTextField)birth.getDateEditor().getUiComponent()).getText();
            String ph= phone.getText();
            String addrs= address.getText();
            String email= tfemail.getText();
            String sscgpa=tfssc.getText();
            String hscgpa=tfhsc.getText();
            String nid=tfnid.getText();
            String qualification=(String)(this.qualification.getSelectedItem());
            String department=(String)(tfdeptname.getSelectedItem());

            try {
                String query="insert into teacher values('"+name+"', '"+fname+"', '"+id+"', '"+date+"', '"+ph+"', '"+addrs+"', '"+email+"', '"+sscgpa+"', '"+hscgpa+"', '"+nid+"', '"+qualification+"', '"+department+"')";
                Conn con=new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher details inserted successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else setVisible(false);

    }
    public static void main(String[] args) {
        new AddTeacher();
    }
}
