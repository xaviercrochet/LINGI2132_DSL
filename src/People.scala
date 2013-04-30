class People(val name: String, val m: SimModel, var facebook: Boolean) {
  
  def idle() {
    println(name +" is idle.")
    var r = new scala.util.Random()
    m.wait(10.0) {
      if(facebook) {
        if (r.nextInt() % 10 == 0)
          leaveFacebook()
      }
      else {
        if (r.nextInt() % 10 == 0)
          joinFacebook()
      }
      idle()
    }
  }

  def joinFacebook() {
    println(name + " has join Facebook")
    facebook = true
    m.wait(20.0) {
      idle()
    }
  }
  
  def leaveFacebook() {
    println(name + " has left Facebook")
    facebook = false
    m.wait(20.0) {
      idle()
    }
  }
  
  def readFacebookInvitation() {
    var r = new scala.util.Random()
    if (r.nextInt() % 2 == 0) {
      println(name + " has accepted Facebook's invitation! ")
      joinFacebook()
    }
    else
      println(name + " has refused Facebook's invitation! ")
    
    m.wait(20.0) {
      idle()
    }
  }

}
