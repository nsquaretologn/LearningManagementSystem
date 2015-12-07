package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._

case class Assignments(
	id: Int,
	a_topic:String,
	a_uploaded_date:String,
	a_due_date:String,
	a_descripton:String,
	a_uploaded_file:String,
	a_total_marks:Int
)


object Assignments {
  implicit val messageFormat = Json.format[Assignments]
}