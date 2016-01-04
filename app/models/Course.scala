package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._
import models._


case class Course(
	id: Int,
	c_name:String,
	c_inst_id:Int,
	c_summary:String,
	lectures:List[Lectures],
	assignments:List[Assignments],
	post:List[Post]
	)

object Course {
  implicit val messageFormat = Json.format[Course]
}