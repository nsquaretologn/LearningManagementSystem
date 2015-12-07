package services

import play.modules.reactivemongo.ReactiveMongoPlugin
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.json.BSONFormats._
import play.api.Play.current

import models._
import models.Assignments._
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import reactivemongo.api.QueryOpts
import reactivemongo.core.commands.Count
import reactivemongo.bson.BSONObjectID
import reactivemongo.bson.BSONDocument
import play.api.libs.json.{Writes, Json, JsObject,JsValue}  


/** A data access object for messages backed by a MongoDB collection */
object AssignmentDao {

  /** The courses collection */  
  private def courses_collection =  ReactiveMongoPlugin.db.collection[JSONCollection]("courses")


  // def update_post(filter_condition:JsObject,update_value:JsObject) : Future[Boolean] = {

  //   courses_collection.update(filter_condition,update_value).map {
  //     case ok if ok.ok => true
  //     case error => throw new RuntimeException(error.message)
  //   }
  // }

  def findAssignments(course_id:Int,assignment_id:Int): Future[Seq[JsValue]] = {

  // Select only the documents which field 'firstName' equals 'Jack'
  val query = Json.obj("id"->course_id,"assignments.id" -> assignment_id)

  // select only the field 'lastName'
  val filter = Json.obj("assignments"->1,"_id"->0)

  // val return_val= courses_collection.find(query,filter).cursor[Assignments].collect[Seq]()

  val return_val= courses_collection.find(query,filter).cursor[JsValue].collect[Seq]()

  return_val
    


  }

}
