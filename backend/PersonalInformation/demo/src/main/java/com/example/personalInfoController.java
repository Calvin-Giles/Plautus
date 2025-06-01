package com.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/*
 * defines a servlet in Java that handles HTTP requests at the /api/personal-info endpoint
 * This servlet will eventually handle HTTP requests for storing personal information
 */
@WebServlet("/api/personal-info")
public class personalInfoController extends HttpServlet {
    private personalInfoService personalInfoService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        try {
            this.personalInfoService = new personalInfoService();
        } catch (Exception e) {
            throw new ServletException("Failed to initialize PersonalInfoService", e);
        }
    }
/*
 * doPost: a servlet is responsible for handling POST requests
 * secure API endpoint for saving user personal information while enforcing authentication
 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        try {
            // Check authentication
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("userId") == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.print("{\"status\":\"error\",\"message\":\"Not authenticated\"}");
                return;
            }
            
            int userId = (int) session.getAttribute("userId");
            
            // Parse JSON request body
            PersonalInformation personalInfo = objectMapper.readValue(
                request.getReader(), 
                PersonalInformation.class
            );
            
            // Process the request
            personalInfoService.savePersonalInfo(userId, personalInfo);
            
            // Return success response
            out.print("{\"status\":\"success\",\"message\":\"Personal information saved successfully\"}");
            
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"status\":\"error\",\"message\":\"" + e.getMessage() + "\"}");
            e.printStackTrace();
        }
    }
}
