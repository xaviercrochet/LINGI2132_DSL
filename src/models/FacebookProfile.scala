import scala.collection.mutable.ListBuffer
import scala.util.Random

class FacebookProfile(m: SimModel, o: Observer, val p: People) {
  
  var friends = ListBuffer[FacebookProfile]()
  var invitations = ListBuffer[FacebookProfile]()
  var posts = ListBuffer[FacebookPost]()
  var message = ListBuffer[String]()
  var pictures = ListBuffer[FacebookPicture]()

  
  def idle() {
      for (people <- p.circle) {
        if (people.facebook && !(friends.exists(x => x == people.facebookProfile)))
          askFriend(people.facebookProfile)
        
        else
          sendFacebookInvitation(people)
      }
      
      for (friend <-friends)
        sendMessage(friend, "Message"+Random.nextInt(friends.length))

      post(Random.nextString(20))
      uploadPicture()
      m.wait(1.0) {
        idle()
      }
  }

  def askFriend(f: FacebookProfile)
  {
    println(p.name + " asks " + f.p.name + " to become his friend")
    f.invitations += f
    o.notifyFacebookInvitation(this, f)
  }

  def acceptFriend(f: FacebookProfile)
  {
    println(p.name + " accepts " + f.p.name + " friend request")
    friends += f
    invitations = invitations.filter(_ != f)
  }

  def refuseFriend(f: FacebookProfile)
  {
    println(p.name + " refuses " + f.p.name + " friend request")
    invitations = invitations.filter(_ != f)
  }

  def deleteFriend(f: FacebookProfile)
  {
    println(p.name + " delete " + f.p.name + " from his friends")
    friends = friends.filter(_ != f)
  }
  
  def sendMessage(f: FacebookProfile, m: String)
  {
    println(p.name + " sent " + m + " to " + f.p.name)
    f.readMessage(f, m)
    o.notifyFacebookMessage(this, f, m)
  }
  
  def readMessage(f: FacebookProfile, m:String)
  {  
    println(p.name + " read " + m + " from " + f.p.name)
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
  }

  def uploadPicture()
  {
    println(p.name + " upload a new picture")
    pictures += new FacebookPicture(this)
  }
}
