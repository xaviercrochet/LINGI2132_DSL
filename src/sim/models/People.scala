package sim.models
import sim._
import scala.collection.mutable.ListBuffer

class People(val name: String, val o: Observer, val m: SimModel, var age: Int, var sex: Boolean, var facebook: Boolean, var youtube: Boolean, var twitter: Boolean) {
  
  var facebookProfile = new FacebookProfile(m, o, this)
  var facebookInvitations  = new ListBuffer[FacebookInvitation]()
  var twitterInvitations = new ListBuffer[TwitterInvitation]()
  var youtubeInvitations = new ListBuffer[YoutubeInvitation]() 
  var youtubeProfile = new YoutubeProfile(m, o, this)
  var twitterProfile = new TwitterProfile(m, o, this)
  var circle: ListBuffer[People] = _
  
  def run() {
    if(facebook)
      facebookProfile.idle()
    if(youtube)
      youtubeProfile.idle()
    if(twitter)
      twitterProfile.idle()
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

  def joinTwitter() {
    println(name + " has join Twitter")
    twitter = true
  }

  def leaveTwitter() {
    println(name + " has left Twitter")
    twitter = false
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
