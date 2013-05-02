import scala.collection.mutable.ListBuffer

class Tweet(var t: TwitterProfile){

  var retweeters = ListBuffer[TwitterProfile]()

  def reTweet(tt : TwitterProfile)
  {
    println(tt.p + "Retweet "+ t.p +"'s tweet")
    retweeters += tt
  }
}
