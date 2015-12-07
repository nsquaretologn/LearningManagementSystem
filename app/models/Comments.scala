package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._


/**
 * A message class
 *
 * @param _id The BSON object id of the message
 * @param message The message
 */



case class Comments(
  id:Int,
  user_initials:String,
  comment_string: String,
  uploaded_date: String
) 

object Comments {

  implicit val messageFormat = Json.format[Comments]
}