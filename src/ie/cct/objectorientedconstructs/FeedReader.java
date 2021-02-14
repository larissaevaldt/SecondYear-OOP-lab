/**
 * @author amilcar
 */

package ie.cct.objectorientedconstructs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import ie.cct.objectorientedconstructs.s2017270s2017352s2017334.FeedFactory;
import ie.cct.objectorientedconstructs.s2017270s2017352s2017334.FeedList;


public class FeedReader {

  public static void main(String[] args) throws IOException {
    FeedFactoryInterface factory = new FeedFactory();
    String file = "//Users//larissaevaldt//Downloads//test.rss";
    BufferedReader in = new BufferedReader(new FileReader(file));
    FeedInterface feed = factory.createFeed(in);
    
    System.out.println("=== Trying find items ===");
    
    Collection <FeedItem> feedItems = feed.findItems("less");
        
    for(FeedItem items : feedItems) {
      System.out.println(items.getTitle());
      System.out.println(items.getContent());
    }
    
    System.out.println("=== Trying get items ===");
    
    FeedItem item = feed.getItem("Breaking news");
    System.out.println(item.getTitle());
    System.out.println(item.getContent());
    
    System.out.println("=== Trying get titles ===");
    Collection <String> titles = feed.listTitles();
    for (String title : titles){
    	System.out.println(title);
    	
    }
    
    System.out.println("=== Trying num of items ===");
    System.out.println(feed.numItems());
    
    System.out.println("");
    System.out.println("=== Now LISTS ===");
    
    FeedListInterface fl = new FeedList();
    fl.addFeed(feed);
    fl.addFeed(feed);
    
    System.out.println("=== Trying Titles ===");
    Collection<String> titlesFromList = fl.listTitles();
    for (String title : titlesFromList){
    	System.out.println(title);
    	
    }
    
    System.out.println("=== Trying get item ===");    
    FeedItem item2 = fl.getItem("Even less important news");
    System.out.println(item2.getTitle());
    System.out.println(item2.getContent());
    
    System.out.println("===Trying num items");
    System.out.println(fl.numItems());
    
    System.out.println("===Trying find items===");
    Collection<FeedItem> foundItemsFromList = fl.findItems("some");
    for (FeedItem f : foundItemsFromList){
    	System.out.println(f.getTitle());
    	System.out.println(f.getContent());
    	
    }
    
  }
  
}
