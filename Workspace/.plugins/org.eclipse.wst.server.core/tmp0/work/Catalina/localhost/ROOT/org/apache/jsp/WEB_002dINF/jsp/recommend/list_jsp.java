/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2018-12-16 06:28:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.recommend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/Users/Jeaha/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/java110-team-project/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1539714814447L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>movie cok!</title>\n");
      out.write("  <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"/img/favicon.ico\">\n");
      out.write("\n");
      out.write("  <link rel='stylesheet' href='/css/bootstrap.css'>\n");
      out.write("  <link rel='stylesheet' href='/css/fontawesome.css'>\n");
      out.write("  <link rel='stylesheet' href='/css/all.css'>\n");
      out.write("  <link rel='stylesheet' href='/css/common.css'>\n");
      out.write("  <link rel='stylesheet' href='/css/bootstrap-tagsinput.css'>\n");
      out.write("  <link rel='stylesheet' href='/css/rcmd.css'>\n");
      out.write("  <link rel='stylesheet' href='/css/rcmdAnly.css'>\n");
      out.write("  <link rel='stylesheet' href='/css/top-btn.css'>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body class=\"borderGray mt-5\">\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/header.jsp", out, false);
      out.write('\n');
      out.write("\n");
      out.write("  <main role=\"main\" class=\"container borderGray\"> \n");
      out.write("  ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("  <hr>\n");
      out.write("\n");
      out.write("  <section id=\"anly-base-section\" style=\"display: none;\">\n");
      out.write("    <h4 id=\"anlyBaseTitle\"></h4>\n");
      out.write("    <div id=\"anlyBaseCarousel\" class=\"list-container\">\n");
      out.write("      <div class=\"control-container\">\n");
      out.write("        <div id=\"anly-left-scroll-btn\" class=\"left-scroll button scroll left-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"anly-right-scroll-btn\" class=\"right-scroll button scroll right-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"items\" id=\"anly-base-items\">\n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <button type=\"button\" id=\"popover\" class=\"btn btn-secondary\" data-container=\"body\"\n");
      out.write("        data-toggle=\"popover\" data-placement=\"right\"\n");
      out.write("        data-content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("님의 취향과 비슷한 사람들이 좋아한 영화들을,\n");
      out.write("            취향에 맞게 다시 조합해 보았어요.\">추천 기준</button>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <section id=\"random-base-section\" style=\"display: none;\">\n");
      out.write("  <hr>\n");
      out.write("    <h4 id=\"randomBaseTitle\"></h4>\n");
      out.write("    <div id=\"randomBaseCarousel\" class=\"list-container\">\n");
      out.write("      <div class=\"control-container\">\n");
      out.write("        <div id=\"random-left-scroll-btn\" class=\"left-scroll button scroll left-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"random-right-scroll-btn\" class=\"right-scroll button scroll right-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"items\" id=\"random-base-items\">\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  <br>\n");
      out.write("  <hr>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <section id=\"loading\" >\n");
      out.write("    <div class=\"spinner\"></div>\n");
      out.write("  </section>\n");
      out.write("  \n");
      out.write("  <section id=\"md-section\" style=\"display: none;\">\n");
      out.write("    <h2>SceneCok 추천 영화</h2>\n");
      out.write("    <h4 id=\"mdTitle\"></h4>\n");
      out.write("    <div id=\"mdCarousel\" class=\"list-container\">\n");
      out.write("      <div class=\"control-container\">\n");
      out.write("        <div id=\"left-scroll-button\" class=\"left-scroll button scroll left-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"right-scroll-button\" class=\"right-scroll button scroll right-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"items\" id=\"md-items\">\n");
      out.write("         \n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <section id=\"now-section\" style=\"display: none;\">\n");
      out.write("  <hr>\n");
      out.write("    <h4>현재 상영작</h4>\n");
      out.write("    <div id=\"nowCarousel\" class=\"list-container\">\n");
      out.write("      <div class=\"control-container\">\n");
      out.write("        <div id=\"left-scroll-now\" class=\"left-scroll button scroll left-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"right-scroll-now\" class=\"right-scroll button scroll right-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"items\" id=\"now-items\">\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("  <br>\n");
      out.write("  <hr>\n");
      out.write("\n");
      out.write("  <section id=\"upcomming-section\" style=\"display: none;\">\n");
      out.write("    <h4>개봉 예정작</h4>\n");
      out.write("    <div id=\"upcommingCarousel\" class=\"list-container\">\n");
      out.write("      <div class=\"control-container\">\n");
      out.write("        <div id=\"random-left-scroll-upcomming\" class=\"left-scroll button scroll left-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"random-right-scroll-upcomming\" class=\"right-scroll button scroll right-scroll-btn\">\n");
      out.write("          <i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"items\" id=\"upcoming-items\">\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("  <br>\n");
      out.write("  <br>\n");
      out.write("\n");
      out.write("  </main>\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/commonJs.jsp", out, false);
      out.write('\n');
      out.write(' ');
      out.write(' ');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/footer.jsp", out, false);
      out.write('\n');
      out.write(' ');
      out.write(' ');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/top-btn.jsp", out, false);
      out.write("\n");
      out.write("  <script src=\"/js/top-btn.js\"></script>\n");
      out.write("  <script src=\"/js/rcmd.js\"></script>\n");
      out.write("  <script src=\"/js/carousel.js\"></script>\n");
      out.write("  <script src=\"/js/handlebars-v4.0.12.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f0_reused = false;
    try {
      _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f0.setParent(null);
      int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
      if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      _jspx_th_c_005fchoose_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f0_reused = false;
    try {
      _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      // /WEB-INF/jsp/recommend/list.jsp(27,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.loginUser}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
      if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("      <h1>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("님만을 위한 취향저격 추천 영화</h1>\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      _jspx_th_c_005fwhen_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
    }
    return false;
  }
}
