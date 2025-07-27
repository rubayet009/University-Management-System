package universityManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {
    JTextField search;
    JButton Result,Back;
    JTable table;
    ExaminationDetails(){
        setSize(1000,475);
        setLocation(300,100);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Result Details :");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        search=new JTextField();
        search.setBounds(50,70,150,20);
        search.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(search);


        Result=new JButton("Search");
        Result.setBounds(210,70,120,20);
        Result.setBackground(Color.WHITE);
        Result.setForeground(Color.GREEN);
        Result.addActionListener(this);
        Result.setFont(new Font("serif",Font.PLAIN,18));
        add(Result);

        Back=new JButton("Back");
        Back.setBounds(340,70,120,20);
        Back.setBackground(Color.RED);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        Back.setFont(new Font("serif",Font.PLAIN,18 ));
        add(Back);

        table=new JTable();
        //table.setFont(new Font("Tahoma",Font.PLAIN,20));

        try {
            Conn c=new Conn();
            String query="select * from student";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Result){
            setVisible(false);
            new Marks(search.getText());
        } else if (ae.getSource()==Back) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
     new ExaminationDetails();
    }
}
