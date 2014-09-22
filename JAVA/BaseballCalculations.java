package lab1luisregus;


// Luis Regus
// 10/8/12
// Lab 1
// Test Data
// When atbats is 0 averages are 0.
// When Hits,walks,singles,triples,doubles or homers are less than at bats. pop ups an error message.
/*if the player have not bat, the it does not have any single or doubles etc... that is why i set those parameters. Assuming that 
 the data we are entering is for players with a believable stat, because we do not have old stats in a database
 we can not assume that the player has previous stats.
*/
//                      ----DATA INPUT----                                                                ----EXPECTED RESULT-----
// Hits  Walks  HitByPitch  AtBats  Sacflies Singles  Doubles  Triples  Homers   SacrificeFlies  |   OBAS           OnBaseAverage    SluggingPercentage    BattingAverage
//                                                                                               |
//                             0--->(Pop up error messages, no zero atbats)                      |
// -1--->(Pop up error messages, no negatives numbers allowed)                                   |
//  89     50       8         422               12         18        0        21           0     |0.09579384           0.30625           0.31279621             0.21090047
//
//
//


import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class BaseballCalculations extends Frame implements ActionListener 
{
    
    private Button btnCalculate;
    private TextField tfHits = new TextField(10);
    private TextField tfWalks = new TextField(10);
    private TextField tfHitByPitch = new TextField(10);
    private TextField tfAtBats = new TextField(10);
    private TextField tfSacFlies = new TextField(10);
    private TextField tfSingles = new TextField(10);
    private TextField tfDoubles = new TextField(10);
    private TextField tfTriples = new TextField(10);
    private TextField tfHomers = new TextField(10);
    private TextField tfOBAS = new TextField(10);
    private TextField tfOnBaseAvg = new TextField(10);
    private TextField tfSluggingPercentage = new TextField(10);
    private TextField tfBattingAvg = new TextField(10);
//Processing Variables
    
    float fOBAS = 0;
    float fOnBaseAvg = 0;
    float fSluggingPercentage = 0;
    float fBattingAvg = 0;
    int   iHits = 0;
    int   iWalks = 0;
    int   iHitByPitch = 0;
    int   iAtBats = 0;
    int   iSacFlies = 0;
    int   iTotalBases = 0;
    int   iSingles = 0;
    int   iDoubles = 0;
    int   iTriples = 0;
    int   iHomers = 0;
    
    public BaseballCalculations ()
    {
        
        setTitle ("Baseball Calculations -- Lab1");
        setLayout (new FlowLayout(FlowLayout.TRAILING));
        
        add(new Label ("Hits"));
        add(tfHits);
        add(new Label ("Walks"));
        add(tfWalks);
        add(new Label ("Hit By Pitch"));
        add(tfHitByPitch);
        add(new Label ("AtBats"));
        add(tfAtBats);
        add(new Label ("SacFlies"));
        add(tfSacFlies);
        add(new Label ("Singles"));
        add(tfSingles);
        add(new Label ("Doubles"));
        add(tfDoubles);
        add(new Label ("Triples"));
        add(tfTriples);
        add(new Label ("Homers"));
        add(tfHomers);



        btnCalculate = new Button("Calculate");
        add (btnCalculate);
        btnCalculate.addActionListener(new CalculateHandler(this));
        
        
        add(new Label ("OBAS"));
        add(tfOBAS);
        add(new Label ("On Base Average"));
        add(tfOnBaseAvg);
        add(new Label ("Slugging Percentage"));
        add(tfSluggingPercentage);
        add(new Label ("Batting Average"));
        add(tfBattingAvg);
        
        addWindowListener(new CloseWindow());
        
    } // public Degrees ()
    
  class CalculateHandler implements ActionListener
  {
      BaseballCalculations f;
      CalculateHandler(BaseballCalculations pf)
      { f = pf; }
      
      public void actionPerformed(ActionEvent Event) 
      {
          f.CalculateAverages();
          f.repaint();
          
      }// ActionPerformed (Action Event)
  }//CalculateHandler
  
  void CalculateAverages ()
  {
      //get TextField data
      iHits = Integer.parseInt(tfHits.getText());
      iWalks = Integer.parseInt(tfWalks.getText());
      iHitByPitch = Integer.parseInt(tfHitByPitch.getText());
      iAtBats = Integer.parseInt(tfAtBats.getText());
      iSacFlies = Integer.parseInt(tfSacFlies.getText());
      iSingles = Integer.parseInt(tfSingles.getText());
      iDoubles = Integer.parseInt(tfDoubles.getText());
      iTriples = Integer.parseInt(tfTriples.getText());
      iHomers = Integer.parseInt(tfHomers.getText());
      //Calculate
    if((iHits < iAtBats) && (iSingles < iAtBats) && (iDoubles < iAtBats) && (iTriples < iAtBats) && (iHomers < iAtBats)){ // if the variables iHits iSingles iDoubles iTriples and Homers are less than the variable iAtBats runs the program
      
      if(iHits >= 0) // if the input data is  greater or equals zero then the program runs 
      {
         if(iWalks >= 0)
          {
            if(iHitByPitch >= 0)
               {
                 if(iAtBats > 0) // the iAtBats variable can not 0
                    {
                        if(iSacFlies >= 0)
                          {
                              
                                    if(iSingles >= 0)
                                      {
                                          if(iDoubles >= 0)
                                             {
                                                 if(iTriples >= 0)
                                                   {
                                                       if(iHomers >= 0)
                                                        {
                                                           // Calculations
                                                           iTotalBases = (1 * iSingles) + (2 * iDoubles) + (3 * iTriples) + (4 * iHomers);
                                                           fOnBaseAvg =((float)iHits + iWalks + iHitByPitch) / (iAtBats + iWalks + iHitByPitch + iSacFlies);
                                                           fSluggingPercentage = ((float)iTotalBases) / iAtBats;
                                                           fOBAS =  ((float)fOnBaseAvg) * fSluggingPercentage;
                                                           fBattingAvg =((float)iHits) / iAtBats;
          
                                                         }else{
                                                           
                                                           JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
                                                       
                                                       } // Pop ups an error message when the data is a negative number or zero
                                                   }else{
                                                     
                                                     JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
                                                 
                                                 }
                                             }else{
                                              
                                              JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
                                          
                                          }
                                      }else{
                                        
                                        JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
                                    
                                    }
                                
                          }else{
                            
                            JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
                        
                        }
                    }else{
                     
                     JOptionPane.showMessageDialog(new JFrame(), "At bats can not be zero  or Negative Try again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
                 
                 }
               }else{
                
                JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
            
            }
          }else{
             
             JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
         
         }
      }else
      {
      
          JOptionPane.showMessageDialog(new JFrame(), "No Negative Numbers Try Again!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
          
      }
    }else{
    
        JOptionPane.showMessageDialog(new JFrame(), "Hey! Hits,singles,doubles,triples and homers Can Not Be Greater than At Bats!, Try Again.", "ERROR!!",JOptionPane.ERROR_MESSAGE);
    
    }// Pop ups an error message when hit are more that the At BAts
      
      //Show Answers
        tfOBAS.setText(String.valueOf(fOBAS));
        tfOnBaseAvg.setText(String.valueOf(fOnBaseAvg));
        tfSluggingPercentage.setText(String.valueOf(fSluggingPercentage));
        tfBattingAvg.setText(String.valueOf(fBattingAvg));
      
  }// End CalculateDegrees
  
    
  
  public void actionPerformed (ActionEvent event)
  {
      repaint();
      
   
  }// End ActionPerformed
  
  //--------------------------------------------------------
  
  public static void main(String[] args)
  {
      
      Frame DegreesWindow = new BaseballCalculations();
      DegreesWindow.setSize(180, 650);
      DegreesWindow.setResizable(true);
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

