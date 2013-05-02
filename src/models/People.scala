import scala.collection.mutable.ListBuffer

class People(val name: String, val o: Observer, val m: SimModel, var facebook: Boolean) {
  
  var facebookProfile : FacebookProfile = new FacebookProfile(m, o, this)
  var facebookInvitations  = new ListBuffer[FacebookInvitation]()
  var circle: ListBuffer[People] = _
  
  def run() {
    facebookProfile.idle()
  }
  
  def joinFacebook() {
    println(name + " has join Facebook")
    facebook = true
  }
  
  def leaveFacebook() {
    println(name + " has left Facebook")
    facebook = false
  }

  override def toString() = {
    name
  }
}
