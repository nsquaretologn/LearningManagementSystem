// @SOURCE:/home/chandrasekar/Desktop/Independent_Study/Mti_Chat_Room/play-scala-intro/conf/routes
// @HASH:9e951272fe17826c4fb9616c5654de1a907625ac
// @DATE:Tue Dec 08 15:43:37 EST 2015


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_PostsController_add_post0 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addpost"))))
        

// @LINE:7
private[this] lazy val controllers_PostsController_add_comment1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addcomment"))))
        

// @LINE:8
private[this] lazy val controllers_PostsController_edit_post2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editpost"))))
        

// @LINE:9
private[this] lazy val controllers_PostsController_edit_comment3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editcomment"))))
        

// @LINE:10
private[this] lazy val controllers_PostsController_delete_post4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deletepost"))))
        

// @LINE:11
private[this] lazy val controllers_PostsController_delete_comment5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deletecomment"))))
        

// @LINE:14
private[this] lazy val controllers_LectureController_add_lecture6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addlecture"))))
        

// @LINE:15
private[this] lazy val controllers_LectureController_edit_lecture7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editlecture"))))
        

// @LINE:16
private[this] lazy val controllers_LectureController_delete_lecture8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deletelecture"))))
        

// @LINE:19
private[this] lazy val controllers_AssignmentController_add_assignment9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addassignment"))))
        

// @LINE:20
private[this] lazy val controllers_AssignmentController_edit_assignment10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editassignment"))))
        

// @LINE:21
private[this] lazy val controllers_AssignmentController_delete_assignment11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteassignment"))))
        

// @LINE:24
private[this] lazy val controllers_PostsController_getPost12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post"))))
        

// @LINE:25
private[this] lazy val controllers_AssignmentController_getAssignment13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assignment"))))
        

// @LINE:26
private[this] lazy val controllers_LectureController_getLecture14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("lecture"))))
        

// @LINE:27
private[this] lazy val controllers_CourseController_getCourseInformation15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course"))))
        

// @LINE:29
private[this] lazy val controllers_CourseController_add_course16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addcourse"))))
        

// @LINE:30
private[this] lazy val controllers_CourseController_edit_course17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editcourse"))))
        
def documentation = List(("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addpost""","""controllers.PostsController.add_post"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addcomment""","""controllers.PostsController.add_comment"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editpost""","""controllers.PostsController.edit_post"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editcomment""","""controllers.PostsController.edit_comment"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deletepost""","""controllers.PostsController.delete_post"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deletecomment""","""controllers.PostsController.delete_comment"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addlecture""","""controllers.LectureController.add_lecture"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editlecture""","""controllers.LectureController.edit_lecture"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deletelecture""","""controllers.LectureController.delete_lecture"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addassignment""","""controllers.AssignmentController.add_assignment"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editassignment""","""controllers.AssignmentController.edit_assignment"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteassignment""","""controllers.AssignmentController.delete_assignment"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post""","""controllers.PostsController.getPost(course_id:Int, post_id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assignment""","""controllers.AssignmentController.getAssignment(course_id:Int, a_id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """lecture""","""controllers.LectureController.getLecture(course_id:Int, lecture_id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course""","""controllers.CourseController.getCourseInformation(course_id:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addcourse""","""controllers.CourseController.add_course"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editcourse""","""controllers.CourseController.edit_course""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_PostsController_add_post0(params) => {
   call { 
        invokeHandler(controllers.PostsController.add_post, HandlerDef(this, "controllers.PostsController", "add_post", Nil,"POST", """ Home page""", Routes.prefix + """addpost"""))
   }
}
        

// @LINE:7
case controllers_PostsController_add_comment1(params) => {
   call { 
        invokeHandler(controllers.PostsController.add_comment, HandlerDef(this, "controllers.PostsController", "add_comment", Nil,"POST", """""", Routes.prefix + """addcomment"""))
   }
}
        

// @LINE:8
case controllers_PostsController_edit_post2(params) => {
   call { 
        invokeHandler(controllers.PostsController.edit_post, HandlerDef(this, "controllers.PostsController", "edit_post", Nil,"POST", """""", Routes.prefix + """editpost"""))
   }
}
        

// @LINE:9
case controllers_PostsController_edit_comment3(params) => {
   call { 
        invokeHandler(controllers.PostsController.edit_comment, HandlerDef(this, "controllers.PostsController", "edit_comment", Nil,"POST", """""", Routes.prefix + """editcomment"""))
   }
}
        

// @LINE:10
case controllers_PostsController_delete_post4(params) => {
   call { 
        invokeHandler(controllers.PostsController.delete_post, HandlerDef(this, "controllers.PostsController", "delete_post", Nil,"POST", """""", Routes.prefix + """deletepost"""))
   }
}
        

// @LINE:11
case controllers_PostsController_delete_comment5(params) => {
   call { 
        invokeHandler(controllers.PostsController.delete_comment, HandlerDef(this, "controllers.PostsController", "delete_comment", Nil,"POST", """""", Routes.prefix + """deletecomment"""))
   }
}
        

// @LINE:14
case controllers_LectureController_add_lecture6(params) => {
   call { 
        invokeHandler(controllers.LectureController.add_lecture, HandlerDef(this, "controllers.LectureController", "add_lecture", Nil,"POST", """""", Routes.prefix + """addlecture"""))
   }
}
        

// @LINE:15
case controllers_LectureController_edit_lecture7(params) => {
   call { 
        invokeHandler(controllers.LectureController.edit_lecture, HandlerDef(this, "controllers.LectureController", "edit_lecture", Nil,"POST", """""", Routes.prefix + """editlecture"""))
   }
}
        

// @LINE:16
case controllers_LectureController_delete_lecture8(params) => {
   call { 
        invokeHandler(controllers.LectureController.delete_lecture, HandlerDef(this, "controllers.LectureController", "delete_lecture", Nil,"POST", """""", Routes.prefix + """deletelecture"""))
   }
}
        

// @LINE:19
case controllers_AssignmentController_add_assignment9(params) => {
   call { 
        invokeHandler(controllers.AssignmentController.add_assignment, HandlerDef(this, "controllers.AssignmentController", "add_assignment", Nil,"POST", """""", Routes.prefix + """addassignment"""))
   }
}
        

// @LINE:20
case controllers_AssignmentController_edit_assignment10(params) => {
   call { 
        invokeHandler(controllers.AssignmentController.edit_assignment, HandlerDef(this, "controllers.AssignmentController", "edit_assignment", Nil,"POST", """""", Routes.prefix + """editassignment"""))
   }
}
        

// @LINE:21
case controllers_AssignmentController_delete_assignment11(params) => {
   call { 
        invokeHandler(controllers.AssignmentController.delete_assignment, HandlerDef(this, "controllers.AssignmentController", "delete_assignment", Nil,"POST", """""", Routes.prefix + """deleteassignment"""))
   }
}
        

// @LINE:24
case controllers_PostsController_getPost12(params) => {
   call(params.fromQuery[Int]("course_id", None), params.fromQuery[Int]("post_id", None)) { (course_id, post_id) =>
        invokeHandler(controllers.PostsController.getPost(course_id, post_id), HandlerDef(this, "controllers.PostsController", "getPost", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """post"""))
   }
}
        

// @LINE:25
case controllers_AssignmentController_getAssignment13(params) => {
   call(params.fromQuery[Int]("course_id", None), params.fromQuery[Int]("a_id", None)) { (course_id, a_id) =>
        invokeHandler(controllers.AssignmentController.getAssignment(course_id, a_id), HandlerDef(this, "controllers.AssignmentController", "getAssignment", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """assignment"""))
   }
}
        

// @LINE:26
case controllers_LectureController_getLecture14(params) => {
   call(params.fromQuery[Int]("course_id", None), params.fromQuery[Int]("lecture_id", None)) { (course_id, lecture_id) =>
        invokeHandler(controllers.LectureController.getLecture(course_id, lecture_id), HandlerDef(this, "controllers.LectureController", "getLecture", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """lecture"""))
   }
}
        

// @LINE:27
case controllers_CourseController_getCourseInformation15(params) => {
   call(params.fromQuery[Int]("course_id", None)) { (course_id) =>
        invokeHandler(controllers.CourseController.getCourseInformation(course_id), HandlerDef(this, "controllers.CourseController", "getCourseInformation", Seq(classOf[Int]),"GET", """""", Routes.prefix + """course"""))
   }
}
        

// @LINE:29
case controllers_CourseController_add_course16(params) => {
   call { 
        invokeHandler(controllers.CourseController.add_course, HandlerDef(this, "controllers.CourseController", "add_course", Nil,"POST", """""", Routes.prefix + """addcourse"""))
   }
}
        

// @LINE:30
case controllers_CourseController_edit_course17(params) => {
   call { 
        invokeHandler(controllers.CourseController.edit_course, HandlerDef(this, "controllers.CourseController", "edit_course", Nil,"POST", """""", Routes.prefix + """editcourse"""))
   }
}
        
}

}
     