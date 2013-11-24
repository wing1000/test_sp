//version: 0.9.35
package japidviews._tags;

import static cn.bran.play.JapidPlayAdapter.flash;
//
// NOTE: This file was generated from: japidviews/_tags/ErrorMessage.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class ErrorMessage extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/_tags/ErrorMessage.html";
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


	public ErrorMessage() {
		super(null);
	}
	public ErrorMessage(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/ };
	public static final String[] argTypes = new String[] {/* arg types of the template*/ };
	public static final Object[] argDefaults= new Object[] { };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews._tags.ErrorMessage.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	public cn.bran.japid.template.RenderResult render() {
		long __t = -1;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 0, japidviews/_tags/ErrorMessage.html
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}

	public static cn.bran.japid.template.RenderResult apply() {
		return new ErrorMessage().render();
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1, japidviews\_tags\ErrorMessage.html
		p("\n" + 
" \n");// line 1, japidviews\_tags\ErrorMessage.html
		if(asBoolean(asBoolean(flash.get("error")))) {// line 3, japidviews\_tags\ErrorMessage.html
		p("\n" + 
"\n" + 
"<div class=\"alert alert-error control-group\">\n" + 
"	<button type=\"button\" class=\"close\" data-dismiss=\"alert\">\n" + 
"		&times;\n" + 
"	</button>\n" + 
"	");// line 3, japidviews\_tags\ErrorMessage.html
		p(flash.get("error"));// line 9, japidviews\_tags\ErrorMessage.html
		p("\n" + 
"</div>\n" + 
"\n");// line 9, japidviews\_tags\ErrorMessage.html
		}// line 12, japidviews\_tags\ErrorMessage.html
		;// line 12, japidviews\_tags\ErrorMessage.html
		
		endDoLayout(sourceTemplate);
	}

}