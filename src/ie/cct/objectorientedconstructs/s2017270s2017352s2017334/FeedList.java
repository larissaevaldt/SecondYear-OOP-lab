/**
 * @author Larissa Evaldt, Patricia Correia, Raquel Carvalho
 */
package ie.cct.objectorientedconstructs.s2017270s2017352s2017334;

import java.util.ArrayList;

import ie.cct.objectorientedconstructs.FeedInterface;
import ie.cct.objectorientedconstructs.FeedItem;
import ie.cct.objectorientedconstructs.FeedListInterface;

public class FeedList implements FeedListInterface {
	
	ArrayList<Feed> feedList = new ArrayList<Feed>();
	
	//we didn't create a constructor here because seeing the test
	//file we noticed that a feedList doesn't require any parameters to be created
	//and in java if you don't create a constructor it automatically
	//creates an empty one for you.

	@Override
	public ArrayList<String> listTitles() {
		
		ArrayList<String> titles = new ArrayList<String>();
		
		for (int i = 0; i < feedList.size(); i++) {
			//this part I got help from the classmate Davi Moraes
			//which gave the tip to call the method already created in the other class
			//instead of using two for loops. And since listTitles return an array and not only
			//an item, we can't use add, we use then add all to add the entire array returned.
			titles.addAll(feedList.get(i).listTitles());
		}
		
		return titles;
		
	}

	@Override
	public FeedItem getItem(String title) {
		FeedItem item;
		
		//here we need two for loops because we have an arrayList inside another
		//and we are in the feedList, we need to run through all feeds/get in the feeds
		//to access each feedItem and check weather the title passed in the parameter exists or not
		for (int i = 0; i < feedList.size(); i++) {
			
			for(int j=0; j < feedList.get(i).feedItems.size(); j++) {
				if(feedList.get(i).feedItems.get(j).getTitle().equals(title)) {
				item = feedList.get(i).feedItems.get(j);
				return item;
				}
			}
		}
		
		return null;
	}

	

	@Override
	public int numItems() {
		int total = 0;
		
		for (int i = 0; i < feedList.size(); i++) {
			//get the size of feedItems in position i and add to the total
			total+=feedList.get(i).feedItems.size();

		}
		
		return total;
	}

	@Override
	public ArrayList<FeedItem> findItems(String keyword) {
		ArrayList<FeedItem> item = new ArrayList<>();
		
		for (int i = 0; i < feedList.size(); i++) {
			item.addAll(feedList.get(i).findItems(keyword));
		}
		
		return item;
	}

	@Override
	public void addFeed(FeedInterface f) {
		//add the FeedInterface passed in the parameters to the feed list casting it to Feed
		feedList.add((Feed) f);

	}

	@Override
	public boolean removeFeed(FeedInterface f) {
	//for loop to run through the whole array	
		for (int i = 0; i < feedList.size(); i++) {
			//check if the item being checked is equal to the one passed in the parameter
			//if it is remove it and return true.
			if(feedList.get(i).equals(f)) {
				feedList.remove(feedList.get(i));
				return true;
			}	
		}
		//if after checking the whole array none of the items is equal to the one passed just return false
		return false;
	}
	
}

