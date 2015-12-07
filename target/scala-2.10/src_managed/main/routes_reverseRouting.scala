// @SOURCE:/home/chandrasekar/Desktop/Independent_Study/Mti_Chat_Room/play-scala-intro/conf/routes
// @HASH:7749735eed6ac5de890af0ea65152bcc372d62d6
// @DATE:Mon Dec 07 09:22:06 EST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:27
// @LINE:26
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:16
// @LINE:15
// @LINE:14
class ReverseLectureController {
    

// @LINE:16
def delete_lecture(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deletelecture")
}
                                                

// @LINE:15
def edit_lecture(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "editlecture")
}
                                                

// @LINE:14
def add_lecture(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addlecture")
}
                                                
    
}
                          

// @LINE:26
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReversePostsController {
    

// @LINE:6
def add_post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addpost")
}
                                                

// @LINE:26
def getPosts(course_id:Int, post_id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "posts" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("course_id", course_id)), Some(implicitly[QueryStringBindable[Int]].unbind("post_id", post_id)))))
}
                                                

// @LINE:11
def delete_comment(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deletecomment")
}
                                                

// @LINE:9
def edit_comment(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "editcomment")
}
                                                

// @LINE:8
def edit_post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "editpost")
}
                                                

// @LINE:10
def delete_post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deletepost")
}
                                                

// @LINE:7
def add_comment(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addcomment")
}
                                                
    
}
                          

// @LINE:27
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseAssignmentController {
    

// @LINE:21
def delete_assignment(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deleteassignment")
}
                                                

// @LINE:20
def edit_assignment(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "editassignment")
}
                                                

// @LINE:19
def add_assignment(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addassignment")
}
                                                

// @LINE:27
def getAssignment(course_id:Int, a_id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assignment" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("course_id", course_id)), Some(implicitly[QueryStringBindable[Int]].unbind("a_id", a_id)))))
}
                                                
    
}
                          
}
                  


// @LINE:27
// @LINE:26
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:16
// @LINE:15
// @LINE:14
class ReverseLectureController {
    

// @LINE:16
def delete_lecture : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LectureController.delete_lecture",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletelecture"})
      }
   """
)
                        

// @LINE:15
def edit_lecture : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LectureController.edit_lecture",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editlecture"})
      }
   """
)
                        

// @LINE:14
def add_lecture : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LectureController.add_lecture",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addlecture"})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReversePostsController {
    

// @LINE:6
def add_post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostsController.add_post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addpost"})
      }
   """
)
                        

// @LINE:26
def getPosts : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostsController.getPosts",
   """
      function(course_id,post_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "posts" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("course_id", course_id), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("post_id", post_id)])})
      }
   """
)
                        

// @LINE:11
def delete_comment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostsController.delete_comment",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletecomment"})
      }
   """
)
                        

// @LINE:9
def edit_comment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostsController.edit_comment",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editcomment"})
      }
   """
)
                        

// @LINE:8
def edit_post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostsController.edit_post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editpost"})
      }
   """
)
                        

// @LINE:10
def delete_post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostsController.delete_post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletepost"})
      }
   """
)
                        

// @LINE:7
def add_comment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PostsController.add_comment",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addcomment"})
      }
   """
)
                        
    
}
              

// @LINE:27
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseAssignmentController {
    

// @LINE:21
def delete_assignment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AssignmentController.delete_assignment",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteassignment"})
      }
   """
)
                        

// @LINE:20
def edit_assignment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AssignmentController.edit_assignment",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editassignment"})
      }
   """
)
                        

// @LINE:19
def add_assignment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AssignmentController.add_assignment",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addassignment"})
      }
   """
)
                        

// @LINE:27
def getAssignment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AssignmentController.getAssignment",
   """
      function(course_id,a_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assignment" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("course_id", course_id), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("a_id", a_id)])})
      }
   """
)
                        
    
}
              
}
        


// @LINE:27
// @LINE:26
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:16
// @LINE:15
// @LINE:14
class ReverseLectureController {
    

// @LINE:16
def delete_lecture(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LectureController.delete_lecture(), HandlerDef(this, "controllers.LectureController", "delete_lecture", Seq(), "POST", """""", _prefix + """deletelecture""")
)
                      

// @LINE:15
def edit_lecture(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LectureController.edit_lecture(), HandlerDef(this, "controllers.LectureController", "edit_lecture", Seq(), "POST", """""", _prefix + """editlecture""")
)
                      

// @LINE:14
def add_lecture(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LectureController.add_lecture(), HandlerDef(this, "controllers.LectureController", "add_lecture", Seq(), "POST", """""", _prefix + """addlecture""")
)
                      
    
}
                          

// @LINE:26
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReversePostsController {
    

// @LINE:6
def add_post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostsController.add_post(), HandlerDef(this, "controllers.PostsController", "add_post", Seq(), "POST", """ Home page""", _prefix + """addpost""")
)
                      

// @LINE:26
def getPosts(course_id:Int, post_id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostsController.getPosts(course_id, post_id), HandlerDef(this, "controllers.PostsController", "getPosts", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """posts""")
)
                      

// @LINE:11
def delete_comment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostsController.delete_comment(), HandlerDef(this, "controllers.PostsController", "delete_comment", Seq(), "POST", """""", _prefix + """deletecomment""")
)
                      

// @LINE:9
def edit_comment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostsController.edit_comment(), HandlerDef(this, "controllers.PostsController", "edit_comment", Seq(), "POST", """""", _prefix + """editcomment""")
)
                      

// @LINE:8
def edit_post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostsController.edit_post(), HandlerDef(this, "controllers.PostsController", "edit_post", Seq(), "POST", """""", _prefix + """editpost""")
)
                      

// @LINE:10
def delete_post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostsController.delete_post(), HandlerDef(this, "controllers.PostsController", "delete_post", Seq(), "POST", """""", _prefix + """deletepost""")
)
                      

// @LINE:7
def add_comment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PostsController.add_comment(), HandlerDef(this, "controllers.PostsController", "add_comment", Seq(), "POST", """""", _prefix + """addcomment""")
)
                      
    
}
                          

// @LINE:27
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseAssignmentController {
    

// @LINE:21
def delete_assignment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AssignmentController.delete_assignment(), HandlerDef(this, "controllers.AssignmentController", "delete_assignment", Seq(), "POST", """""", _prefix + """deleteassignment""")
)
                      

// @LINE:20
def edit_assignment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AssignmentController.edit_assignment(), HandlerDef(this, "controllers.AssignmentController", "edit_assignment", Seq(), "POST", """""", _prefix + """editassignment""")
)
                      

// @LINE:19
def add_assignment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AssignmentController.add_assignment(), HandlerDef(this, "controllers.AssignmentController", "add_assignment", Seq(), "POST", """""", _prefix + """addassignment""")
)
                      

// @LINE:27
def getAssignment(course_id:Int, a_id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AssignmentController.getAssignment(course_id, a_id), HandlerDef(this, "controllers.AssignmentController", "getAssignment", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """assignment""")
)
                      
    
}
                          
}
        
    