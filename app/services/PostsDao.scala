package services

import play.modules.reactivemongo.ReactiveMongoPlugin
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.json.BSONFormats._
import play.api.Play.current
import models._
import models.User._
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import reactivemongo.api.QueryOpts
import reactivemongo.core.commands.Count
import reactivemongo.bson.BSONObjectID
import reactivemongo.bson.BSONDocument
import play.api.libs.json.{Writes, Json, JsObject}  


/** A data access object for messages backed by a MongoDB collection */
object PostsDao {

  /** The user collection */  
  private def user_collection =  ReactiveMongoPlugin.db.collection[JSONCollection]("user")

  /** The courses collection */  
  private def courses_collection =  ReactiveMongoPlugin.db.collection[JSONCollection]("courses")


  def update_post(filter_condition:JsObject,update_value:JsObject) : Future[Boolean] = {

    courses_collection.update(filter_condition,update_value).map {
      case ok if ok.ok => true
      case error => throw new RuntimeException(error.message)
    }
  }

  def findPosts(course_id:Int,post_id:Int): Future[Seq[Comments]] = {

  // Select only the documents which field 'firstName' equals 'Jack'
  val query = BSONDocument("post.id" -> post_id,"id"->course_id)

  // select only the field 'lastName'
  val filter = BSONDocument("post.p_comments" -> 1)

  courses_collection.find(query,filter).cursor[Comments].collect[Seq]()
  }





  // /**
  //  * Save a message.
  //  *
  //  * @return The saved message, once saved.
  //  */
  // def save(message: Post): Future[Post] = {
  //   courses_collection.save(message).map {
  //     case ok if ok.ok => message
  //     case error => throw new RuntimeException(error.message)
  //   }
  // }

  // /**
  //  * Find all the messages.
  //  *
  //  * @param page The page to retrieve, 0 based.
  //  * @param perPage The number of results per page.   
  //  * @return All of the messages.
  //  */

  // def findUser(user_id: Int): Future[Seq[User]] = {

  // // Select only the documents which field 'firstName' equals 'Jack'
  // val query = BSONDocument("id" -> 2)

  // // select only the field 'lastName'
  // val filter = BSONDocument("course_info" -> 0)

  // user_collection.find(query,filter).cursor[User].collect[Seq]()
  // }




 // / // /** The total number of messages */
 //  def post_count: Future[Int] = {
 //    ReactiveMongoPlugin.db.command(Count(collection.name))
 //  }

}