class Facebook(val m:SimModel, val population: List[People])
{
  
  def invite(p: People) {
    println("Facebook has invited " + p.name)
    p.facebookInvitations :+ new FacebookInvitation(p)
  }
}
