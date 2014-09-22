
// Luis Regus
// 9/13/12
// 0
// Test Data
// Fahrenheit               Celcius              Approximation                  Difference
//
//   0 
//   25
//   66
//  -38

import java.awt.*;
import java.awt.event.*;
import java.awt.Label.*;

public class Degrees extends Frame implements ActionListener 
{
    
    private Button btnCalculate;
    private TextField tfFahrenheit = new TextField(10);
    private TextField tfCelcius = new TextField(10);
    private TextField tfApproximation = new TextField(10);
    private TextField tfDifference = new TextField(10);
    
//Processing Variables
    
    int   iFahrenheit = 0;
    float fCelcius = 0;
    float fApprox = 0;
    float fDiff = 0;

    public Degrees ()
    {
        
        setTitle ("Degrees -- Lab Sample");
        setLayout (new FlowLayout());
        
        add(new Label ("     Fahrenheit"));
        add(tfFahrenheit);
        add(new Label ("     Celcius"));
        add(tfCelcius);
        add(new Label ("     Approximation"));
        add(tfApproximation);
        
        btnCalculate = new Button("Calculate");
        add (btnCalculate);
        btnCalculate.addActionListener(new CalculateHandler(this));
        
        
        add(new Label ("The Difference is"));
        add(tfDifference);
        
        addWindowListener(new CloseWindow());
        
    } // public Degrees ()
    
  class CalculateHandler implements ActionListener
  {
      Degrees f;
      CalculateHandler(Degrees pf)
      { f = pf; }
      
      public void actionPerformed(ActionEvent Event) 
      {
          f.CalculateDegrees();
          f.repaint();
          
      }// ActionPerformed (Action Event)
  }//CalculateHandler
  
  void CalculateDegrees ()
  {
      //get TextField data
      iFahrenheit = Integer.parseInt(tfFahrenheit.getText());
      //Calculate
      fCelcius = (float) ((iFahrenheit - 32) * 5) / 9;
      fApprox = iFahrenheit / 2 - 15;
      fDiff = Math.abs(fCelcius - fApprox);
      //Show Answers
        tfCelcius.setText(String.valueOf(fCelcius));
        tfDifference.setText(String.valueOf(fDiff));
        
      
  }// End CalculateDegrees
  
  public void actionPerformed (ActionEvent event)
  {
      repaint();
      
   
  }// End ActionPerformed
  
  //--------------------------------------------------------
  
  public static void main(String[] args)
  {
      Frame DegreesWindow = new Degrees();
      DegreesWindow.setSize(150, 300);
      DegreesWindow.setVisible(true);
      
  }// End of main
  
  public class CloseWindow extends WindowAdapter
  {
      public void windowClosing(WindowEvent e)
      {
          System.exit(0);
      }
  }//End CloseWindow
}//class Degrees


