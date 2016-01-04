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
import play.api.libs.json.{Writes, Json, JsObject,JsValue}  


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

  def findPosts(course_id:Int,post_id:Int): Future[Seq[JsValue]] = {

  //  Query
  val query = Json.obj("id"->course_id,"post.id" -> post_id)

  // Filters
  val filter = Json.obj("post"->Json.obj("$elemMatch"->Json.obj("id"->post_id)),"_id"->0)

  val return_val= courses_collection.find(query,filter).cursor[JsValue].collect[Seq]()

  return_val
    

  }

}