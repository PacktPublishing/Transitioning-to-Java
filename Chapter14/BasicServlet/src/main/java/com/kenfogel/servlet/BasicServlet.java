package com.kenfogel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * This servlet just writes to the log as its methods are called by the
 * application server
 *
 * @author omniprof
 */
@WebServlet(description = "Basic Servlet",
        urlPatterns = {"/basicservlet"})
public class BasicServlet extends HttpServlet {

    private static final Logger LOG
            = Logger.getLogger(BasicServlet.class.getName());

    /**
     * Rarely used constructor
     */
    public BasicServlet() {
        LOG.info(">>> Constructor <<<");
    }

    /**
     * Prefered method for performing any initial tasks before the servlet goes
     * into service
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        LOG.info(">>> init <<<");
    }

    /**
     * Called by the server when this servlet is being removed
     */
    @Override
    public void destroy() {
        LOG.info(">>> destroy <<<");
    }

    /**
     * Information used by the server when reporting on the running servlets
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        LOG.info(">>> getServletInfo <<<");
        return "BasicServlet01 Version 2.0";
    }

    /**
     * Every request from a browser comes here. It determines which action and
     * calls the appropriate do method such as doGet or doPost.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        super.service(request, response);
        LOG.info(">>> service <<<  " + request.getMethod());
    }

    /**
     * If the request is a GET then this is called
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(createHTMLString("GET"));
        }
        LOG.info(">>> doGet <<<");
    }

    /**
     * If the request is a POST then this is called
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(createHTMLString("POST"));
        }
        LOG.info(">>> doPost <<<");
    }

    /**
     * If the request is a PUT then this is called
     *
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(
                "text/plain;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print("You have called doPut");
        }
        LOG.info(">>> doPut <<<");
    }

    /**
     * If the request is a DELETE then this is called
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(
                "text/plain;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print("You have called doDelete");
        }
        LOG.info(">>> doDelete <<<");
        HttpSession session = request.getSession();
        session.setAttribute("MyStuff", "Cat");
        String animal = (String) session.getAttribute("MyStuff");

    }

    /**
     * This method creates a string that contains HTML coding and that will be
     * written to the browser
     *
     * @param methodName
     * @return
     */
    private String createHTMLString(String methodName) {
        String htmlStr = """
           <html>
              <head><link rel='stylesheet'
                 href='styles/main.css'
                 type='text/css'/>
               <title>The Basic Servlet</title></head>
               <body>
                  <h1>%s method</h1>
                  <br/><br/>
                  <form action = 'index.html'>
                  <label>Return to Home page</label>
                  <br/>
                  <button class = 'button'>Return</button>
                  </form>
               </body>
           </html>
           """.formatted(methodName);
        return htmlStr;
    }
}
