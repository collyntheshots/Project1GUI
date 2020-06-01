import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Transaction
{

	public static void main(String[] args)
	{

		Transaction t = new Transaction();
		t.transactions();

		Transaction f = new Transaction();
		f.currentDate();




		try(FileWriter transactions = new FileWriter("transactions.txt", true); BufferedWriter newTransactions = new BufferedWriter(transactions); PrintWriter addition = new PrintWriter(newTransactions))
		{
			addition.print(t.transactions());
			addition.println(f.currentDate());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	public String transactions()
	{
		String transactionID = "";
		try
		{
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter IDformat = DateTimeFormatter.ofPattern("ddMMyyyyHHmm, ");
			transactionID = date.format(IDformat);
			LocalDateTime parsedDate = date.parse(transactionID, IDformat);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return transactionID;
	}

	public String currentDate()
	{
		String currentDate = "";
		try
		{
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yy, HH:mm:ss");
			currentDate = date.format(dateFormat);
			LocalDateTime parsedDate = date.parse(currentDate, dateFormat);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return currentDate;
	}

}
