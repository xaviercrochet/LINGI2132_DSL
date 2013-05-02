import scala.collection.mutable.ListBuffer

class Facebook(val m:SimModel, val o: Observer, val population: ListBuffer[People])
{
  def invite(p: People) {
    println("Facebook has invited " + p.name)
    p.facebookInvitations += new FacebookInvitation(p)
    o.notifyFacebookInvitation(p)
  }
}
