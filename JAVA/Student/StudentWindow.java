package student;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class StudentWindow extends Frame implements ActionListener
{
    private Button btnButton;

    private TextField tfStudentName = new TextField(20);
    private TextField tfID = new TextField(10);
    private TextField tfTest1 = new TextField(10);
    private TextField tfTest2 = new TextField(10);
    private TextField tfTest3 = new TextField(10);
    private TextField tfProject = new TextField(10);
    private TextField tfavg = new TextField(10);
    
   
    //Processing variable
    studentClass studentwindowtest = new studentClass();
    DataInputStream DataFile;
    
    public StudentWindow( )
    {
        setTitle ("Student Grades");
        setLayout ( new FlowLayout( ));

        add(new Label("Student Name:"));
        add( tfStudentName);
         add(new Label("StudentID"));
        add( tfID);
        add(new Label("Test1 "));
        add( tfTest1);
        add(new Label(" Test2 "));
        add( tfTest2);
        add(new Label(" Test3 "));
        add( tfTest3);
        add(new Label("Project "));
        add( tfProject);
        add(new Label("  AVG "));
        add( tfavg);
        
    
        btnButton = new Button("Get Student");
        add (btnButton);
        btnButton.addActionListener(new ButtonHandler(this));
        openFile();

	addWindowListener( new CloseWindow( ));
    }// public StudentWindow( )


    class ButtonHandler implements ActionListener
    {
        StudentWindow f;
        ButtonHandler(StudentWindow pf)
        { f = pf;}
        public void actionPerformed (ActionEvent event)
        {
              f.buttonMethod( );
              f.repaint( );
        }// actionPerformed (ActionEvent event)
    }// ButtonHandler

    void loadStudent()
    {
       
        String Name = null;
        String ID = null;
        int igrade1 = 0;
        int igrade2 = 0;
        int igrade3 = 0;
       
        
        String OneLine;
        StringTokenizer strtok ;
        try{
        OneLine = (String)DataFile.readLine();
    {
        strtok = new StringTokenizer(OneLine);
          while (strtok.hasMoreTokens())
          {
              
              
              Name = strtok.nextToken();
              ID = strtok.nextToken();
              igrade1 = Integer.parseInt(strtok.nextToken());
              igrade2 = Integer.parseInt(strtok.nextToken());
              igrade3 = Integer.parseInt(strtok.nextToken());
              
          }
	System.out.println("Line: " + OneLine);
    }//while
        }//try
    catch (Exception e)
    {System.out.println("Error Opening file");}
       
        studentwindowtest.setName(Name);
        studentwindowtest.setID(ID);
        studentwindowtest.setTestScore1(igrade1);
        studentwindowtest.setTestScore2(igrade2);
        studentwindowtest.setTestScore3(igrade3);
        
       
        
        
        
    }
    void displayStudent()
    {
        tfStudentName.setText(studentwindowtest.getName());
        tfID.setText(studentwindowtest.getID());
        tfTest1.setText(String.valueOf(studentwindowtest.getTestScore1()));
        tfTest2.setText(String.valueOf(studentwindowtest.getTestScore2()));
        tfTest3.setText(String.valueOf(studentwindowtest.getTestScore3()));
        tfProject.setText(String.valueOf(studentwindowtest.letter(studentwindowtest.average(studentwindowtest.getTestScore1(),studentwindowtest.getTestScore2(),studentwindowtest.getTestScore3()))));
        tfavg.setText(String.valueOf(studentwindowtest.average(studentwindowtest.getTestScore1(),studentwindowtest.getTestScore2(),studentwindowtest.getTestScore3())));
        
       
        
    }

    void buttonMethod( )
    {
        //What button does
        loadStudent();
        displayStudent();
    }// buttonMethod( )

     void openFile()
    {
            try
    {
      FileInputStream instream = new FileInputStream("/home/geass/grades.txt");
	 DataFile = new DataInputStream(instream);
            }//try
    catch (Exception e)
    {System.out.println("Error Opening file");}
    }
    
    public void actionPerformed (ActionEvent event)
    {
        repaint( );
    }// actionPerformed

   
    public class CloseWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }// CloseWindow
}// class StudentWindow


