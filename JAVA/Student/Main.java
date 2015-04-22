package student;
/* Luis Regus
   12/13/12
   
 * The program displays a -1 if a test has not been taken.
 * The project is an average converted to a letter grade.
 * TEST DATA
 * Student Name    ID   Test1   Test2   Test3   Project  AVG
 *     Luis      27783   78       98     89        B     88.333336
 *     John      87890   89       -1     88        F     59.0
 *     Stwe      89927   -1       84     96        D     60.0
 
 */

import java.awt.*;
import java.awt.event.*;

public class Main
{
    public static void main(String[] args)
    {
               
        Frame StudentWindowtest = new StudentWindow( );
        StudentWindowtest.setSize(200,500);
        StudentWindowtest.setVisible( true );
    }
}
