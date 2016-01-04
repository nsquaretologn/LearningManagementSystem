package controllers

import play.api.Logger
import play.api.mvc._
import play.api.libs.json.{Writes, Json, JsObject,JsString,JsNumber,JsValue}
import play.api.libs.concurrent.Execution.Implicits._

import models._
import services.PostsDao
import services.AssignmentDao

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




object AssignmentController extends Controller {

  // Request  Body

  def parse_value_body(body:MultipartFormData[TemporaryFile],key_string:String): Option[String] = {
 
        var temp_val : Option[String] = None
        val map_value = body.dataParts.getOrElse(key_string,None) 

        map_value match {
          case None => temp_val = None
          case n :: rest => {temp_val = Some(n.toString())}
          }
        
        // foreach(value => {temp_val = Some(value) 
        //   println(value)
        //   })
        println(temp_val)
        temp_val
  }

  

  // Add Lecture
    def add_assignment = Action.async(parse.multipartFormData) { 

    //Parse the input
    request =>
       
       println("request type is "+request.body)
        var course_id: Int = 0
        parse_value_body(request.body,"c_id") match {
          case Some(f) => {course_id = f.toInt 
        }
          case None => None    
        }
        // request.body.dataParts.get("c_id").get.foreach(value => course_id = value.toInt)

        var a_id: Int = 0
        parse_value_body(request.body,"a_id") match {
          case Some(f) => {a_id = f.toInt 
           }
           case None => None
        }        

        var a_topic = ""

        parse_value_body(request.body,"a_topic") match {
          case Some(f) => {a_topic = f 
                     }
          case None => None

        }   

        var a_uploaded_date = ""
        parse_value_body(request.body,"a_uploaded_date") match {
          case Some(f) => {a_uploaded_date = f         
           }
           case None => None
        }


        var a_due_date = ""
        parse_value_body(request.body,"a_due_date") match {
          case Some(f) => {a_due_date = f        
           }
           case None => None
        }


        var a_descripton = ""
       parse_value_body(request.body,"a_descripton") match {
          case Some(f) => {a_descripton = f  
           }
           case None => None
        }

          var a_total_marks: Int =0
       parse_value_body(request.body,"a_total_marks") match {
          case Some(f) => {a_total_marks = f.toInt }
          case None => None
        }


       // Upload lecture to ftp server:
      request.body.file("file_upload").map { 

        video =>

        val videoFilename = video.filename

        println(videoFilename)

        val contentType = video.contentType.get

        val destination_file_name= "/home/"+course_id+"/"+a_id +"/assignments/" + video.filename 

        video.ref.moveTo(new File(destination_file_name),true)

        val filter_condition = Json.obj("id" -> course_id)

        val update_value = DBQueryBuilder.push("assignments",Assignments(a_id,a_topic,a_uploaded_date,a_due_date,a_descripton,destination_file_name,a_total_marks))

        PostsDao.update_post(filter_condition,update_value)

     }.getOrElse {  Ok("Sorry Could not upload file") }      

      Future{Ok("hi")}
            
    }

  // Edit Lecture
 	def edit_assignment= Action.async(parse.multipartFormData) { 

      request=>
       
        var edit_inputs = List[(String,JsValue)]()
        
        var c_id:Int=0
        var a_id:Int=0
        parse_value_body(request.body,"c_id") match {
          case Some(course_id) => {edit_inputs = ("assignments.$.id"-> JsNumber(course_id.toInt)) :: edit_inputs
                                   c_id =course_id.toInt}
          case None => None
        }
       
        parse_value_body(request.body,"a_id") match {
          case Some(a_d) => {edit_inputs = ("assignments.$.a_id"->JsNumber(a_d.toInt)) :: edit_inputs
                               a_id=a_d.toInt}
          case None => None
        }       
        
        parse_value_body(request.body,"a_topic") match {
          case Some(a_topic) => {edit_inputs = ("assignments.$.a_topic"-> JsString(a_topic)):: edit_inputs}
          case None => None
        }         

        parse_value_body(request.body,"a_uploaded_date") match {
          case Some(a_uploaded_date) => {edit_inputs = ("assignments.$.a_uploaded_date"->JsString(a_uploaded_date)):: edit_inputs}
          case None => None
        } 

        parse_value_body(request.body,"a_due_date") match {
          case Some(a_due_date) => {edit_inputs = ("assignments.$.a_due_date"->JsString(a_due_date)):: edit_inputs}
          case None => None
        } 

        parse_value_body(request.body,"a_descripton") match {
          case Some(a_descripton) => {edit_inputs = ("assignments.$.a_descripton"->JsString(a_descripton)):: edit_inputs}
          case None => None
        } 

        parse_value_body(request.body,"a_total_marks") match {
          case Some(a_total_marks) => {edit_inputs = ("assignments.$.a_total_marks"->JsNumber(a_total_marks.toInt)):: edit_inputs}
          case None => None
        }         


       // Upload lecture to ftp server:
      request.body.file("file_upload").map { 

        video =>

        val videoFilename = video.filename

        val contentType = video.contentType.get

        val destination_file_name= "/home/"+c_id+"/"+a_id +"/assignments/" + video.filename 

        video.ref.moveTo(new File(destination_file_name),true)

        edit_inputs = ("assignments.$.a_uploaded_file"->JsString(destination_file_name)) :: edit_inputs         

       }.getOrElse {Ok("Sorry Could not upload file")}      

        val filter_condition = Json.obj("id" -> c_id,"assignments.id" -> a_id)

        val update_value = DBQueryBuilder.set(JsObject(edit_inputs))

        println(update_value)

        println(filter_condition)

        PostsDao.update_post(filter_condition,update_value)

        Future{Ok("hi")}
    }
    

  //View Assignment
 	def getAssignment(course_id:Int,a_id:Int) = Action.async{ 

           req =>
      val messages = AssignmentDao.findAssignments(course_id,a_id)
      messages.map {
         value => Ok(Json.toJson(value))
      }
    }

  //Delete Lecture
 	def delete_assignment = Action.async(parse.json) { 

           req =>
           // Course  Id
      val c_id = (req.body \ "c_id").as[Int]
      
          // Assignment Id
      val a_id =(req.body \ "a_id").as[Int]
  
      val filter_condition = Json.obj("id" -> c_id,"assignments.id"->a_id)
      val query_json_object= Json.obj("id" -> a_id)

      val update_value = DBQueryBuilder.pull("assignments",query_json_object)      

      Future{AssignmentDao.update_post(filter_condition,update_value)}
      Future{Ok("hi")}
    }

}