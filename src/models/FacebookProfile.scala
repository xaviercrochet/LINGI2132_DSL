class FacebookProfile(m: SimModel, o: Observer, val p: People) {
  
  var friends = List[FacebookProfile]()
  var invitations = List[FacebookProfile]()
  var posts = List[FacebookPost]()
  var message = List[String]()
  var pictures = List[FacebookPicture]()

  
  def idle() {
      var r = new scala.util.Random
      for (people <- p.circle) {
        if (people.facebook)
          askFriend(people.facebookProfile)
        
        else
          sendFacebookInvitation(people)
      }
      
      for (friend <-friends)
        sendMessage(friend, r.nextString(8))

      post(r.nextString(20))
      uploadPicture()
      m.wait(1.0) {
        idle()
      }
  }

  def askFriend(f: FacebookProfile)
  {
    println(p.name + " asks " + f.p.name + " to become his friend")
    f.invitations :+ f
  }

  def acceptFriend(f: FacebookProfile)
  {
    println(p.name + " accepts " + f.p.name + " friend request")
    friends :+ f.p
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
    friends = friends.filter(_ != f.p)
  }
  
  def sendMessage(f: FacebookProfile, m: String)
  {
    println(p.name + " sent " + m + " to " + f.p.name)
    f.readMessage(f, m)
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
    posts :+ new FacebookPost(this, s)
  }

  def uploadPicture()
  {
    println(p.name + " upload a new picture")
    pictures :+ new FacebookPicture(this)
  }
}
