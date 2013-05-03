import scala.collection.mutable.ListBuffer
import scala.util.Random

class TwitterProfile(val m: SimModel, val o:Observer, val p: People)
{
  var following = ListBuffer[TwitterProfile]()
  var tweets = ListBuffer[Tweet]()

  
  def idle() {
    if (p.twitter) {
      tweet()
      // follow a random circle member
      for (people <- p.circle; if (people.twitter && !following.exists(x => x == people.twitterProfile))) {
        follow(people.twitterProfile)
      }
      // unfollow someone
      if(Random.nextInt()%5 == 0 && following.length > 0)
        unfollow(following(Random.nextInt(following.length)))
      }

    m.wait(1.0) {
      idle()
    }
  }
  def follow(t: TwitterProfile) {
    println(p+" now follow "+t.p)
    following += t
  }

  def unfollow(t : TwitterProfile) {
    println(p + " stops following "+t.p)
    following -= t
  }

  def tweet() {
    println(p + " Tweets!")
    tweets += new Tweet(this)
  }
  
  def deleteTweet(t: Tweet) {
    println(p + "deletes his tweet")
    tweets -= t
  }

  def invite(pp: People) {
    println(p + " invited " + pp + "on twitter")
    p.twitterInvitations += new TwitterInvitation(pp) 
  }
}
