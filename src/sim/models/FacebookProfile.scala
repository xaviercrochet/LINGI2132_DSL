package sim.models

import scala.collection.mutable.ListBuffer
import scala.util.Random
import sim._

class FacebookProfile(m: SimModel, o: Observer, val p: People) {
  
  var friends = ListBuffer[FacebookProfile]()
  var invitations = ListBuffer[FacebookProfile]()
  var posts = ListBuffer[FacebookPost]()
  var messages = ListBuffer[String]()
  var pictures = ListBuffer[FacebookPicture]()
    var feed = 0
  // Facebook profile's life
    def reset() {
        feed = 0
        p.facebook = false
        friends = ListBuffer[FacebookProfile]()
        invitations = ListBuffer[FacebookProfile]()
        posts = ListBuffer[FacebookPost]()
        messages = ListBuffer[String]()
        pictures = ListBuffer[FacebookPicture]()
    }

  def run() {
    for (people <- p.circle) {

      if((Random.nextInt(100) - people.pt.fb_pref) < 0) {

        if (people.facebook && !(friends.exists(x => x == people.facebookProfile))) {
          askFriend(people.facebookProfile)
        }
        else {
          sendFacebookInvitation(people)
        }
      }
    }
    
    if(Random.nextInt() %5 == 0 && friends.length > 0)
      sendMessage(friends(Random.nextInt(friends.length)), "Message"+Random.nextInt())

    post(Random.nextString(20))
    uploadPicture()
  }

  // ---------------------------------
  // Facebook profile possible actions
  // ---------------------------------

  def askFriend(f: FacebookProfile)
  {
    println(p.name + " asks " + f.p.name + " to become his friend")
    f.invitations += f
    o.notifyFacebookInvitation(this, f)
    f.feed += 1
  }

  def acceptFriend(f: FacebookProfile)
  {
    println(p.name + " accepts " + f.p.name + " friend request")
    friends += f
    invitations -= f
  }

  def refuseFriend(f: FacebookProfile)
  {
    println(p.name + " refuses " + f.p.name + " friend request")
    invitations -= f
  }

  def deleteFriend(f: FacebookProfile)
  {
    println(p.name + " delete " + f.p.name + " from his friends")
    friends -= f
  }
  
  def sendMessage(f: FacebookProfile, m: String)
  {
    f.messages += m
    o.notifyFacebookMessage(this, f, m)
    f.feed += 1
  }
  
  def readMessage(f: FacebookProfile, m:String)
  {  
    messages -= m
    if(Random.nextInt() %5 == 0)
        sendMessage(f, "Responses "+Random.nextInt())
  }
  
  def sendFacebookInvitation(pp: People)
  {
    println(p.name + " ask " + pp.name + " to join facebook")
    pp.facebookInvitations += new FacebookInvitation(pp)
    o.notifyFacebookInvitation(pp)
  }

  def post(s: String)
  {
    println(p.name + " add a new post")
    val post = new FacebookPost(this, s)
    posts += post
    o.notifyFacebookPost(this, post, friends)
    for (f <- friends)
        f.feed += 1
  }

  def uploadPicture()
  {
    println(p.name + " upload a new picture")
    pictures += new FacebookPicture(this)
    for (f <- friends)
        f.feed += 1
  }
}
