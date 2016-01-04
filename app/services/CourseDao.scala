package services

import play.modules.reactivemongo.ReactiveMongoPlugin
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.json.BSONFormats._
import play.api.Play.current

import models._
import models.Course._
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import reactivemongo.api.QueryOpts
import reactivemongo.core.commands.Count
import reactivemongo.bson.BSONObjectID
import reactivemongo.bson.BSONDocument
import play.api.libs.json.{Writes, Json, JsObject,JsValue}  


/** A data access object for messages backed by a MongoDB collection */
object CourseDao {

  /** The courses collection */  
  private def courses_collection =  ReactiveMongoPlugin.db.collection[JSONCollection]("courses")

  def save(course: Course): Future[Course] = {
    courses_collection.save(course).map {
      case ok if ok.ok =>  course
      case error => throw new RuntimeException(error.message)
    }

  }
    

  def update_post(filter_condition:JsObject,update_value:JsObject) : Future[Boolean] = {

    courses_collection.update(filter_condition,update_value).map {
      case ok if ok.ok => true
      case error => false 
    }
  }


  def findCourse(course_id:Int): Future[Seq[JsValue]] = {

  val query = Json.obj("id"->course_id)

  // Filters
  val filter = Json.obj("_id"->0)

  // val return_val= courses_collection.find(query,filter).cursor[Assignments].collect[Seq]()

  val return_val= courses_collection.find(query,filter).cursor[JsValue].collect[Seq]()

  return_val
    
  }

}