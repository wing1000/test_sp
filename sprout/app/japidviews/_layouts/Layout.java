package japidviews._layouts;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import static play.templates.JavaExtensions.*;
import static cn.bran.play.JapidPlayAdapter.*;
import static play.data.validation.Validation.*;
import japidviews._layouts.*;
import play.i18n.Messages;
import play.data.validation.Validation;
import static japidviews._javatags.Pic.*;
import play.mvc.Scope.*;
import models.*;
import play.data.validation.Error;
import play.i18n.Lang;
import japidviews._tags.*;
import play.mvc.Http.*;
import controllers.*;
import japidviews._javatags.*;
//
// NOTE: This file was generated from: japidviews/_layouts/Layout.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public abstract class Layout extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/_layouts/Layout.html";
	{
		putHeader("Content-Type", "text/html; charset=utf-8");
		setContentType("text/html; charset=utf-8");
	}

// - add implicit fields with Play

	final play.mvc.Http.Request request = play.mvc.Http.Request.current(); 
	final play.mvc.Http.Response response = play.mvc.Http.Response.current(); 
	final play.mvc.Scope.Session session = play.mvc.Scope.Session.current();
	final play.mvc.Scope.RenderArgs renderArgs = play.mvc.Scope.RenderArgs.current();
	final play.mvc.Scope.Params params = play.mvc.Scope.Params.current();
	final play.data.validation.Validation validation = play.data.validation.Validation.current();
	final cn.bran.play.FieldErrors errors = new cn.bran.play.FieldErrors(validation);
	final play.Play _play = new play.Play(); 

// - end of implicit fields with Play 


	public Layout() {
		super(null);
	}
	public Layout(StringBuilder out) {
		super(out);
	}
	@Override public void layout() {
		beginDoLayout(sourceTemplate);		p("<!DOCTYPE html>\n");// line 1, japidviews\_layouts\Layout.html
		p("<html lang=\"en\">\n" + 
"<head>\n" + 
"    <meta charset=\"UTF-8\">\n" + 
"    ");// line 2, japidviews\_layouts\Layout.html
		String appName=i18n("web.app.name");// line 6, japidviews\_layouts\Layout.html
    String keywords=i18n("web.keywords");// line 7, japidviews\_layouts\Layout.html
    String desc=i18n("web.desc");// line 8, japidviews\_layouts\Layout.html
		p("    <title>");// line 8, japidviews\_layouts\Layout.html
		try { p(appName); } catch (NullPointerException npe) {}// line 9, japidviews\_layouts\Layout.html
		p(" / ");// line 9, japidviews\_layouts\Layout.html
		title();p(" </title>\n" + 
"    <meta name=\"keywords\" content=\"");// line 9, japidviews\_layouts\Layout.html
		try { p(keywords); } catch (NullPointerException npe) {}// line 10, japidviews\_layouts\Layout.html
		p(",");// line 10, japidviews\_layouts\Layout.html
		keywords();p("\"/>\n" + 
"    <meta name=\"description\" content=\"");// line 10, japidviews\_layouts\Layout.html
		desc();p(" ----  ");// line 11, japidviews\_layouts\Layout.html
		try { p(desc); } catch (NullPointerException npe) {}// line 11, japidviews\_layouts\Layout.html
		p("\"/>\n" + 
"    <meta name=\"viewport\" content=\"width=1240, maximum-scale=1.5\"/>\n" + 
"    <link rel=\"stylesheet\" media=\"screen\" href=\"");// line 11, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/bootstrap/css/bootstrap.min.css"));// line 13, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    <!--\n" + 
"    <link rel=\"stylesheet\" media=\"screen\" 	href=\"");// line 13, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/bootstrap/css/bootstrap-responsive.min.css"));// line 15, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    -->\n" + 
"    <script src=\"");// line 15, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/js/jquery-1.10.2.js"));// line 17, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 17, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/js/jquery-migrate-1.2.1.js"));// line 18, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 18, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/blueimp/md5.min.js"));// line 19, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 19, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/js/jquery.form.js"));// line 20, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 20, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/bootstrap/js/bootstrap.min.js"));// line 21, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 21, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/js/jquery.easing.1.3.min.js"));// line 22, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 22, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/js/jquery.bootstrap-growl.js"));// line 23, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <link rel=\"stylesheet\" media=\"screen\" href=\"");// line 23, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/styles/app.css"));// line 24, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    <link rel=\"stylesheet\" media=\"screen\" href=\"");// line 24, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/styles/photo.css"));// line 25, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    <link rel=\"stylesheet\" media=\"screen\" href=\"");// line 25, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/styles/grid1200.css"));// line 26, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    <link rel=\"stylesheet\" media=\"screen\" href=\"");// line 26, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/styles/fluid20.css"));// line 27, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    <script src=\"");// line 27, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/app/app.js"));// line 28, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 28, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/app/utils.js"));// line 29, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <script src=\"");// line 29, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/app/i18n.js"));// line 30, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"    <!--[if lte IE 6]>\n" + 
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"");// line 30, japidviews\_layouts\Layout.html
		p(lookupStatic("public/bootstrap/css/bootstrap-ie6.css"));// line 32, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    <![endif]-->\n" + 
"    <!--[if lte IE 7]>\n" + 
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"");// line 32, japidviews\_layouts\Layout.html
		p(lookupStatic("public/bootstrap/css/ie.css"));// line 35, japidviews\_layouts\Layout.html
		p("\">\n" + 
"    <![endif]-->\n" + 
"    <!--[if IE 6]>\n" + 
"    <link href=\"");// line 35, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/styles/app.ie6.css"));// line 38, japidviews\_layouts\Layout.html
		p("\" rel=\"stylesheet\" type=\"text/css\">\n" + 
"    <![endif]-->\n" + 
"    <!--[if IE 7]>\n" + 
"    <link href=\"");// line 38, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/styles/app.ie7.css"));// line 41, japidviews\_layouts\Layout.html
		p("\" rel=\"stylesheet\" type=\"text/css\">\n" + 
"    <![endif]-->\n" + 
"\n" + 
"    <!--[if lt IE 8]>\n" + 
"    <link rel=\"stylesheet\" href=\"");// line 41, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/bootstrap/css/bootstrap-ie7buttonfix.css"));// line 45, japidviews\_layouts\Layout.html
		p("\"><![endif]-->\n" + 
"    <!--[if IE 8]>\n" + 
"    <link rel=\"stylesheet\" href=\"");// line 45, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/bootstrap/css/bootstrap-ie8buttonfix.css"));// line 47, japidviews\_layouts\Layout.html
		p("\"><![endif]-->\n" + 
"\n" + 
"    <!--[if lt IE 9]>\n" + 
"    <script src=\"");// line 47, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/js/html5shiv.js"));// line 50, japidviews\_layouts\Layout.html
		p("\"></script>\n" + 
"    <![endif]-->\n" + 
"    <!--[if lte IE 6]>\n" + 
"    <script type=\"text/javascript\" src=\"");// line 50, japidviews\_layouts\Layout.html
		p(lookupStatic("public/bootstrap/js/bootstrap-ie.js"));// line 53, japidviews\_layouts\Layout.html
		p("\"></script>\n" + 
"    <![endif]-->\n" + 
"\n" + 
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"");// line 53, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/bootstrap/select/bootstrap-select.min.css"));// line 56, japidviews\_layouts\Layout.html
		p("\"/>\n" + 
"    <script src=\"");// line 56, japidviews\_layouts\Layout.html
		p(lookupStatic("/public/bootstrap/select/bootstrap-select.js"));// line 57, japidviews\_layouts\Layout.html
		p("\" type=\"text/javascript\"></script>\n" + 
"\n" + 
"    ");// line 57, japidviews\_layouts\Layout.html
		css();p("</head>\n" + 
"\n" + 
"<body>\n" + 
"<div class=\"navbar navbar-inverse\">\n" + 
"    <div class=\"navbar-inner\">\n" + 
"\n" + 
"        <div class=\"grid_row\">\n" + 
"            <div class=\"col col_16 \">\n" + 
"                <a class=\"brand\" href=\"/\">Spruce</a>\n" + 
"\n" + 
"                <div class=\"nav-collapse collapse\">\n" + 
"                    <ul class=\"nav\">\n" + 
"                        <li>\n" + 
"                            <a href=\"/\">");// line 59, japidviews\_layouts\Layout.html
		;p(getMessage("home"));// line 73, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                        </li>\n" + 
"                        <li>\n" + 
"                            <a href=\"/photos\">");// line 73, japidviews\_layouts\Layout.html
		;p(getMessage("photos"));// line 76, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                        </li>\n" + 
"\n" + 
"                        <li class=\"dropdown\" style=\"display: none\">\n" + 
"                            <a href=\"#\" class=\"dropdown-toggle\"\n" + 
"                               data-toggle=\"dropdown\">Photos <b class=\"caret\"></b></a>\n" + 
"                            <ul class=\"dropdown-menu\">\n" + 
"                                <li>\n" + 
"                                    <a href=\"/last\">Last</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/popular\">Popular</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/top\">Top</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/random\">Random</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/catalog\">Catalog</a>\n" + 
"                                </li>\n" + 
"                            </ul>\n" + 
"                        </li>\n" + 
"\n" + 
"                        <li class=\"dropdown\" style=\"display: none\">\n" + 
"                            <a href=\"#\" class=\"dropdown-toggle\"\n" + 
"                               data-toggle=\"dropdown\">Shop<b class=\"caret\"></b></a>\n" + 
"                            <ul class=\"dropdown-menu\">\n" + 
"                                <li>\n" + 
"                                    <a href=\"/shop/best\">Best</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/shop/bestSellers\">Best Sellers</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/shop/random\">Random</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/shop/catalog\">Catalog</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/shop/new\">New Show</a>\n" + 
"                                </li>\n" + 
"                            </ul>\n" + 
"                        </li>\n" + 
"\n" + 
"                    </ul>\n" + 
"                    <div class=\"nav\">\n" + 
"                        <form class=\"navbar-search span2\" action=\"/search\">\n" + 
"                            <input type=\"text\" class=\"search-query input-medium\" name=\"q\"\n" + 
"                                   placeholder=\"Search\">\n" + 
"                        </form>\n" + 
"                    </div>\n" + 
"\n" + 
"                    ");// line 76, japidviews\_layouts\Layout.html
		if (session.get(Admin.SESSION_LOGIN_KEY) == null) {// line 131, japidviews\_layouts\Layout.html
		p("                    <div class=\"nav pull-right\">\n" + 
"                        <div class=\"btn-group\">\n" + 
"                            <a href=\"/signup\" class=\"btn btn-success btn-small\"><i class=\"icon-arrow-up icon-white\"></i>&ensp;Signup</a>\n" + 
"                        </div>\n" + 
"                    </div>\n" + 
"                    <div class=\"nav pull-right\">\n" + 
"                        <div class=\"btn-group\">\n" + 
"                            <a class=\"btn btn-primary btn-small\" href=\"/login\"><i\n" + 
"                                    class=\"icon-user icon-white\"></i>&ensp;Login</a>\n" + 
"                        </div>\n" + 
"                        &ensp;\n" + 
"                    </div>\n" + 
"\n" + 
"                    ");// line 131, japidviews\_layouts\Layout.html
		}else{// line 145, japidviews\_layouts\Layout.html
		p("\n" + 
"                    <div class=\"nav pull-right\">\n" + 
"\n" + 
"                        <div class=\"btn-group\">\n" + 
"                            <a class=\"btn btn-primary btn-small\" href=\"/yours\">\n" + 
"                                ");// line 145, japidviews\_layouts\Layout.html
		String idUserStr=session.get(Admin.SESSION_USER_ID_KEY);// line 151, japidviews\_layouts\Layout.html
                                Integer idUser=Integer.parseInt(idUserStr);// line 152, japidviews\_layouts\Layout.html
		p("                                <img class=\"head_photo_18\"\n" + 
"                                     src=\"");// line 152, japidviews\_layouts\Layout.html
		try { p(fengfei.spruce.utils.PhotoPathUtils.getUserPhotoDownloadPath(idUser,1)); } catch (NullPointerException npe) {}// line 154, japidviews\_layouts\Layout.html
		p("\">\n" + 
"\n" + 
"                                ");// line 154, japidviews\_layouts\Layout.html
		try { p(session.get(Admin.SESSION_USER_NAME_KEY)); } catch (NullPointerException npe) {}// line 156, japidviews\_layouts\Layout.html
		p("</a><a\n" + 
"                                class=\"btn btn-primary btn-small dropdown-toggle\"\n" + 
"                                data-toggle=\"dropdown\" href=\"#\"><span class=\"caret\"></span></a>\n" + 
"\n" + 
"                            <ul class=\"dropdown-menu\">\n" + 
"                                <li>\n" + 
"                                    <a href=\"/yours\">\n" + 
"                                        <img class=\"img_shadow head_photo_64\"\n" + 
"                                             src=\"");// line 156, japidviews\_layouts\Layout.html
		try { p(fengfei.spruce.utils.PhotoPathUtils.getUserPhotoDownloadPath(idUser,1)); } catch (NullPointerException npe) {}// line 164, japidviews\_layouts\Layout.html
		p("\"/>\n" + 
"                                    </a>\n" + 
"\n" + 
"\n" + 
"                                </li>\n" + 
"\n" + 
"                                <li>\n" + 
"                                    <a href=\"/settings/profile\"><i class=\"icon-pencil\"></i> ");// line 164, japidviews\_layouts\Layout.html
		;p(getMessage("settings"));// line 171, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/account\"><i class=\"icon-trash\"></i> ");// line 171, japidviews\_layouts\Layout.html
		;p(getMessage("account"));// line 174, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/settings/profile\"><i class=\"icon-ban-circle\"></i> ");// line 174, japidviews\_layouts\Layout.html
		;p(getMessage("profile"));// line 177, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"                                <li><a href=\"/settings/password\"><i class=\"icon-ban-circle\"></i>");// line 177, japidviews\_layouts\Layout.html
		;p(getMessage("profile.menu.password"));// line 179, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"                                <li class=\"divider\"></li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/logout\"><i class=\"i\"></i> ");// line 179, japidviews\_layouts\Layout.html
		;p(getMessage("logout"));// line 183, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"                            </ul>\n" + 
"                        </div>\n" + 
"                    </div>\n" + 
"\n" + 
"                    <div class=\"nav pull-right\">\n" + 
"\n" + 
"                        <div class=\"btn-group\">\n" + 
"                            <a class=\"btn btn-success btn-small\" href=\"/add\"><i\n" + 
"                                    class=\" icon-share icon-white\"></i> ");// line 183, japidviews\_layouts\Layout.html
		;p(getMessage("add"));// line 193, japidviews\_layouts\Layout.html
		p("</a><a\n" + 
"                                class=\"btn btn-success btn-small dropdown-toggle\"\n" + 
"                                data-toggle=\"dropdown\" href=\"#\"><span class=\"caret\"></span></a>\n" + 
"\n" + 
"                            <ul class=\"dropdown-menu\">\n" + 
"                                <li>\n" + 
"                                    <a href=\"/upload\"><i class=\"icon-picture\"></i> ");// line 193, japidviews\_layouts\Layout.html
		;p(getMessage("add.photo"));// line 199, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/ps/upload\"><i class=\" icon-leaf\"></i> ");// line 199, japidviews\_layouts\Layout.html
		;p(getMessage("add.ps"));// line 202, japidviews\_layouts\Layout.html
		p(" </a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/story\"><i class=\"icon-th-large\"></i> ");// line 202, japidviews\_layouts\Layout.html
		;p(getMessage("add.story"));// line 205, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/blink\"><i class=\"icon-eye-open\"></i> ");// line 205, japidviews\_layouts\Layout.html
		;p(getMessage("add.blink"));// line 208, japidviews\_layouts\Layout.html
		p("</a>\n" + 
"                                </li>\n" + 
"\n" + 
"                                <li class=\"divider\"></li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/photo/manage\"> <i class=\"icon-edit\"></i> ");// line 208, japidviews\_layouts\Layout.html
		;p(getMessage("manage"));// line 213, japidviews\_layouts\Layout.html
		p(" </a>\n" + 
"                                </li>\n" + 
"                                <li>\n" + 
"                                    <a href=\"/photo/manage/set/all\"> <i class=\"icon-tasks\"></i> ");// line 213, japidviews\_layouts\Layout.html
		;p(getMessage("sets"));// line 216, japidviews\_layouts\Layout.html
		p(" </a>\n" + 
"                                </li>\n" + 
"\n" + 
"                            </ul>\n" + 
"                        </div>\n" + 
"                    </div>\n" + 
"                    ");// line 216, japidviews\_layouts\Layout.html
		}// line 222, japidviews\_layouts\Layout.html
		p("                </div>\n" + 
"            </div>\n" + 
"        </div>\n" + 
"    </div>\n" + 
"</div>\n" + 
"\n" + 
"<!--\n" + 
"<div class=\"page-header\">\n" + 
"<h3>");// line 222, japidviews\_layouts\Layout.html
		header();p("</h3>\n" + 
"</div> -->\n" + 
"\n");// line 231, japidviews\_layouts\Layout.html
		doLayout();// line 234, japidviews\_layouts\Layout.html
		p("\n" + 
"<footer class=\"footer\">\n" + 
"    <div class=\"container\">\n" + 
"        <p>\n" + 
"            @Company\n" + 
"        </p>\n" + 
"\n" + 
"    </div>\n" + 
"</footer>\n" + 
"</body>\n" + 
"</html>");// line 234, japidviews\_layouts\Layout.html
				endDoLayout(sourceTemplate);	}
	 protected void title() {};
	 protected void desc() {};
	 protected void keywords() {};
	 protected void header() {};
	 protected void css() {};

	protected abstract void doLayout();
}