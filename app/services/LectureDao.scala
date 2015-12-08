package services

import play.modules.reactivemongo.ReactiveMongoPlugin
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.json.BSONFormats._
import play.api.Play.current

import models._
import models.Lectures._
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import reactivemongo.bson.BSONDocument
import play.api.libs.json.{Writes, Json, JsObject,JsValue}  


/** A data access object for messages backed by a MongoDB collection */
object LectureDao {

  /** The courses collection */  
  private def courses_collection =  ReactiveMongoPlugin.db.collection[JSONCollection]("courses")


  // def update_post(filter_condition:JsObject,update_value:JsObject) : Future[Boolean] = {

  //   courses_collection.update(filter_condition,update_value).map {
  //     case ok if ok.ok => true
  //     case error => throw new RuntimeException(error.message)
  //   }
  // }

  def findLecture(course_id:Int,lecture_id:Int): Future[Seq[JsValue]] = {

  // Query condition
  val query = Json.obj("id"->course_id,"lectures.id" -> lecture_id)

  // Filters
  val filter = Json.obj("lectures"->Json.obj("$elemMatch"->Json.obj("id"->lecture_id)),"_id"->0)

  val return_val= courses_collection.find(query,filter).cursor[JsValue].collect[Seq]()

  return_val
  }

}
