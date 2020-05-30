import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window implements ActionListener{

     private static final int WINDOW_WIDTH = 800; //pixels
     private static final int WINDOW_HEIGHT = 235; //pixels
     private static final int FIELD_WIDTH = 60;   //characters
     private static final int AREA_WIDTH = 40;   //characters

     private static final FlowLayout LAYOUT_STYLE = new FlowLayout();

     // Creation of window
     private JFrame window = new JFrame("My First GUI");

     // Creation of text fields
     private JLabel textTag = new JLabel("New text field");
     private JTextField textField = new JTextField(FIELD_WIDTH);

     private JLabel textTag2 = new JLabel("New text field 2");
     private JTextField textField2 = new JTextField(FIELD_WIDTH);

     // Creation of buttons
     private JButton procItem = new JButton("Process Item #1");
     private JButton confirmItem = new JButton("Confirm Item #1");
     private JButton viewOrder = new JButton("View Order");
     private JButton finishOrder = new JButton("Finish Order");
     private JButton newOrder = new JButton("New Order");
     private JButton exit = new JButton("Exit");

     public test()
     {
      window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = window.getContentPane();
      c.setLayout(LAYOUT_STYLE);

      // register event listeners
      /*
      procItem
      confirmItem
      viewOrder
      finishOrder
      newOrder
      exit
      */

      procItem.addActionListener(this);
      confirmItem.addActionListener(this);
      viewOrder.addActionListener(this);
      finishOrder.addActionListener(this);
      newOrder.addActionListener(this);
      exit.addActionListener(this);

      c.add(textTag);
      c.add(textField);
      c.add(textTag2);
      c.add(textField2);
      c.add(procItem);
      c.add(confirmItem);
      c.add(viewOrder);
      c.add(finishOrder);
      c.add(newOrder);
      c.add(exit);

      window.show();
     }

     public void actionPerformed(ActionEvent e)
     {
       String response1 = textField.getText();
       textField2.setText(response1);
       System.out.println(response1);
     }

    public static void main(String args[]){

      try
      {
        test gui = new test();
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
      System.out.println("Program ran successfully");
    }
}
