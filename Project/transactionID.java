import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class transactionID
{

	public static void main(String[] args)
	{

		test t = new test();
		t.testing();


		try(FileWriter transactions = new FileWriter("transactions.txt", true); BufferedWriter newTransactions = new BufferedWriter(transactions); PrintWriter addition = new PrintWriter(newTransactions))
		{
			addition.print(t.testing());
			addition.print(", \n"); //the newline character isnt needed it just breaks up the text when adding it to the file
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	public String testing()
	{
		String transactionID = "";
		try
		{
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
			transactionID = date.format(formatter);
			LocalDateTime parsedDate = date.parse(transactionID, formatter);
			//System.out.println(transactionID);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return transactionID;
	}
}
