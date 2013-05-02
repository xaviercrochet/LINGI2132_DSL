import scala.util.Random
import scala.collection.mutable.ListBuffer

class Observer()
{
  def notifyFacebookInvitation(p: People) {
    if(p.facebookInvitations.size == 3)
      p.joinFacebook()
  }
  def notifyFacebookMessage(sender: FacebookProfile, receiver: FacebookProfile, m: String)
  {
    val r = new Random()
    if(r.nextInt % 3 == 0)
      receiver.readMessage(receiver, m)
  }

  def notifyFacebookPost(f: FacebookProfile, p: FacebookPost, friends: ListBuffer[FacebookProfile])
  {
    // do some stuff
  }

  def notifyFacebookInvitation(sender: FacebookProfile, receiver: FacebookProfile)
  {
    val r = new Random()
    if(r.nextInt() %2 == 0)
      receiver.acceptFriend(sender)
    else
      receiver.refuseFriend(sender)
  }

}
