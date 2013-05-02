import scala.collection.mutable.ListBuffer

class People(val name: String, val o: Observer, val m: SimModel, var facebook: Boolean) {
  
  var facebookProfile : FacebookProfile = new FacebookProfile(m, o, this)
  var facebookInvitations  = new ListBuffer[FacebookInvitation]()
  var circle: ListBuffer[People] = _
  
  def run() {
    if(facebook)
      facebookProfile.idle()
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
