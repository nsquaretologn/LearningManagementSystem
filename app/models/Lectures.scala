package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._



case class Lectures(
	id: Int,
	l_topic:String,
	l_uploaded_date:String,
	l_summary:String,
	l_files:String
	)

object Lectures {
  implicit val messageFormat = Json.format[Lectures]
}