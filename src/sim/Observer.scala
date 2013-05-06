package sim
import scala.util.Random
import scala.collection.mutable.ListBuffer
import sim.models._
import sim.scenario._

class Observer()
{

  //var nbSubscriber = 0

  ///////////////////////////////////
  //         FACEBOOK              //
  ///////////////////////////////////

  var fbInvitationsObs = ListBuffer[Scenario]()
  //var fbMessageObs: ListBuffer[Scenario] = _

  def notifyFacebookInvitation(p: People) {

    fbInvitationsObs.foreach { obs =>
    	obs.notifySc(p)
    }

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
    /*val r = new Random()
    if(r.nextInt() %2 == 0)
      receiver.acceptFriend(sender)
    else
      receiver.refuseFriend(sender)*/

    if((Random.nextInt(100) - receiver.p.pt.fb_pref) < 0) {
      receiver.acceptFriend(sender)
    }
    else {
      receiver.refuseFriend(sender)
    }
  }

  def notifyFacebookJoin() {
  	Facebook.nbSub += 1
  }

  def notifyFacebookLeave() {
  	Facebook.nbSub -= 1
  }

  ///////////////////////////////////
  //         TWITTER               //
  ///////////////////////////////////

  def notifyTwitterInvitation(s: TwitterProfile, r: TwitterProfile) {

  }

  def notifyTwitterJoin() {
    Twitter.nbSub += 1
  }

  def notifyTwitterLeave() {
    Twitter.nbSub -= 1
  }

  ///////////////////////////////////
  //         YOUTUBE               //
  ///////////////////////////////////

  def notifyYoutubeJoin() {
    Youtube.nbSub += 1
  }

  def notifyYoutubeLeave() {
    Youtube.nbSub -= 1
  }
}
