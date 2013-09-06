package japidviews.Application;

import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import static play.templates.JavaExtensions.*;
import static cn.bran.play.JapidPlayAdapter.*;
import static play.data.validation.Validation.*;
import static japidviews._javatags.Pic.*;
import japidviews._layouts.*;
import play.data.validation.Validation;
import play.mvc.Scope.*;
import models.*;
import play.data.validation.Error;
import japidviews._tags.*;
import controllers.*;
import play.mvc.Http.*;
import japidviews._javatags.*;
//
// NOTE: This file was generated from: japidviews/Application/Index.html
// Change to this file will be lost next time the template file is compiled.
//

public class Index extends japidviews._layouts.Layout
{
	public static final String sourceTemplate = "japidviews/Application/Index.html";
	{
		putHeader("Content-Type", "text/html; charset=utf-8");
		setContentType("text/html; charset=utf-8");
	}

	// - add implicit fields with Play

	final Request request = Request.current();
	final Response response = Response.current();
	final Session session = Session.current();
	final RenderArgs renderArgs = RenderArgs.current();
	final Params params = Params.current();
	final Validation validation = Validation.current();
	final cn.bran.play.FieldErrors errors = new cn.bran.play.FieldErrors(
			validation);
	final play.Play _play = new play.Play();

	// - end of implicit fields with Play 

	public Index() {
		super(null);
	}

	public Index(StringBuilder out) {
		super(out);
	}

	/* based on https://github.com/branaway/Japid/issues/12
	 */
	public static final String[] argNames = new String[] {/* args of the template*/};
	public static final String[] argTypes = new String[] {/* arg types of the template*/};
	public static final Object[] argDefaults = new Object[] {};
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.Application.Index.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}

	////// end of named args stuff

	public cn.bran.japid.template.RenderResult render() {
		long t = -1;
		try {
			super.layout();
		} catch (RuntimeException e) {
			super.handleException(e);
		}
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(),
				getOut(), t, actionRunners, sourceTemplate);
	}

	@Override
	protected void doLayout() {
		beginDoLayout(sourceTemplate);
		//------
		p("<div class=\"alert\">\n"
				+
				"	<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>\n"
				+
				"	<strong>Warning!</strong> Best check yo self, you're not looking too\n"
				+
				"	good.\n"
				+
				"</div>\n"
				+
				"<div class=\"row-fluid\">\n"
				+
				"	<ul class=\"thumbnails\">\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"		<li class=\"span3\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"				src=\"http://placehold.it/260x180\" class=\"img-rounded\" alt=\"\">\n"
				+
				"		</a></li>\n"
				+
				"	</ul>\n"
				+
				"</div>\n"
				+
				"<div class=\"row-fluid\">\n"
				+
				"	<ul class=\"thumbnails\">\n"
				+
				"		<li class=\"span3\">\n"
				+
				"			<div class=\"thumbnail\">\n"
				+
				"				<img class=\"img-rounded\" src=\"/images/1.JPG\" alt=\"\">\n"
				+
				"				<div class=\"caption\">\n"
				+
				"					<h3>Thumbnail label</h3>\n"
				+
				"					<p>Cras justo odio, dapibus</p>\n"
				+
				"\n"
				+
				"				</div>\n"
				+
				"			</div>\n"
				+
				"		</li>\n"
				+
				"		<li class=\"span3\">\n"
				+
				"			<div class=\"thumbnail\">\n"
				+
				"				<img class=\"img-rounded\" src=\"/images/2.JPG\" alt=\"\">\n"
				+
				"				<div class=\"caption\">\n"
				+
				"					<h3>Thumbnail label</h3>\n"
				+
				"					<p>Cras justo odio, dapibus ac facilisis in,</p>\n"
				+
				"\n"
				+
				"				</div>\n"
				+
				"			</div>\n"
				+
				"		</li>\n"
				+
				"		<li class=\"span3\">\n"
				+
				"			<div class=\"thumbnail\">\n"
				+
				"				<img class=\"img-rounded\" src=\"/images/3.JPG\" alt=\"\">\n"
				+
				"				<div class=\"caption\">\n"
				+
				"					<h3>Thumbnail label</h3>\n"
				+
				"					<p>Cras justo odio, dapibus ac facilisis in</p>\n"
				+
				"\n"
				+
				"				</div>\n"
				+
				"			</div>\n"
				+
				"		</li>\n"
				+
				"		<li class=\"span3\">\n"
				+
				"			<div class=\"thumbnail\">\n"
				+
				"				<img class=\"img-rounded\" src=\"/images/3.JPG\" alt=\"\">\n"
				+
				"				<div class=\"caption\">\n"
				+
				"					<h3>Thumbnail label</h3>\n"
				+
				"					<p>Cras justo odio, dapibus ac facilisis in</p>\n"
				+
				"\n"
				+
				"				</div>\n"
				+
				"			</div>\n"
				+
				"		</li>\n"
				+
				"	</ul>\n"
				+
				"</div>\n"
				+
				"\n"
				+
				"<ul class=\"thumbnails\">\n"
				+
				"	<li class=\"span4\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/360x270\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n"
				+
				"	</a></li>\n"
				+
				"	<li class=\"span2\"><a href=\"#\" class=\"thumbnail\"> <img\n"
				+
				"			src=\"http://placehold.it/160x120\" alt=\"\">\n" +
				"	</a></li>\n" +
				"</ul>\n" +
				"<div class=\"pagination  pagination-centered\">\n" +
				"	<ul>\n" +
				"		<li><a href=\"#\">Prev</a></li>\n" +
				"		<li class=\"disabled\"><a href=\"#\">1</a></li>\n" +
				"		<li><a href=\"#\">2</a></li>\n" +
				"		<li><a href=\"#\">3</a></li>\n" +
				"		<li><a href=\"#\">4</a></li>\n" +
				"		<li><a href=\"#\">5</a></li>\n" +
				"		<li><a href=\"#\">Next</a></li>\n" +
				"	</ul>\n" +
				"</div>\n");// line 2

		endDoLayout(sourceTemplate);
	}

	@Override
	protected void title() {
		p("Sprucy Home Page");
		;
	}

	@Override
	protected void header() {
		p("Index");
		;
	}
}
