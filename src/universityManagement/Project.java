package universityManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
  Project(){
      setSize(1540,850);
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icon0.jpg"));
      Image i2=i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
//      NewInfo
      add(image);
      JMenuBar mb=new JMenuBar();
      setJMenuBar(mb);
      JMenu newInfo=new JMenu("New Info");
      newInfo.setForeground(Color.BLUE);
      mb.add(newInfo);
      setJMenuBar(mb);
//    NewInfo Under
      JMenuItem faculty=new JMenuItem("New Faculty Info");
      faculty.addActionListener(this);
      newInfo.add(faculty);
      JMenuItem student=new JMenuItem("New Student Info");
      student.addActionListener(this);
      newInfo.add(student);
//    details

      JMenu details =new JMenu("View Details");
      details.setForeground(Color.BLUE);
      mb.add(details);

      JMenuItem facultydetails=new JMenuItem("Faculty Details");
      facultydetails.addActionListener(this);
      details.add(facultydetails);
      JMenuItem studentdetails=new JMenuItem("Student Details");
      studentdetails.addActionListener(this);
      details.add(studentdetails);
      setJMenuBar(mb);
//    Leave
      JMenu leave =new JMenu("Apply Leave");
      leave.setForeground(Color.BLUE);
      mb.add(leave);

      JMenuItem facultyleave=new JMenuItem("Faculty Leave");
      facultyleave.addActionListener(this);
      leave.add(facultyleave);
      JMenuItem studentleave=new JMenuItem("Student Leave");
      studentleave.addActionListener(this);
      leave.add(studentleave);
      setJMenuBar(mb);

//    Leave Details
      JMenu leavedetails =new JMenu("Leave Details");
      leavedetails.setForeground(Color.BLUE);
      mb.add(leavedetails);

      JMenuItem facultyleavedetails=new JMenuItem("View Faculty Leave Details");
      facultyleavedetails.addActionListener(this);
      leavedetails.add(facultyleavedetails);
      JMenuItem studentleavedetails=new JMenuItem("View Student Leave Details");
      studentleavedetails.addActionListener(this);
      leavedetails.add(studentleavedetails);
      setJMenuBar(mb);

//    Exam
      JMenu exam =new JMenu("Examination");
      exam.setForeground(Color.BLUE);
      mb.add(exam);

      JMenuItem exammark=new JMenuItem("Enter exam Mark");
      exammark.addActionListener(this);
      exam.add(exammark);
      JMenuItem examresult=new JMenuItem("Exam Result");
      examresult.addActionListener(this);
      exam.add(examresult);
      setJMenuBar(mb);

//    Update
      JMenu updateInfo =new JMenu("Update");
      updateInfo.setForeground(Color.BLUE);
      mb.add(updateInfo);

      JMenuItem updatefaculty=new JMenuItem("Update Faculty Details");
      updatefaculty.addActionListener(this);
      updateInfo.add(updatefaculty);
      JMenuItem updateStudentDetail=new JMenuItem("Update Student Details");
      updateStudentDetail.addActionListener(this);
      updateInfo.add(updateStudentDetail);
      setJMenuBar(mb);

//    Fee
      JMenu feeInfo =new JMenu("Fee Details");
      feeInfo.setForeground(Color.BLUE);
      mb.add(feeInfo);

      JMenuItem feestructure=new JMenuItem("Fee Structure");
      feestructure.addActionListener(this);
      feeInfo.add(feestructure);
      JMenuItem feeform=new JMenuItem("Fee Form");
      feeform.addActionListener(this);
      feeInfo.add(feeform);
      setJMenuBar(mb);

//    Utility
      JMenu utility =new JMenu("Utility");
      utility.setForeground(Color.BLUE);
      mb.add(utility);

      JMenuItem calc=new JMenuItem("Calculator");
      utility.add(calc);
      calc.addActionListener(this);
      JMenuItem notepad=new JMenuItem("Notepad");
      utility.add(notepad);
      notepad.addActionListener(this);
      setJMenuBar(mb);

      JMenu about =new JMenu("About");
      about.setForeground(Color.BLUE);
      mb.add(about);

      JMenuItem ab=new JMenuItem("About");
      about.add(ab);
      ab.addActionListener(this);
      setJMenuBar(mb);

//    Exit
      JMenu exit =new JMenu("Exit");
      exit.setForeground(Color.RED);
      mb.add(exit);

      JMenuItem exite=new JMenuItem("Exit");
      exit.add(exite);
      exite.addActionListener(this);
      setJMenuBar(mb);

      setVisible(true);
  }
  public void actionPerformed(ActionEvent ae) {
      String msg = ae.getActionCommand();
      if (msg.equals("Exit")) {
          setVisible(false);
      } else if (msg.equals("Calculator")) {
          try {
              Runtime.getRuntime().exec("calc.exe");
          } catch (Exception e) {
          }

      } else if (msg.equals("Notepad")) {
          try {
              Runtime.getRuntime().exec("notepad.exe");
          } catch (Exception e) {
          }
      } else if (msg.equals("New Faculty Info")) {
          new UpdateTeacher();
      } else if (msg.equals("New Student Info")) {
          new AddStudent();
      }else if(msg.equals("Faculty Details")){
          new TeacherDetails();
      } else if (msg.equals("Student Details")) {
          new StudentDetails();
      } else if (msg.equals("Student Leave")) {
          new StudentLeave();
      } else if (msg.equals("Faculty Leave")) {
          new TeacherLeave();
      } else if (msg.equals("View Faculty Leave Details")) {
          new TeacherLeaveDetails();
      } else if (msg.equals("View Student Leave Details")) {
          new StudentLeaveDetails();
      } else if (msg.equals("Update Faculty Details")) {
          new UpdateTeacher();
      } else if (msg.equals("Update Student Details")) {
          new UpdateStudent();
      } else if (msg.equals("Enter exam Mark")) {
          new EnterMarks();
      } else if (msg.equals("Exam Result")) {
          new ExaminationDetails();
      } else if (msg.equals("Fee Structure")) {
          new FeeStructure();
      } else if (msg.equals("About")) {
          new About();
      } else if (msg.equals("Fee Form")) {
          new StudentFeeForm();
      }

  }
    public static void main(String[] args) {
      new Project();
    }
}
