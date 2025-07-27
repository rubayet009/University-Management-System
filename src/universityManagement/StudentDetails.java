package universityManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDetails extends JFrame implements ActionListener {
    Choice crollno;
    JTable table;
    JButton search,print,update,add,cancel;
    StudentDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        search =new JButton("Search");
        search.setBounds(140,20,80,20);
        search.addActionListener(this);
        add(search);


        crollno=new Choice();
        crollno.setBounds(20,20,100,20);
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
        table =new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,800);
        add(jsp);



        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update =new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        add =new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel =new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
           String query="select * from student where roll = '"+crollno.getSelectedItem()+"'";
           try {
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
           } catch (Exception e) {
               e.printStackTrace();
           }
        }else if(ae.getSource()==print){
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==add) {
            new AddStudent();
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        } else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateStudent();
        }

    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
