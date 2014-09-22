package student;

//Sample of a basic data class

public class studentClass
{
    //properties
    String sstudentName;
    String sstudentID;
    String sproject;
    int itestScore1;
    int itestScore2;
    int itestScore3;
    float favg;    
    
    //methods
    studentClass()
    {  //default constructor
        sstudentName = new String();
        sstudentID = new String();
        sproject = "I";
        itestScore1 = -1;
        itestScore2 = -1;
        itestScore3 = -1;
        favg = 0;
        
    }
    
    studentClass(String pstudentName,String pstudentID,String plettergrade, int ptest1, int ptest2, int ptest3, float pavg)
    {  //secondary constructor
        sstudentName = new String(pstudentName);
        sstudentID = new String(pstudentID);
        sproject = plettergrade;
        itestScore1 = ptest1;
        itestScore2 = ptest2;
        itestScore3 = ptest3;
        favg = pavg;
    }
    
    void displayStudent()
    {
        System.out.println("Student Name: " +sstudentName+ " ID: "+sstudentID+ "Project: "+ sproject +"Test Score 1: "+itestScore1 +
                " Test Score 2: " +itestScore2 + " Test Score 3: "+ itestScore3 + " avg: " + favg);
    }
    
    //get and set sample methods
    String getName()
    {
        return sstudentName;
    }
    
    void setName(String pname) 
    {
        sstudentName = pname;
    }
    
    String getID()
    {
        return sstudentID;
    }
    
    void setID(String pID)
    {
        sstudentID = pID;
    }
    
        
    int getTestScore1()
    {
        return itestScore1;
    }

    void setTestScore1(int pScore1)
    {
        itestScore1 = pScore1;
    }
    
    int getTestScore2()
    {
        return itestScore2;
    }

    void setTestScore2(int pScore2)
    {
        itestScore2 = pScore2;
    }
    
    int getTestScore3()
    {
        return itestScore3;
    }

    void setTestScore3(int pScore3)
    {
        itestScore3 = pScore3;
    }
    
    String getproject()
    {
        return sproject;
    }
    
    void setproject(String pproject)
    {
        sproject = pproject;
    }

    public float average(int ptestscore1, int ptestscore2, int ptestscore3)
    {
        
        if(ptestscore1 == -1)
        {
            
            ptestscore1 = 0;
            float avg = 0f;
            avg = (float)(ptestscore1 + ptestscore2 + ptestscore3) / 3;
        
            return avg;   
        }else if(ptestscore2 == -1)
        {
            ptestscore2 = 0;
                   
            float avg = 0f;
            avg = (float)(ptestscore1 + ptestscore2 + ptestscore3) / 3;
                   
            return avg;
 
                }else if(ptestscore3 == -1)
                {
                  ptestscore3 = 0;
                  
                  float avg = 0f;
                  avg = (float)(ptestscore1 + ptestscore2 + ptestscore3) / 3;
        
                  return avg;
                    
                }else 
                {
                   
                    float avg = 0f;
                    avg = (float)(ptestscore1 + ptestscore2 + ptestscore3) / 3;
        
                    return avg;
                }
        
        
        
    }
    
    public char letter(float paverage)
    {
        char cAletter = 'A';
        char cBletter = 'B';
        char cCletter = 'C';
        char cDletter = 'D';
        char cFletter = 'F';
        
        if ((paverage >= 90) && (paverage <= 100))
        {
            
            return cAletter;
            
        }else if((paverage >= 80) && (paverage <= 89))
        {
 
            return cBletter;
            
        }else if((paverage >=70) && (paverage <= 79))
        {
                     
            return cCletter;
            
        }else if((paverage >=60) && (paverage <= 69)) 
        {
         
            
            return cDletter;
            
        }else 
        {
            
            return cFletter;
            
        }
        
        
    }  
    
    public boolean isPassing() 
    {
        boolean bisPassing = false;
        
        if(favg > 60)
        {
            
            bisPassing = true;
            
        }else 
        {
            
            bisPassing = false;
            
        }
        
        return bisPassing;
        
        
    }
    
                
   
}
