package controllers

import play.api.Logger
import play.api.mvc._
import play.api.libs.json.{Writes, Json, JsObject,JsString,JsNumber,JsValue}
import play.api.libs.concurrent.Execution.Implicits._

import models._
import services.CourseDao

import reactivemongo.bson.BSONObjectID
import scala.concurrent.Future
import scala.concurrent.duration._
import concurrent.Promise
import scala.util.{Success, Failure}
import java.text.SimpleDateFormat
import java.util.Date
import java.io.File
import play.api.libs.Files.TemporaryFile
import util._




object CourseController extends Controller {

  // Request Body
  def parse_value_body(body:MultipartFormData[TemporaryFile],key_string:String): Option[String] = {
 
        var temp_val : Option[String] = None
        val map_value = body.dataParts.getOrElse(key_string,None) 

        map_value match {
          case None => temp_val = None
          case n :: rest => {temp_val = Some(n.toString())}
          }
        temp_val
  }

  // Add Course
    def add_course = Action.async(parse.json) { 

    //Parse the input
    req =>
       
        var course_id: Int = (req.body \ "c_id").as[Int]
        
        var instructor_id: Int = (req.body \ "instructor_id").as[Int]

        var c_name = (req.body \ "c_name").as[String]

        var c_summary = (req.body \ "c_summary").as[String]

        val form = CourseDao.save(Course(course_id,c_name,instructor_id,c_summary,List(),List(),List())).map(_ => Created)

        form

    }

  // Edit Course
 	def edit_course= Action.async(parse.json) 
  {

    req=>
   
    var course_id: Int = (req.body \ "c_id").as[Int]
    
    var instructor_id: Int = (req.body \ "instructor_id").as[Int]

    var c_name = (req.body \ "c_name").as[String]

    var c_summary = (req.body \ "c_summary").as[String]

    val filter_condition = Json.obj("id" -> course_id)

    val update_value = DBQueryBuilder.set(Json.obj("id"->course_id,"c_name"->c_name,"c_inst_id"->instructor_id,"c_summary"->c_summary))

    var response = ""

    CourseDao.update_post(filter_condition,update_value).onComplete {
          case Success(posts) => {response = "Posted"}
          case Failure(t) => {response = "Error Not Posted"}
      }

    Future{Ok(response)}

  }
    

  //View Assignment
 	def getCourseInformation(course_id:Int) = Action.async{ 

      req =>
      val messages = CourseDao.findCourse(course_id)
      messages.map {
         value => Ok(Json.toJson(value))
      }
    }

  // //Delete Lecture
 	// def delete_course = Action.async(parse.json) { 

  //     req =>
  //     // Course  Id
  //     val c_id = (req.body \ "c_id").as[Int]
      
  //     // Assignment Id
  //     val a_id =(req.body \ "a_id").as[Int]
  
  //     val filter_condition = Json.obj("id" -> c_id,"assignments.id"->a_id)
  //     val query_json_object= Json.obj("assignments" -> a_id)

  //     val update_value = DBQueryBuilder.pull("assignments",query_json_object)      

  //     Future{CourseDao.update_post(filter_condition,update_value)}
  //     Future{Ok("hi")}
  //   }

}