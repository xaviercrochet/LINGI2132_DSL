class Facebook(val m:SimModel, val population: List[People])
{
  def idle() {
    for (p <- population; if p.facebook == false)
      invite(p)
  
    m.wait(5.0) {
      idle()
    }

  }

  def invite(p: People) {
    println("Facebook has invited " + p.name)
    p.readFacebookInvitation()
    m.wait(5.0) {
      idle()
    }
  }
}
