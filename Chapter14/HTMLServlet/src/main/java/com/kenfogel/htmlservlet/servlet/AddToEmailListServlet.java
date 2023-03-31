package com.kenfogel.htmlservlet.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.kenfogel.htmlservlet.model.User;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * This is the servlet that receives a request from the join_email_list.html
 *
 * @author Ken Fogel
 */
@WebServlet(name = "AddToEmailList", urlPatterns = {"/AddToEmailList"})
public class AddToEmailListServlet extends HttpServlet {

    // All good programmers use a Logger
      private static final Logger LOG = Logger.getLogger(AddToEmailListServlet.class.getName());


    /**
     * Handles the HTTP <code>GET</code> method. GET is used so that you can see
     * the query string in the browser's address bar
     *
     * @param request server produced object from the user
     * @param response server produced object for replying to the user
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // store data in User object
        User user = new User(firstName, lastName, emailAddress);

        // send response to browser
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            displayConfirmation(out, user);
        }
    }

    /**
     * This method handles the output back to the browser
     * 
     * @param out object that writes to the user's browser
     * @param user object with user entered data
     */
    private void displayConfirmation(PrintWriter out, User user) {
        out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                <title>Just Servlet Output</title>
                <link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\"/>
                </head>
                <body>
                <h1>Thanks for joining our email list</h1>
                <p>Here is the information that you entered:</p>
                <label>Email:</label>
                <span>%s</span><br>
                <label>First Name:</label>
                <span>%s</span><br>
                <label>Last Name:</label>
                <span>%s</span><br>
                <p>To enter another email address, click on the Return button shown below.</p>
                <form action='join_email_list.html' method='get'>
                <input type='submit' value='Return'>
                </form>
                <p>This email address was added to our list on %s</p>
                </body>
                </html>""".formatted(user.getEmailAddress(),user.getFirstName(), user.getLastName(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE) ));
    }
}
