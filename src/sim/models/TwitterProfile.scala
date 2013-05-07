package sim.models

import sim._

import scala.collection.mutable.ListBuffer
import scala.util.Random

class TwitterProfile(val m: SimModel, val o:Observer, val p: People)
{
  var following = ListBuffer[TwitterProfile]()
  var tweets = ListBuffer[Tweet]()
  var followers = ListBuffer[TwitterProfile]()
  
  def reset() {
      p.twitter = false
      following = ListBuffer[TwitterProfile]()
      tweets = ListBuffer[Tweet]()
      followers = ListBuffer[TwitterProfile]()
  }

  def run() {
    tweet()

    if((Random.nextInt(100) - p.pt.twi_pref) < 0) {

      if(p.circle.length > 0) {

        val profileView = Random.shuffle(p.circle) take Random.nextInt(p.circle.length)

        // follow a random circle member
        for (people <- profileView; if (people.twitter && !following.exists(x => x == people.twitterProfile))) {
          follow(people.twitterProfile)
        }

        for(people <- profileView; if !people.twitter) {
          sendTwitterInvitation(people)
        }

        // unfollow someone
        if(Random.nextInt()%5 == 0 && following.length > 0) {
          unfollow(following(Random.nextInt(following.length)))
        }
      }
    }
  }

  // ---------------------------------
  // Twitter profile possible actions
  // ---------------------------------
  
  def follow(t: TwitterProfile) {
    //println(p+" now follow "+t.p)
    following += t
    t.followers += this
  }

  def unfollow(t : TwitterProfile) {
    //println(p + " stops following "+t.p)
    following -= t
    t.followers -= this
  }

  def tweet() {
    //println(p + " Tweets!")
    tweets += new Tweet(this)
  }
  
  def deleteTweet(t: Tweet) {
    //println(p + "deletes his tweet")
    tweets -= t
  }

  def sendTwitterInvitation(pp: People) {
    println(p + " invited " + pp + " on twitter")
    pp.twitterInvitations += new TwitterInvitation(pp) 
    o.notifyTwitterInvitation(pp)
  }
}
