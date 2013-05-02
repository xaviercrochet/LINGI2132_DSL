class Observer()
{
  def notifyFacebookInvitation(p: People) {
    if(p.facebookInvitations.size == 3)
      p.joinFacebook()
  }
}
