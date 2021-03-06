package sim.models
import scala.collection.mutable.ListBuffer
import scala.util.Random
import sim._

class YoutubeProfile(val m: SimModel, val o: Observer, val p: People)
{
  var subscriptions = ListBuffer[YoutubeProfile]()
  var videos = ListBuffer[YoutubeVideo]()
  var subscribers = ListBuffer[YoutubeProfile]()
  var feed = 0  

  def reset()
  {
    p.youtube = false
    subscribers = ListBuffer[YoutubeProfile]()
    subscriptions = ListBuffer[YoutubeProfile]()
    videos = ListBuffer[YoutubeVideo]()
    }
  
  def run() {

    addVideo()
    if(((Random.nextInt(100) - p.pt.yt_pref) < 0) && videos.length > 0) {
      // remove a random video
      videos -= videos(Random.nextInt(videos.length ))
    }

    if(((Random.nextInt(100) - p.pt.yt_pref) < 0) && subscriptions.length > 0 ) {
      /// comment a random video from our subscribtions
      var s = subscriptions(Random.nextInt(subscriptions.length ))
      if(s.videos.length > 0)
        commentVideo(s.videos(Random.nextInt(s.videos.length)))
    }

    if((Random.nextInt(100) - p.pt.yt_pref) < 0) { 
      for(people <- p.circle; if (people.youtube && !subscriptions.exists(x => x == people.youtubeProfile))) {
        // Subscribe to a random circle member
        subscribe(people.youtubeProfile)
      }
    }

    if(((Random.nextInt(100) - p.pt.yt_pref) < 0) && subscriptions.length > 0) {
      //unsubscribe from a random subscription
      unsuscribe(subscriptions(Random.nextInt(subscriptions.length )))
    }

    for(people <- p.circle; if !(people.youtube)) {

      if ((Random.nextInt(100) - p.pt.yt_pref) < 0) {
        
        sendYoutubeInvitation(people)
      }
    }
  }
  
  // ---------------------------------
  // YouTube profile possible actions
  // ---------------------------------

  def subscribe(y: YoutubeProfile)
  {
    //println(p + " has subscribed to " + y.p + "(Youtube)")
    subscriptions += y
    y.subscribers += this

  }

  def unsuscribe(y: YoutubeProfile)
  {
    //println(p + " unsubscribe from " + y.p + "(Youtube)")
    subscriptions -= y
    y.subscribers -= this
  }

  def addVideo()
  {  
    //println(p + " added a video")
    videos += new YoutubeVideo(this)
    for(y <- subscribers)
        y.feed += 1
  }

  def removeVideo(v: YoutubeVideo)
  {
    //println(p + " removed a video")
    videos -= v
    for(y <- subscribers)
        y.feed -= 1
  }

  def commentVideo(v: YoutubeVideo)
  {
    //println(p + " commented " + v.y.p + "'s video")
    v.comments += new YoutubeVideoComment(this, v)
    for(y <- subscribers)
        y.feed += 1
  }

  def sendYoutubeInvitation(pp: People)
  {
    println(p + " invites "+pp+" to join YouTube")
    pp.youtubeInvitations += new YoutubeInvitation(pp)
    o.notifyYoutubeInvitation(pp)
  }
}
