import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Reviews
{
	public static void main(String args[])
	{
		Document document;
		try
		{
			System.out.println("running...");
			PrintWriter writer = new PrintWriter("Reviews.txt","UTF-8");
			for(int page=10; page<=30370; page+=10)
				
			
			{
				document = Jsoup.connect("https://www.tripadvisor.com/Airline_Review-d8729060-Reviews-or" + String.valueOf(page) + "-Delta-Air-Lines#REVIEWS").get();
				Elements reviews = document.select(".noQuotes");
				for(Element review : reviews)
				{
					String str = review.text();
					str = str.replaceAll("\"","");
					writer.println(str);
				}
			}
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Done!");
	}
}
