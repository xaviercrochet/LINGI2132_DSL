import scala.collection.mutable.ListBuffer

class People(val name: String, val m: SimModel, var facebook: Boolean) {
  
  var facebookProfile : FacebookProfile = new FacebookProfile(this)
  var facebookInvitations = List[FacebookInvitation]()
  var circle: ListBuffer[People] = _
  
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
