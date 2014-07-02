package controllers

import play.api._
import play.api.mvc._

object Application extends Controller with Security {

  lazy val siteDomain = app.configuration.getString("site.domain").getOrElse("ofpay.com")

  def index = Action { implicit request =>
    Ok(views.html.index(siteDomain))
  }

  def javascriptRoutes = Action { implicit request =>
    import controllers._
    Ok(
      Routes.javascriptRouter("PlayRoutes")(
        // user
        conf.routes.javascript.UserController.index,
        conf.routes.javascript.UserController.count,
        conf.routes.javascript.UserController.show,
        conf.routes.javascript.UserController.permissions,
        conf.routes.javascript.UserController.save,
        conf.routes.javascript.UserController.update,
        conf.routes.javascript.UserController.delete,

        // env
        conf.routes.javascript.EnvController.index,
        conf.routes.javascript.EnvController.all,
        conf.routes.javascript.EnvController.count,
        conf.routes.javascript.EnvController.show,
        conf.routes.javascript.EnvController.save,
        conf.routes.javascript.EnvController.update,
        conf.routes.javascript.EnvController.delete,

        // project
        conf.routes.javascript.ProjectController.show,
        conf.routes.javascript.ProjectController.all,
        conf.routes.javascript.ProjectController.save,
        conf.routes.javascript.ProjectController.index,
        conf.routes.javascript.ProjectController.count,
        conf.routes.javascript.ProjectController.update,
        conf.routes.javascript.ProjectController.atts,

        // template
        conf.routes.javascript.TemplateController.all,
        conf.routes.javascript.TemplateController.save,
        conf.routes.javascript.TemplateController.delete,
        conf.routes.javascript.TemplateController.show,
        conf.routes.javascript.TemplateController.update,
        // template item
        conf.routes.javascript.TemplateController.items,

        // version
        conf.routes.javascript.VersionController.index,
        conf.routes.javascript.VersionController.count,
        conf.routes.javascript.VersionController.show,
        conf.routes.javascript.VersionController.delete,
        conf.routes.javascript.VersionController.save,
        conf.routes.javascript.VersionController.update,
        conf.routes.javascript.VersionController.all,

        //task
        task.routes.javascript.TaskController.findLastTaskStatus,
        task.routes.javascript.TaskController.joinProcess,
        task.routes.javascript.TaskController.getVersions,
        task.routes.javascript.TaskController.createNewTaskQueue
      )
    ).as(JAVASCRIPT)
  }

}