/**
 * @author Larissa Evaldt, Raquel Carvalho
 */

package ie.cct.objectorientedconstructs.s2017270s2017352s2017334;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import ie.cct.objectorientedconstructs.FeedFactoryInterface;
import ie.cct.objectorientedconstructs.FeedItem;

public class FeedFactory implements FeedFactoryInterface {

	@Override
	public Feed createFeed(BufferedReader in) throws IOException {
		
		ArrayList<FeedItem> items = new ArrayList<FeedItem>();
		//Create a string to store the title, which will be the first 
		//line of the file. Split string where it finds a "-"
		//Split method returns an array and we are getting position 0
		//which is the first part, the title without "- title 1" part, and .trim() to eliminate any unnecessary spaces
		String title = in.readLine().split("-")[0].trim();
        
		while(title != null) {
            //reading the second line now for the content, and doing the same as we did with title.
			String content = in.readLine().split("-")[0].trim();
			
			//create a feed item with the title and content read from the text file. 
            FeedItem item = new FeedItem(title, content);
            //add FeedItem created to our array of FeedItems
            items.add(item);
            
            //this part checks if there is another line, if there is we keep doing the same
            //if not we change the value of title to null, causing the loop to stop.
            title = (in.ready())?in.readLine().split("-")[0].trim():null;
        }
        //create and return a new feed passing the array of FeedItems read from the file.
		return new Feed(items);
	}

	@Override
	public FeedList createFeedList() {
		//method doesn't take any parameters so we just need to return a new FeedList 
		return new FeedList();
	}

}
