/**
 * @author Larissa Evaldt, Patricia Correia
 */
package ie.cct.objectorientedconstructs.s2017270s2017352s2017334;

import java.util.ArrayList;

import ie.cct.objectorientedconstructs.FeedInterface;
import ie.cct.objectorientedconstructs.FeedItem;

public class Feed implements FeedInterface {
	
	ArrayList<FeedItem> feedItems;
	
	public Feed(ArrayList<FeedItem> items) {
		super();
		feedItems = items;
	}

	@Override
	public ArrayList<String> listTitles() {
		//create an array to store all titles and return later
		ArrayList<String> titles = new ArrayList<String>();
		//run through the whole FeedItem array, get the title of position i and add to the array of titles
		for (int i = 0; i < feedItems.size(); i++) {
			titles.add(feedItems.get(i).getTitle());
		}
		
		return titles;
	}

	@Override
	public FeedItem getItem(String title) {
		
		FeedItem item;
		
		for (int i = 0; i < feedItems.size(); i++) {
			//if the title of position i is equal to the one passed to us in the parameter
			//then assign it to the FeedItem created above and return it
			if(feedItems.get(i).getTitle().equals(title)) {
				item = feedItems.get(i);
				return item;
			}
		}
		//if we run through the whole arrayList and we can't find an item with same title return null
		return null;
	}

	@Override
	public int numItems() {
		return feedItems.size();
	}

	@Override
	public ArrayList<FeedItem> findItems(String keyword) {
		//create an array list store the items and return later
		ArrayList<FeedItem> item = new ArrayList<>();
		
		for (int i = 0; i < feedItems.size(); i++) {
			//check if the title contains the keyword OR content contains the keyword, if either does then we add that item to the array.
			if(feedItems.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase()) 
				|| feedItems.get(i).getContent().toLowerCase().contains(keyword.toLowerCase()) ) {
				item.add(feedItems.get(i));
			}		
		}
		//we say return item even if it doesn't find any item with the keyword given 
		//because the instructions said to return an empty collection
		return item;
		
	}

}
