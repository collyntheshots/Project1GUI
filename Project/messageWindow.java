
import javax.swing.JOptionPane;
import java.lang.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class messageWindow {

	public static void main (String [] args)
	{

		String currentDate = "";
		ZoneId zoneID = ZoneId.of("America/New_York");
		try
		{
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy, HH:mm:ss");
			currentDate = date.format(formatter);
			LocalDateTime parsedDate = date.parse(currentDate, formatter);
			//System.out.println(transactionID);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		JOptionPane.showMessageDialog(null,
		"Date:" + currentDate + " " + zoneID + " \nNumber of line items: \nItem# / ID / Title / Price / Qty / Disc % / Subtotal: \n1. \nOrder subtotal: \nTax rate: \nTax amount: \nOrder total: \nThanks for shopping at the Ye Old Book Shoppe!");
	}
}
