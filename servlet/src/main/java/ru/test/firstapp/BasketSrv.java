package ru.test.firstapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/basket")
public class BasketSrv extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        Map<String, String[]> params = req.getParameterMap();
        String[] dp = params.get("Desc");
        String desc = dp[0];

        HttpSession sess = req.getSession();


        //set new TTL
        sess.setMaxInactiveInterval(60);


        if(sess.getAttribute("Basket")==null){
            sess.setAttribute("Basket", new ArrayList<String>());
        }
        List<String> bsk = (ArrayList<String>)sess.getAttribute("Basket");
        bsk.add(desc);



        resp.getWriter().println("========= </BR>");
        for(String s : bsk){
            resp.getWriter().println(s + "</BR>");
        }



        if(desc.equalsIgnoreCase("stop")){
            //drop session if get "stop"-item
            sess.invalidate();
        }

    }
}
