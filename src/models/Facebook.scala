import scala.collection.mutable.ListBuffer

class Facebook(val m:SimModel, val o: Observer, val population: ListBuffer[People])
{
  
  def run() {
    for (p <- population; if (!p.facebook))
      invite(p)
    
    m.wait(5.0) {
      run()
    }
  }
  
  def invite(p: People) {
    println("Facebook has invited " + p.name)
    p.facebookInvitations += new FacebookInvitation(p)
    o.notifyFacebookInvitation(p)
  }
}
