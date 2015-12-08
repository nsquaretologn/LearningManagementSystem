package controllers

import play.api.Logger
import play.api.mvc._
import play.api.libs.json.{Writes, Json, JsObject}
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
import util._




object PostsController extends Controller {

  // Add Post
    def add_post = Action.async(parse.json) { 

       req =>
      // All inputs required for adding a post
      val c_id = (req.body \ "id").as[Int]
      val user_id = (req.body \ "u_id").as[Int]
      val e_mail = (req.body \ "e_mail").as[String]
      val f_name =(req.body \ "f_name").as[String]
      val l_name =(req.body \ "l_name").as[String]  
      val profile_pic = (req.body \ "profile_pic").as[String]
      val p_text = (req.body \ "p_text").as[String]
      val p_uploaded_time = new SimpleDateFormat("mm/dd/yy").format(new Date())
      val p_likes=0
      val p_user = User_Info_Pojo(user_id,e_mail,f_name,l_name,profile_pic)

      val filter_condition = Json.obj("id" -> c_id)

      val update_value = DBQueryBuilder.push("post",Post(2, p_user, p_uploaded_time, p_likes, p_text,List()))

      var response = ""

      PostsDao.update_post(filter_condition,update_value).onComplete {
          case Success(posts) => {response = "Posted"}
          case Failure(t) => {response = "Error Not Posted"}

      }

      Future{Ok(response)}
    }
  // Add a Comment
    def add_comment = Action.async(parse.json) { 

      req =>

      // Inputs for adding a comment:

      val com_id = (req.body \ "com_id").as[Int]
      val com_text = (req.body \ "com_text").as[String]
      val c_id = (req.body \ "c_id").as[Int]
      val p_id =(req.body \ "p_id").as[Int]
      val user_initials = (req.body \ "initial").as[String]
      val uploaded_date = new SimpleDateFormat("mm/dd/yy").format(new Date())
      
      val filter_condition = Json.obj("id"->c_id,"post.id"->p_id)

      val query_condition =DBQueryBuilder.push("post.$.p_comments",Comments(com_id,user_initials,com_text,uploaded_date))

      println("Query Condition is"+query_condition)

      println("Filter Condition is"+filter_condition)

      PostsDao.update_post(filter_condition,query_condition)

      Future{Ok("hi")}

      }

      
  // // Edit a Post
    def edit_post = Action.async(parse.json) { 

       req =>
      // All inputs required for editing a post
      val c_id = (req.body \ "id").as[Int]
      val user_id = (req.body \ "u_id").as[Int]
      val e_mail = (req.body \ "e_mail").as[String]
      val f_name =(req.body \ "f_name").as[String]
      val l_name =(req.body \ "l_name").as[String]  
      val profile_pic = (req.body \ "profile_pic").as[String]
      val p_text = (req.body \ "p_text").as[String]
      val p_id =(req.body \ "p_id").as[Int]
      val p_uploaded_time = new SimpleDateFormat("mm/dd/yy").format(new Date())   
      val p_likes=(req.body \ "p_likes").as[Int]
      val p_user = User_Info_Pojo(user_id,e_mail,f_name,l_name,profile_pic)
      val filter_condition = Json.obj("id" -> c_id,"post.id" -> p_id)
      val query_json_object = Json.obj("post.$.id"->p_id,"post.$.p_user"->p_user,"post.$.p_uploaded_time"-> p_uploaded_time ,"post.$.p_likes"->p_likes,"post.$.p_text"->p_text)
      val update_value = DBQueryBuilder.set(query_json_object)      
      PostsDao.update_post(filter_condition,update_value)
      Future{Ok("hi")}
    }



  // Edit a Comment
    def edit_comment = Action.async(parse.json) { 

      req =>
      // Inputs for editing a comment:

      val com_id = (req.body \ "com_id").as[Int]
      val com_text = (req.body \ "com_text").as[String]
      val c_id = (req.body \ "c_id").as[Int]
      val p_id =(req.body \ "p_id").as[Int]
      val user_initials = (req.body \ "initial").as[String]
      val uploaded_date = new SimpleDateFormat("mm/dd/yy").format(new Date())
      
      val filter_condition = Json.obj("id"->c_id,"post.id"->p_id)

      val query_json_object = Json.obj("post.$.p_comments."+(com_id-1)+".id"->com_id,"post.$.p_comments."+(com_id-1)+".user_initials"->user_initials,"post.$.p_comments."+(com_id-1)+".comment_string"-> com_text ,"post.$.p_comments."+(com_id-1)+".uploaded_date"->uploaded_date)

      val update_value = DBQueryBuilder.set(query_json_object)      

      PostsDao.update_post(filter_condition,update_value)

      Future{ Ok("hi") } 


    }

  // Delete a Post
    def delete_post = Action.async(parse.json) { 

       req =>

      val c_id = (req.body \ "c_id").as[Int]
      val p_id =(req.body \ "p_id").as[Int]
  
      val filter_condition = Json.obj("id" -> c_id)
      val query_json_object= Json.obj("id" -> p_id)

      val update_value = DBQueryBuilder.pull("post",query_json_object)      

      println(filter_condition)
      println(update_value)

      PostsDao.update_post(filter_condition,update_value)

      Future{ Ok("hi") }  

    }

    // Delete a Comment
    def delete_comment = Action.async(parse.json) { 

         req =>

      val c_id = (req.body \ "c_id").as[Int]
      val p_id =(req.body \ "p_id").as[Int]
      val com_id =(req.body \ "com_id").as[Int]
      val filter_condition = Json.obj("id" -> c_id,"post.id" -> p_id)
      val query_json_object= Json.obj("id"->com_id)

      val update_value = DBQueryBuilder.pull("post.$.p_comments",query_json_object)      

      PostsDao.update_post(filter_condition,update_value)

      Future{ Ok("hi") }  

    }


// View the Post

  /** Get Posts and Comment List */
  def getPost(course_id:Int,post_id:Int) = Action.async{ 
 
          val messages = PostsDao.findPosts(course_id,post_id)
          
          messages.onComplete
          {
             case p_user=>  println(p_user)
                     //When a person's profile is successfully returned, insert his post information in to the database
                      // PostsDao.save(Post(id,p_user.head,p_uploaded_time,p_likes,p_text)).map(_ => Created)
                      // val post = Post(id,p_user.head,p_uploaded_time,p_likes,p_text)
                      // println(Json.toJson(post))     
                      
          }

          Future{ Ok("hi") }  

          

}  




// View the Posts


// Get Post Comments

 
// Like a Post from a person


//   /** Action to get the messages */
//   def getUserInfo(user_id:Int):Future[Seq[User]] =  {
//        for
//         {
//           count <- PostsDao.count
//           //Give the user id of the person as input here
//           messages <- PostsDao.findUser(user_id)
//         } 
//         yield 
//           {
//           messages
//           }
// }  



  /**
   * The message form.  This is separate from the database message since the form doesn't have an ID.
   */

  // case class MessageForm(messa: String) {
  //   def toMessage: Post = Post(BSONObjectID.generate, messa)
  // }

   // implicit val messageFormFormat = Json.format[Post]

 //  /** Action to save a message */
 //  def saveMessage = Action.async(parse.json) { 

 //    req => 

 //      // Define all the Inputs here 
 //        val id= (req.body \ "id").as[Int]
 //        println(id)
        

 //        val p_uploaded_time = new SimpleDateFormat("mm/dd/yy").format(new Date()); 
 //        val p_likes=0
 //        val p_text=(req.body \ "posts").as[String]

 //      // //Get the user Information
 //      val actioninfo = PostsDao.findUser(2)

      
 //      actioninfo.onComplete
 //      {
 //         case p_user=> 
 //                 //When a person's profile is successfully returned, insert his post information in to the database
 //                  // PostsDao.save(Post(id,p_user.head,p_uploaded_time,p_likes,p_text)).map(_ => Created)
 //                  // val post = Post(id,p_user.head,p_uploaded_time,p_likes,p_text)
 //                  // println(Json.toJson(post))     
 //                  println(p_user)
 //      }

 //      Future{Ok("hi")}

 // }




 def index = Action {
    Ok("It works!")
  }

}