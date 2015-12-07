package models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._

case class User_Info_Pojo(
  id:Int,
  e_mail:String,
  f_name:String,
  l_name:String,
  profile_pic:String
)

object User_Info_Pojo {
  /**
   * Format for the message.
   *
   * Used both by JSON library and reactive mongo to serialise/deserialise a message.
   */
  implicit val messageFormat = Json.format[User_Info_Pojo]
}