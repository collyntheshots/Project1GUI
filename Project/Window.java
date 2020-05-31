import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window implements ActionListener
{
  private static final int WINDOW_WIDTH = 800; //pixels
  private static final int WINDOW_HEIGHT = 235; //pixels
  private static final int FIELD_WIDTH = 50;   //characters
  private static final int AREA_WIDTH = 40;   //characters

  private static final FlowLayout LAYOUT_STYLE = new FlowLayout();

  private Inventory inventory;

  private int itemNum = 1;
  private int numOfItems = 0;
  //private String [][] itemData;

  // Creation of window
  private JFrame window = new JFrame("Ye Old Book Shoppe");

  // Creation of text fields
  private JLabel numItemsTag = new JLabel("Enter the Number of Items");
  private JTextField numItemsField = new JTextField(FIELD_WIDTH);

  private JLabel bookIdTag = new JLabel("             Book ID for item #" + itemNum);
  private JTextField bookIdField = new JTextField(FIELD_WIDTH);

  private JLabel quantityTag = new JLabel("           Quantity for item #" + itemNum);
  private JTextField quantityField = new JTextField(FIELD_WIDTH);

  private JLabel itemInfoTag = new JLabel("                          Item #" + itemNum + " info");
  private JTextField itemInfoField = new JTextField(FIELD_WIDTH);

  private JLabel subtotalTag = new JLabel("Order Subtotal for " + numOfItems + " items");
  private JTextField subtotalField = new JTextField(FIELD_WIDTH);

  // Creation of buttons
  private JButton procItem = new JButton("Process Item #1");
  private JButton confirmItem = new JButton("Confirm Item #1");
  private JButton viewOrder = new JButton("View Order");
  private JButton finishOrder = new JButton("Finish Order");
  private JButton newOrder = new JButton("New Order");
  private JButton exit = new JButton("Exit");

  public Window(Inventory i)
  {
    this.inventory = i;
    //setItemData();
    window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // register event listeners
    procItem.addActionListener(this);

    confirmItem.setEnabled(false);
    confirmItem.addActionListener(this);

    viewOrder.setEnabled(false);
    viewOrder.addActionListener(this);

    finishOrder.setEnabled(false);
    finishOrder.addActionListener(this);

    newOrder.addActionListener(this);
    exit.addActionListener(this);

    // add buttons
    Container c = window.getContentPane();
    c.setLayout(LAYOUT_STYLE);

    c.add(numItemsTag);
    c.add(numItemsField);

    c.add(bookIdTag);
    c.add(bookIdField);

    c.add(quantityTag);
    c.add(quantityField);

    c.add(itemInfoTag);
    c.add(itemInfoField);

    c.add(subtotalTag);
    c.add(subtotalField);

    c.add(procItem);
    c.add(confirmItem);
    c.add(viewOrder);
    c.add(finishOrder);
    c.add(newOrder);
    c.add(exit);

    window.setVisible(true);
  }

/*
  private void setItemData()
  {
    //"22222"; "\"W Is For Wasted - Sue Grafton\", 9.95"
    String [] item = {"22222", "11221122"};
    itemData[0][0] = item[0];
  }
*/

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == procItem)
    {
      // Line need fixing *********************************************************************************
      if (inventory.isInInventory(bookIdField.getText()) && (Integer.parseInt(quantityField.getText()) > 0))
      {
        itemNum++;
        procItem.setText("Process Item #" + itemNum);
        confirmItem.setEnabled(true);
        procItem.setEnabled(false);
      }
    }
    else if (e.getSource() == confirmItem)
    {
      confirmItem.setEnabled(false);
      procItem.setEnabled(true);
    }
    else if (e.getSource() == newOrder)
    {
      itemNum = 1;

      numItemsField.setText("");
      bookIdField.setText("");
      quantityField.setText("");
      itemInfoField.setText("");
      subtotalField.setText("");

      procItem.setText("Process Item #" + itemNum);
      confirmItem.setText("Confirm Item #" + itemNum);
      bookIdTag.setText("             Book ID for item #" + itemNum);
      quantityTag.setText("           Quantity for item #" + itemNum);
      itemInfoTag.setText("                          Item #" + itemNum + " info");
      confirmItem.setEnabled(false);
      procItem.setEnabled(true);
    }
    else if (e.getSource() == exit)
    {
      System.exit(0);
    }
  }

  public static void main(String args[])
  {
    try
    {
      Inventory i = new Inventory();
      Window gui = new Window(i);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
      System.out.println("Program ran successfully");
  }
}
