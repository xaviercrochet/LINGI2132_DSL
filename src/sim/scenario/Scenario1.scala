package sim.scenario

import sim.models._
import sim._

import scala.collection.immutable.Vector
import scala.collection.mutable.ListBuffer

class Scenario1(rules: ListBuffer[Vector[Any]]) extends Scenario {

  override def notifySc(p: People) {

  rules.foreach { rule =>

      println("-> " + rule)

      val people_type = rule(0)
      val action = rule(1)
      val network = rule(2)
      val network_action = rule(3)
      val people_action = rule(4)
      val nb: Int  = rule(5).toString().toInt

      println("People action : " + people_action)
      println("Network action : " + network_action)
      println("-> " + people_type + " vs " + p.pt.name)

      if(people_type == p.pt.name) {

        println("-> Good people type")

        println("Facebook ? " + p.facebook)
        println("Twitter ? " + p.twitter)
        println("Youtube ? " + p.youtube)

        if(network == "facebook") {
            if(p.facebook == false) {
              println("-> facebook detected")
              if(network_action == "when_receive") {
                println("-> when receive action")
                if(people_action == "invitation" && p.facebookInvitations.size == nb) {
                  if(action == "join") {
                    p.joinFacebook()
                    println("-> join !")
                  }
                }
            }
        }
          
          else {
              if(people_action == "message" && p.facebookProfile.messages.size >= nb) {
                if(action == "leave") {
                    p.leaveFacebook()
                    println("-> left ! (because of " + people_action+")")
                }
            }
            }
        }

        else if(network == "twitter") {
            if(p.twitter == false) {
                println("-> twitter detected")
                if(network_action == "when_receive") {
                  if(people_action == "invitation" && p.twitterInvitations.size == nb) {
                    if(action == "join") {
                      p.joinTwitter()
                      println("-> join !")
                    }
                  }
                }
            }
            else {
                if(people_action == "follower" && p.twitterProfile.followers.size <= nb) {
                    if(action == "leave") {
                        p.leaveTwitter()
                        println("-> left ! (because of "+ people_action+")")
                    }
                }
            }
        }
        
        else if(network == "youtube") {
            if(p.youtube == false) {
              println("-> youtube detected")
              if(network_action == "when_receive") {
                if(people_action == "invitatioan" && p.youtubeInvitations.size == nb) {
                  if(action == "join !") {
                    p.joinYoutube()
                    println("-> join !")
                  }
                }
              }
          }
          else {
              if(people_action == "subscriber" && p.youtubeProfile.subscribers.size <= nb) {
                  p.leaveYoutube()
                  println("-> left ! (because of " + people_action+")")
              }
          }
        }
      }
    }
  }
}

object Scenario1 {

	//var sc: Scenario = _
	var rules: ListBuffer[Vector[Any]] = ListBuffer()

	def apply(o: Observer) {

		var sc: Scenario1 = new Scenario1(rules)

		// Observe the Facebook's invitation
		o.fbInvitationsObs += sc
		o.twiInvitationsObs += sc
		o.ytInvitationsObs += sc
	}

	def apply(v: Vector[Any]) {

		// Add the rule to the rules list
		rules += v

		println(rules)
	}
}
