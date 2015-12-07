package controllers

import play.api.Logger
import play.api.mvc._
import play.api.libs.json.{Writes, Json, JsObject,JsString,JsNumber,JsValue}
import play.api.libs.concurrent.Execution.Implicits._
import models._
import services.PostsDao
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




object LectureController extends Controller {





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
    def add_lecture = Action.async(parse.multipartFormData) { 

    //Parse the input
    request =>
       
       println("request type is "+request.body)
        var course_id: Int = 0
        parse_value_body(request.body,"c_id") match {
          case Some(f) => {course_id = f.toInt 
          println("course_id is"+ course_id) }
        }


        // request.body.dataParts.get("c_id").get.foreach(value => course_id = value.toInt)

        var lec_id: Int = 0
        parse_value_body(request.body,"c_id") match {
          case Some(f) => {course_id = f.toInt 
          println("course_id is"+ course_id) }
        }        
        request.body.dataParts.get("lec_id").get.foreach(value => lec_id = value.toInt  )

        var l_topic = ""
        request.body.dataParts.get("l_topic").get.foreach(value => l_topic = value)

        var l_uploaded_date = ""
        request.body.dataParts.get("l_uploaded_date").get.foreach(value => l_uploaded_date = value)

        var l_summary = ""
        request.body.dataParts.get("l_summary").get.foreach(value => l_summary = value)

       // Upload lecture to ftp server:
      request.body.file("file_upload").map { 

        video =>

        val videoFilename = video.filename

        println(videoFilename)

        val contentType = video.contentType.get

        val destination_file_name= "/home/"+course_id+"/"+lec_id +"/lectures/" + video.filename 

        video.ref.moveTo(new File(destination_file_name),true)

        val filter_condition = Json.obj("id" -> course_id)

        val update_value = DBQueryBuilder.push("lectures",Lectures(lec_id,l_topic,l_uploaded_date,l_summary,destination_file_name))

        PostsDao.update_post(filter_condition,update_value)

     }.getOrElse {        Ok("Sorry Could not upload file")
      }      

      Future{Ok("hi")}
            
    }

  // Edit Lecture
 	def edit_lecture = Action.async(parse.multipartFormData) { 

      request=>
       
        var edit_inputs = List[(String,JsValue)]()
        
        var c_id:Int=0
        var l_id:Int=0
        parse_value_body(request.body,"c_id") match {
          case Some(course_id) => {edit_inputs = ("lectures.$.id"-> JsNumber(course_id.toInt)) :: edit_inputs
                                   c_id =course_id.toInt}
          case None => None
        }
       
        parse_value_body(request.body,"lec_id") match {
          case Some(lec_id) => {edit_inputs = ("lectures.$.lec_id"->JsNumber(lec_id.toInt)) :: edit_inputs
                               l_id=lec_id.toInt}
          case None => None
        }       
        
        parse_value_body(request.body,"l_topic") match {
          case Some(l_topic) => {edit_inputs = ("lectures.$.l_topic"-> JsString(l_topic)):: edit_inputs}
          case None => None
        }         

        parse_value_body(request.body,"l_uploaded_date") match {
          case Some(l_uploaded_date) => {edit_inputs = ("lectures.$.l_uploaded_date"->JsString(l_uploaded_date)):: edit_inputs}
          case None => None
        } 

        parse_value_body(request.body,"l_summary") match {
          case Some(l_summary) => {edit_inputs = ("lectures.$.l_summary"->JsString(l_summary)):: edit_inputs}
          case None => None
        }         


       // Upload lecture to ftp server:
      request.body.file("file_upload").map { 

        video =>

        val videoFilename = video.filename

        val contentType = video.contentType.get

        val destination_file_name= "/home/"+c_id+"/"+l_id +"/lectures/" + video.filename 

        video.ref.moveTo(new File(destination_file_name),true)

        edit_inputs = ("lectures.$.l_files"->JsString(destination_file_name)) :: edit_inputs         

       }.getOrElse {
        Ok("Sorry Could not upload file")
               }      

        val filter_condition = Json.obj("id" -> c_id,"lectures.id" -> l_id)

        val update_value = DBQueryBuilder.set(JsObject(edit_inputs))

        println(update_value)

        println(filter_condition)

        PostsDao.update_post(filter_condition,update_value)

        Future{Ok("hi")}
    }
    

  // //View Lecture
 	// def view_lecture = Action.async(parse.json) { 


  //   }




  //Delete Lecture
 	def delete_lecture = Action.async(parse.json) { 

           req =>
           // Course  Id
      val c_id = (req.body \ "c_id").as[Int]
      
              // Lecture Id
      val l_id =(req.body \ "l_id").as[Int]
  
      val filter_condition = Json.obj("id" -> c_id)
      val query_json_object= Json.obj("id" -> l_id)

      val update_value = DBQueryBuilder.pull("lectures",query_json_object)      





      println(filter_condition)
      println(update_value)

      PostsDao.update_post(filter_condition,update_value)

      Future{Ok("hi")}


    }

}