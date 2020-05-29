import javax.swing.*;
public class test{

     private static final int WINDOW_WIDTH = 410; //pixels
     private static final int WINDOW_HEIGHT = 235; //pixels
     private static final int FIELD_WIDTH = 20;   //characters
     private static final int AREA_WIDTH = 40;   //characters

     public test()
     {
      JFrame frame = new JFrame("My First GUI");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      JButton press = new JButton("Press");
      JButton newButton = new JButton("New");
      frame.getContentPane().add(press); // Adds Button to content pane of frame
      frame.getContentPane().add(newButton);
      frame.setVisible(true);
     }




    public static void main(String args[]){

      test gui = new test();

    }
}
