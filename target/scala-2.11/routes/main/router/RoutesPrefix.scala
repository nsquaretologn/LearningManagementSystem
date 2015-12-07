
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/chandrasekar/Desktop/Independent_Study/Mti_Chat_Room/play-scala-intro/conf/routes
// @DATE:Mon Nov 23 15:31:11 EST 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
