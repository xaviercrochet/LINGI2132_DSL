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
    o.notifyFacebookJoin()
  }
  
  def leaveFacebook() {
    println(name + " has left Facebook")
    facebook = false
    o.notifyFacebookLeave()
  }

  def joinYoutube() {
    println(name + " has join Youtube")
    youtube = true
  }

  def leaveYoutube() {
    println(name + " has left Youtube")
    youtube = false
  }

  override def toString() = {
    name
  }
}
