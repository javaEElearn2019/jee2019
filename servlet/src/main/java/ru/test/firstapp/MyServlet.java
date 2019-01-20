package ru.test.firstapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> pars = req.getParameterMap();
        String who = "uncknown";

        if(pars.get("Name")!=null){
            /*if(pars.get("Name").length > 0){
                who = pars.get("Name")[0];
            }*/
            who = "";
            for(String s : pars.get("Name")){
                who += s + ",";
            }
        }
        PrintWriter pw = resp.getWriter();
        pw.println("<h1>Hi, " + who + "!!!</h1>");
        pw.println("<b>I'm alive!</b>");

        pw.println("</br>");


        for(Map.Entry<String, String[]> en : pars.entrySet()){
            String key = en.getKey();
            String[] val = en.getValue();
            pw.println("param '" + key + "' = " );
            for(String s : val){
                pw.println("'" + s + "'" + ", ");
            }
            pw.println("</br>");
        }
    }


}
