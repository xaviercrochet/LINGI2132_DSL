import scala.collection.mutable.ListBuffer
import scala.util.Random

class YoutubeProfile(m: SimModel, o: Observer, p: People)
{
  var subscribers = ListBuffer[YoutubeProfile]()
  var videos = ListBuffer[YoutubeVideo]()

  def idle() {
    this.addVideo()
    m.wait(5.0) {
      idle()
    }
  }
  
  def suscribe(y: YoutubeProfile)
  {
    y.subscribers += this
  }

  def unsuscribe(y: YoutubeProfile)
  {
    y.subscribers = y.subscribers.filter(_ != y)
  }

  def addVideo()
  {  
    videos += new YoutubeVideo(this)
  }

  def removeVideo(v: YoutubeVideo)
  {
    videos = videos - v
  }

  def commentVideo(v: YoutubeVideo)
  {
    v.comments += new YoutubeVideoComment(this, v)
  }

}
