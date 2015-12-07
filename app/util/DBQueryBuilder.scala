package util

import play.api.libs.json.{Writes, Json, JsObject}
import play.modules.reactivemongo.json.BSONFormats._

object DBQueryBuilder {

def push[T](field: String, data: T)(implicit writer: Writes[T]): JsObject = Json.obj("$push" -> Json.obj(field -> data))

def pull[T](field: String, query: T)(implicit writer: Writes[T]): JsObject = Json.obj("$pull" -> Json.obj(field -> query))

def set(data: JsObject): JsObject = Json.obj("$set" -> data)



}
