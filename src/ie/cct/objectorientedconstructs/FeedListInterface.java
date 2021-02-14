/**
 * @author amilcar
 */

package ie.cct.objectorientedconstructs;

public interface FeedListInterface extends FeedInterface {

  /**
   * This method adds the given feed to the list
   * of feeds.
   * @param f the feed to add.
   */
  void addFeed(FeedInterface f);

  /**
   * This method removes the given feed from the
   * list of feeds, and returns false if the feed
   * cannot be found.
   * @param  f The feed to remove
   * @return true if the feed was removed, false if
   *         the list did not contain the feed.
   */
  boolean removeFeed(FeedInterface f);

}
