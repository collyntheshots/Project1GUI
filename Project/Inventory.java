import java.lang.*;
import java.io.*;
import java.util.*;

public class Inventory
{
  private static String DEFAULT_FILENAME = "inventory.txt";
  private static String filename = "";
  private static String [] currentItemInfo = new String [3];

  public boolean isInInventory(String itemId)
  {
    String readLine = "";
    try
    {
      BufferedReader br = new BufferedReader(new FileReader(this.filename));
      while ((readLine = br.readLine()) != null)
      {
        String [] splitLine = readLine.split(",");

        if (splitLine[0].equals(itemId))
        {
          for (int i = 0; i < splitLine.length; i++)
            this.currentItemInfo[i] = splitLine[i];
          return true;
        }
      }
      br.close();
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
    return false;
  }

  public static String [] getCurrentItemInfo()
  {
    return currentItemInfo;
  }
  public Inventory(String filename)
  {
    this.filename = filename;
  }

  public Inventory()
  {
    this(DEFAULT_FILENAME);
  }

/*
  public static void main(String [] args)
  {
    Inventory i = new Inventory();
    if(i.isInInventory(1111))
    {
      System.out.println("you got it");
      String [] item = getCurrentItemInfo();

      for (int j = 0; j < item.length; j++)
        System.out.println(item[j]);
    }
    else
      System.out.println("Fail");
  }
*/
}
