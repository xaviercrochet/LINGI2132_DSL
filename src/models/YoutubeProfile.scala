import scala.collection.mutable.ListBuffer
import scala.util.Random

class YoutubeProfile(val m: SimModel, val o: Observer, val p: People)
{
  var subscriptions = ListBuffer[YoutubeProfile]()
  var videos = ListBuffer[YoutubeVideo]()

  def idle() {
    if(p.youtube) {
      addVideo()
      if(Random.nextInt() % 5 == 0 && videos.length > 0) {
        // remove a random video
        videos -= videos(Random.nextInt(videos.length ))
      }
      if(Random.nextInt() % 5 == 0 && subscriptions.length > 0 ) {
        /// comment a random video from our subscribtions
        var s = subscriptions(Random.nextInt(subscriptions.length ))
        if(s.videos.length > 0)
          commentVideo(s.videos(Random.nextInt(s.videos.length)))
      }
      if(Random.nextInt() %5 == 0) { 
        for(people <- p.circle; if (people.youtube && !subscriptions.exists(x => x == people.youtubeProfile))) {
        // Subscribe to a random circle member
          subscribe(people.youtubeProfile)
        }
      }
      if(Random.nextInt()%5 == 0 && subscriptions.length > 0) {
        //unsubscribe from a random subscription
        unsuscribe(subscriptions(Random.nextInt(subscriptions.length )))
      }
    }

    m.wait(5.0) {
      idle()
    }
  }
  
  def subscribe(y: YoutubeProfile)
  {
    println(p + " has subscribed to " + y.p + "(Youtube)")
    y.subscriptions += this
  }

  def unsuscribe(y: YoutubeProfile)
  {
    println(p + " unsubscribe from " + y.p + "(Youtube)")
    y.subscriptions -= this
  }

  def addVideo()
  {  
    println(p + " added a video")
    videos += new YoutubeVideo(this)
  }

  def removeVideo(v: YoutubeVideo)
  {
    println(p + " removed a video")
    videos -= v
  }

  def commentVideo(v: YoutubeVideo)
  {
    println(p + " commented " + v.y.p + "'s video")
    v.comments += new YoutubeVideoComment(this, v)
  }

  def invite(pp: People)
  {
    println(p + " invites "+pp+" to join YouTube")
    pp.youtubeInvitations += new YoutubeInvitation(pp)
  }
}
