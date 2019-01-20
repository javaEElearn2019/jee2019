package ru.test.firstapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;


@WebServlet("/emp")
public class EmpServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        DBUtils.init();
    }

    @Override
    public void destroy() {
        DBUtils.getPool().dispose();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        Logic.Error err =  Logic.validate(req);
        if(Logic.Error.OK != err){
            pw.print(formError(err));
        } else {
            Logic.addEmp(req);
            pw.print(formTable());
        }

    }

    private String formTable() {
        StringBuilder sb = new StringBuilder("");
        sb.append("<html><body><table>");
        sb.append("<tr>");
        sb.append("<td>Login</td>");
        sb.append("<td>Name</td>");
        sb.append("<td>Age</td>");
        sb.append("</tr>");
        List<ResTableDTO> list = Logic.getListAll();
            try {
                for(ResTableDTO dto : list) {
                    sb.append("<tr>");
                    sb.append("<td>" + dto.getLogin() +"</td>");
                    sb.append("<td>" + dto.getName() + "</td>");
                    sb.append("<td>" + dto.getAge() + "</td>");
                    sb.append("</tr>");
                }
            } catch (Exception x){
                x.printStackTrace();
            }


        sb.append("</table></body></html>");
        return sb.toString();
    }

    private String formError(Logic.Error code){
        if(code == Logic.Error.LOGIN_EXISTS){
            return "<h1>Login already exists!</h1>";
        }
        if(code == Logic.Error.WRONG_DATA){
            return "<h1>Not all data is set!</h1>";
        }
        return "";
    }
}
