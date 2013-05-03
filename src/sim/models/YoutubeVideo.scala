package sim.models
import scala.collection.mutable.ListBuffer

class YoutubeVideo(val y: YoutubeProfile){

  var comments = ListBuffer[YoutubeVideoComment]()

  def addComent(yy: YoutubeProfile)
  {
    comments += new YoutubeVideoComment(yy, this)
  }
}
