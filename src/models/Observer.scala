class Observer()
{
  def notifyFacebookInvitation(p: People) {
    val size: Int = p.facebookInvitations.size
    println("Observer has "+size+" facebook invitation notification for "+p)
    if(p.facebookInvitations.size == 3)
      p.joinFacebook()
  }
}
