
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[CreatePersonForm],Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(person: Form[CreatePersonForm])(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.63*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Welcome to Play")/*5.25*/ {_display_(Seq[Any](format.raw/*5.27*/("""
	"""),format.raw/*6.2*/("""<script type='text/javascript' src='"""),_display_(/*6.39*/routes/*6.45*/.Assets.versioned("javascripts/index.js")),format.raw/*6.86*/("""'></script>

	<ul id="persons"></ul>

  """),_display_(/*10.4*/form(routes.PersonController.addPerson())/*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
		"""),_display_(/*11.4*/inputText(person("name"))),format.raw/*11.29*/("""
		"""),_display_(/*12.4*/inputText(person("age"))),format.raw/*12.28*/("""

		"""),format.raw/*14.3*/("""<div class="buttons">
			<input type="submit" value="Add Person"/>
		</div>
	""")))}),format.raw/*17.3*/("""
""")))}),format.raw/*18.2*/("""
"""))
      }
    }
  }

  def render(person:Form[CreatePersonForm],messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(person)(messages)

  def f:((Form[CreatePersonForm]) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (person) => (messages) => apply(person)(messages)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Nov 23 15:31:11 EST 2015
                  SOURCE: /home/chandrasekar/Desktop/Independent_Study/Mti_Chat_Room/play-scala-intro/app/views/index.scala.html
                  HASH: 0b6677a3c3b4e089fc232c815547d2dc90ec0953
                  MATRIX: 552->1|723->62|751->81|778->83|809->106|848->108|876->110|939->147|953->153|1014->194|1081->235|1131->276|1171->278|1201->282|1247->307|1277->311|1322->335|1353->339|1461->417|1493->419
                  LINES: 20->1|25->1|27->4|28->5|28->5|28->5|29->6|29->6|29->6|29->6|33->10|33->10|33->10|34->11|34->11|35->12|35->12|37->14|40->17|41->18
                  -- GENERATED --
              */
          