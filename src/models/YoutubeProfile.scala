import scala.collection.mutable.ListBuffer
import scala.util.Random

class YoutubeProfile(val m: SimModel, val o: Observer, val p: People)
{
  var subscriptions = ListBuffer[YoutubeProfile]()
  var videos = ListBuffer[YoutubeVideo]()

  def idle() {
    if(p.youtube) {
      addVideo()
      if(Random.nextInt() % 5 == 0) {
        // remove a random video
        videos -= videos(Random.nextInt(videos.length -1))
      }
      if(Random.nextInt() % 5 == 0) {
        /// comment a random video from our subscribtions
        var s = subscriptions(Random.nextInt(subscriptions.length - 1))
        commentVideo(s.videos(Random.nextInt(s.videos.length-1)))
      }
      if(Random.nextInt() %5 == 0) {
        // Subscribe to a random circle member
        subscribe(p.circle(Random.nextInt(p.circle.length - 1)).youtubeProfile)
      }
      if(Random.nextInt()%5 == 0) {
        //unsubscribe from a random subscription
        unsuscribe(subscriptions(Random.nextInt(subscriptions.length - 1)))
      }
      m.wait(5.0) {
        idle()
      }
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

}
