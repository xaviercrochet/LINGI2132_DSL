import scala.collection.mutable.ListBuffer

class People(val name: String, val o: Observer, val m: SimModel, var facebook: Boolean, var youtube: Boolean) {
  
  var facebookProfile : FacebookProfile = new FacebookProfile(m, o, this)
  var facebookInvitations  = new ListBuffer[FacebookInvitation]()
  var youtubeProfile : YoutubeProfile = new YoutubeProfile(m, o, this)
  var circle: ListBuffer[People] = _
  
  def run() {
    if(facebook)
      facebookProfile.idle()
    if(youtube)
      youtubeProfile.idle()
  }
  
  def joinFacebook() {
    println(name + " has join Facebook")
    facebook = true
    o.notifyJoin()
  }
  
  def leaveFacebook() {
    println(name + " has left Facebook")
    facebook = false
    o.notifyLeave()
  }

  override def toString() = {
    name
  }
}
