package lab3creditcards;
// Luis Regus
// 11/17/12
// 
// Test Data
//   CCNumber                IIN                 CostumerAccount#         Validate                    MII
//   5561821831007298        Mastercard          183100729                Valid Credit Card Number    Issued by banking and financial institutions                                                                                                         
//   4539431613273670        Visa                161327367                Valid Credit Card Number    Issued by banking and financial institutions                        -17.6                           2.7777786                         
//   4916229316812098        Visa                931681209                Valid Credit Card Number    Issued by banking and financial institutions          
//   5473692381900761        Mastercard          238190076                Valid Credit Card Number    Issued by banking and financial institutions
//   6011810545454122        No Issuer ID Found  054545412                Valid Credit Card Number    Issued by merchandising and banking
//   869999772624816         No Issuer ID Found  977262481                Valid Credit Card Number    Issued by telecommunications companies
//   345527907846519         American Express    790784651               Valid Credit Card Number    Issued by travel and entertainment
//   377702329237073         American Express    232923707                Valid Credit Card Number    Issued by travel and entertainment
//   112345645676564         No Issuer ID Found  564567656                Valid Credit Card Number    Issued by an airline
//   6011810545453122        INVALID CREDIT CARD NUMBER, POPS UP AN ERROR MESSAGE! 


import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;



public class CreditCards extends Frame implements ActionListener 
{
    
    private Button btnCalculate;
    private TextField tfCreditCardNumber = new TextField(19);
    private TextField tfMajorIndustryIdentifier = new TextField(25);
    private TextField tfIssuerIdentificationNumber = new TextField(20);
    private TextField tfCostumerAccountNumber = new TextField(16);
    private TextField tfCheckSum = new TextField(20);
    
    
    
//Processing Variables
    
    String sCreditCardNumber1 = new String();
    String sCreditCardNumber = new String();
    String sCostumerAccountNumber = new String();
    
    
    public CreditCards ()
    {
        
        setTitle ("Credit Card Lab");
        setLayout (new FlowLayout());
        
        add(new Label ("Credit Card Number:"));
        add(tfCreditCardNumber);
        
        btnCalculate = new Button("  Process");
        add (btnCalculate);
        btnCalculate.addActionListener(new CalculateHandler(this));
        
        add(new Label ("  Major Industry Identifier:"));
        add(tfMajorIndustryIdentifier);
        add(new Label ("  Issuer Identification Number:"));
        add(tfIssuerIdentificationNumber);
        add(new Label ("  Costumer Account Number:"));
        add(tfCostumerAccountNumber);
        add(new Label ("    Validate:"));
        add(tfCheckSum);
        
        
       addWindowListener(new CloseWindow());
        
    } // public CreditCards()
    
  class CalculateHandler implements ActionListener
  {
      CreditCards f;
      CalculateHandler(CreditCards pf)
      { f = pf; }
      
      public void actionPerformed(ActionEvent Event) 
      {
          f.testCreditCards();
          f.repaint();
          
      }// ActionPerformed (Action Event)
  }//CalculateHandler
  
  void testCreditCards()
  {
      //get TextField data
      sCreditCardNumber1 = tfCreditCardNumber.getText();
      sCreditCardNumber = sCreditCardNumber1.replaceAll("\\D", ""); //remove dashes or spaces from the credit card number
   
      //Checking the String
      sCostumerAccountNumber = sCreditCardNumber.substring(sCreditCardNumber.length() - 10, (sCreditCardNumber.length() - 1));
      tfCostumerAccountNumber.setText(sCostumerAccountNumber);
      if((sCreditCardNumber.charAt(0) == '0') || (sCreditCardNumber.charAt(0) == '1') || (sCreditCardNumber.charAt(0) == '2') || (sCreditCardNumber.charAt(0) == '3') || (sCreditCardNumber.charAt(0) == '4') || (sCreditCardNumber.charAt(0) == '5') || (sCreditCardNumber.charAt(0) == '6') || (sCreditCardNumber.charAt(0) == '7') || (sCreditCardNumber.charAt(0) == '8') || (sCreditCardNumber.charAt(0) == '9'))   //
      {
      
      if((sCreditCardNumber.charAt(0) == '1') && (isValid(sCreditCardNumber) == true) || (sCreditCardNumber.charAt(0) == '2') && (isValid(sCreditCardNumber) == true))
      {
          tfMajorIndustryIdentifier.setText("Issued by an airline");
          tfCheckSum.setText("Valid Credit Card Number");
         
          
          
          
      }else if((sCreditCardNumber.charAt(0) == '3') && (isValid(sCreditCardNumber) == true))
      {
          
          tfMajorIndustryIdentifier.setText("Issued by travel and entertainment");
          tfCheckSum.setText("Valid Credit Card Number");
          
      }else if((sCreditCardNumber.charAt(0) == '4') && (isValid(sCreditCardNumber) == true) || (sCreditCardNumber.charAt(0) == '5') && (isValid(sCreditCardNumber) == true))
      {
          
          tfMajorIndustryIdentifier.setText("Issued by banking and financial institutions");
          tfCheckSum.setText("Valid Credit Card Number");
          
      }else if((sCreditCardNumber.charAt(0) == '6') && (isValid(sCreditCardNumber) == true))
      {
          
          tfMajorIndustryIdentifier.setText("Issued by merchandising and banking");
          tfCheckSum.setText("Valid Credit Card Number");
          
      }else if((sCreditCardNumber.charAt(0) == '7') && (isValid(sCreditCardNumber) == true))
      {
          
          tfMajorIndustryIdentifier.setText("Issued by petroleum companies");
          tfCheckSum.setText("Valid Credit Card Number");
          
      }else if((sCreditCardNumber.charAt(0) == '8') && (isValid(sCreditCardNumber) == true))
      {
          
           tfMajorIndustryIdentifier.setText("Issued by telecommunications companies");
           tfCheckSum.setText("Valid Credit Card Number");
           
      }else if((sCreditCardNumber.charAt(0) == '9') && (isValid(sCreditCardNumber) == true))
      {
          
           tfMajorIndustryIdentifier.setText("Issued by national assignment");
           tfCheckSum.setText("Valid Credit Card Number");
           
      }else 
      {
          
       JOptionPane.showMessageDialog(new JFrame(), "It is not a valid Credit Card Number, please try again.", "ERROR!!",JOptionPane.ERROR_MESSAGE);   
       tfIssuerIdentificationNumber.setText("");//Clean the textbox  
       tfCreditCardNumber.setText("");
       tfMajorIndustryIdentifier.setText("");
       tfCostumerAccountNumber.setText("");
       tfCheckSum.setText("");
       
       
      }
      
      }else
      {
       
          JOptionPane.showMessageDialog(new JFrame(), "The first character must be a number, please try again.", "ERROR!!",JOptionPane.ERROR_MESSAGE);                  
          
      }
      
      if(sCreditCardNumber.charAt(0) == '4')
      {
          
          tfIssuerIdentificationNumber.setText("Visa");
          
      }else if((sCreditCardNumber.charAt(0) == '3') &&((sCreditCardNumber.charAt(1) == '4')) || (sCreditCardNumber.charAt(0) == '3') && (sCreditCardNumber.charAt('1') == '7'))
      {
          tfIssuerIdentificationNumber.setText("American Express");
          
      }else if((sCreditCardNumber.charAt(0) == '3') && (sCreditCardNumber.charAt(1) == '6'))
      {
          tfIssuerIdentificationNumber.setText("Dinner\'s Club International");
          
      }else if((sCreditCardNumber.charAt(0) == '5') && (sCreditCardNumber.charAt(1) == '1') || (sCreditCardNumber.charAt(0) == '5') && (sCreditCardNumber.charAt(1) == '5') ||(sCreditCardNumber.charAt(0) == '5') && (sCreditCardNumber.charAt(1) == '2') || (sCreditCardNumber.charAt(0) == '5') && (sCreditCardNumber.charAt(1) == '3') || (sCreditCardNumber.charAt(0) == '5') && (sCreditCardNumber.charAt(1) == '4'))
      {
          
           tfIssuerIdentificationNumber.setText("Mastercard");
      }else
      {
            tfIssuerIdentificationNumber.setText("No Issuer ID Found");
            
      }
      
      
      
      
      }// End TestCreditCards
      
      
     
  public static boolean isValid(String pccNumber)
        {
                int iSum = 0;
                boolean bAlternate = false;
                for (int i = pccNumber.length() - 1; i >= 0; i--)
                {
                        int n = Integer.parseInt(pccNumber.substring(i, i + 1));
                        if (bAlternate)
                        {
                                n *= 2;
                                if (n > 9)
                                {
                                        n = (n % 10) + 1;
                                }
                        }
                        iSum += n;
                        bAlternate = !bAlternate;
                }
                return (iSum % 10 == 0);
        }
  
  
  
  
  public void actionPerformed (ActionEvent event)
  {
      repaint();
      
   
  }// End ActionPerformed
  
  //--------------------------------------------------------
  
  public static void main(String[] args)
  {
      Frame CreditWindow = new CreditCards();
      CreditWindow.setSize(225, 400);
      CreditWindow.setVisible(true);
      
  }// End of main
  
  public class CloseWindow extends WindowAdapter
  {
      public void windowClosing(WindowEvent e)
      {
          System.exit(0);
      }
  }//End CloseWindow
}//class CreditCards


