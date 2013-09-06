package japidviews._tags;

import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import java.util.*;
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
// NOTE: This file was generated from: japidviews/_tags/PhotoNav.html
// Change to this file will be lost next time the template file is compiled.
//

public class PhotoNav extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/_tags/PhotoNav.html";
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

	public PhotoNav() {
		super(null);
	}

	public PhotoNav(StringBuilder out) {
		super(out);
	}

	/* based on https://github.com/branaway/Japid/issues/12
	 */
	public static final String[] argNames = new String[] {/* args of the template*/
			"item", "pathTitle", };
	public static final String[] argTypes = new String[] {/* arg types of the template*/
			"String", "Map<String, String>", };
	public static final Object[] argDefaults = new Object[] { null, null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews._tags.PhotoNav.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
	////// end of named args stuff

	private String item; // line 2
	private Map<String, String> pathTitle; // line 2

	public cn.bran.japid.template.RenderResult render(String item,
			Map<String, String> pathTitle) {
		this.item = item;
		this.pathTitle = pathTitle;
		long t = -1;
		try {
			super.layout();
		} catch (RuntimeException e) {
			super.handleException(e);
		} // line 2
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(),
				getOut(), t, actionRunners, sourceTemplate);
	}

	@Override
	protected void doLayout() {
		beginDoLayout(sourceTemplate);
		//------
		Map ms = new HashMap();// line 3
		ms.put(item, " class=\"active\" ");// line 4
		System.out.println(ms);// line 5
		String qs = request.querystring;// line 6
		String qString = "";// line 7
		if (qs != null && !"".equals(qs)) {// line 8
			qString = "?" + qs;// line 9
		}// line 10
		p("<div class=\"grid_row  photo_nav\" >\n" +
				"	<div class=\"col col_13\">\n" +
				"\n" +
				"		<ul class=\"nav nav-pills\">\n" +
				"			<li ");// line 10
		p(ms.get("/pop"));// line 15
		p(">\n" +
				"				<a href=\"/popular");// line 15
		p(qString);// line 16
		p("\">");// line 16
		;
		p(getMessage("pop"));// line 16
		p("</a>\n" +
				"			</li>\n" +
				"			<li  ");// line 16
		p(ms.get("/last"));// line 18
		p(">\n" +
				"				<a href=\"/last");// line 18
		p(qString);// line 19
		p("\">");// line 19
		;
		p(getMessage("last"));// line 19
		p("</a>\n" +
				"			</li>\n" +
				"			<li  ");// line 19
		p(ms.get("/choice"));// line 21
		p(">\n" +
				"				<a href=\"/choice");// line 21
		p(qString);// line 22
		p("\">");// line 22
		;
		p(getMessage("choice"));// line 22
		p("</a>\n" +
				"			</li>\n" +
				"			<li  ");// line 22
		p(ms.get("/upcoming"));// line 24
		p(">\n" +
				"				<a href=\"/upcoming");// line 24
		p(qString);// line 25
		p("\">");// line 25
		;
		p(getMessage("upcoming"));// line 25
		p("</a>\n" +
				"			</li>\n" +
				"\n" +
				"			<li  ");// line 25
		p(ms.get("/category"));// line 28
		p(">\n" +
				"				<a href=\"/category");// line 28
		p(qString);// line 29
		p("\">");// line 29
		;
		p(getMessage("category"));// line 29
		p("</a>\n" +
				"			</li>\n" +
				"		</ul>\n" +
				"\n" +
				"	</div>\n" +
				"	<div class=\"col col_3 col_right\">\n" +
				"		<div class=\"row-fluid\">\n" +
				"			");// line 29
		Map kv1 = fengfei.spruce.cache.CategoryCache.getAll();// line 36
		Map kv = new LinkedHashMap();
		kv.put((Byte) null, i18n("all"));// line 37
		kv.putAll(kv1);// line 38
		String skey = params.get("c");// line 39
		Byte key = null;// line 40
		if (skey != null) {
			key = Byte.parseByte(skey);
		}// line 41
		Object value = kv.get(key);// line 42
		if (fengfei.spruce.utils.Browser.isIE67(request)) {// line 43
			p("			<div class=\" span12\" >\n"
					+
					"				<select name=\"category\" id=\"onlyCategoryIe\" class=\"span12\">\n"
					+
					"					<option value=\"");// line 43
			p(key);// line 46
			p("\">");// line 46
			p(value);// line 46
			p("</option>\n" +
					"					");// line 46
			final Map2SelectOptions _Map2SelectOptions0 = new Map2SelectOptions(
					getOut());
			_Map2SelectOptions0.setActionRunners(getActionRunners()).setOut(
					getOut());
			_Map2SelectOptions0.render(
					fengfei.spruce.cache.CategoryCache.getAll(), key); // line 47// line 47
			p("				</select>\n" +
					"			</div>\n" +
					"			");// line 47
		} else {// line 50
			p("\n"
					+
					"			<div class=\"btn-group bootstrap-select span12\" >\n"
					+
					"				<button type=\"button\" class=\"btn dropdown-toggle btn-inverse span12\" data-toggle=\"dropdown\" data-id=\"onlyCategory1\">\n"
					+
					"					<div class=\"filter-option pull-left\">\n" +
					"						");// line 50
			p(value);// line 55
			p("					</div>\n"
					+
					"					&nbsp;<div class=\"caret\"></div>\n"
					+
					"				</button>\n"
					+
					"				<div class=\"dropdown-menu open\" style=\"max-height: 537px; overflow: hidden; min-height: 92px;\">\n"
					+
					"					<ul class=\"dropdown-menu inner\" role=\"menu\" style=\"max-height: 525px; overflow-y: auto;\">\n"
					+
					"						");// line 55
			final Map2Menus _Map2Menus1 = new Map2Menus(getOut());
			_Map2Menus1.setActionRunners(getActionRunners()).setOut(getOut());
			_Map2Menus1.render(kv, key); // line 61// line 61
			p("					</ul>\n" +
					"				</div>\n" +
					"			</div>\n" +
					"\n" +
					"			");// line 61
		}// line 66
		p("		</div>\n" +
				"	</div>\n" +
				"	<div class=\"col col_16  hr\"></div>\n" +
				"</div>\n");// line 66

		endDoLayout(sourceTemplate);
	}

}
