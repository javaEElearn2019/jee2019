package ru.test.firstapp;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Logic {

    public enum Error{
        OK,
        WRONG_DATA,
        LOGIN_EXISTS
    }

    private static final String PARAM_LOGIN = "Login";
    private static final String PARAM_PASSWORD = "Password";
    private static final String PARAM_FIRSTNAME = "FirstName";
    private static final String PARAM_AGE = "Age";


    private static final String Q_FIND = "" +
            "SELECT * FROM EMPLOYEE WHERE" +
            " LOGIN = ? ";

    private static final String Q_INS = "" +
            "INSERT INTO EMPLOYEE (LOGIN, PASSWORD, FIRSTNAME, AGE ) " +
            "VALUES " +
            "(?, ?, ?, ?)";

    private static final String Q_SEL = "" +
            "SELECT " +
            "LOGIN as \"Login\", " +
            "PASSWORD as \"Password\", " +
            "FIRSTNAME as \"Name\", " +
            "AGE as \"Age\" " +
            "FROM EMPLOYEE ORDER BY LOGIN ASC";


    public static List<ResTableDTO> getListAll(){
        Connection conn = null;

        List<ResTableDTO> result = new ArrayList<ResTableDTO>();
        try {
            conn = DBUtils.getPool().getConnection();
            PreparedStatement pst = conn.prepareStatement(Q_SEL);
            ResultSet rs =  pst.executeQuery();
            while (rs.next()){
                ResTableDTO dto  = new ResTableDTO();
                String login = rs.getString("Login");
                String name = rs.getString("Name");
                Integer age = rs.getInt("Age");
                dto.setLogin(login);
                dto.setName(name);
                dto.setAge(age);
                result.add(dto);
            }
        } catch (SQLException x){
            x.printStackTrace();
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (Exception x){};
            }
        }
        return result;
    }


    public static Error validate(HttpServletRequest req){
        Map<String, String[]> params = req.getParameterMap();
        if(!isNotEmpty(params, PARAM_LOGIN) ||
                !isNotEmpty(params, PARAM_PASSWORD) ||
                !isNotEmpty(params, PARAM_FIRSTNAME)||
                !isNotEmpty(params, PARAM_AGE)){
            return Error.WRONG_DATA;
        }
        if(found(params.get(PARAM_LOGIN)[0])){
            return Error.LOGIN_EXISTS;
        }
        return Error.OK;
    }


    private static boolean isNotEmpty(Map<String, String[]> pars, String name){
        if(pars.get(name)==null){
            return false;
        }
        return !pars.get(name)[0].trim().equals("");
    }


    public static void addEmp(HttpServletRequest req){
        String login = req.getParameterMap().get(PARAM_LOGIN)[0];
        String passw = req.getParameterMap().get(PARAM_PASSWORD)[0];
        String name = req.getParameterMap().get(PARAM_FIRSTNAME)[0];
        String ageS = req.getParameterMap().get(PARAM_AGE)[0];
        Integer age = Integer.parseInt(ageS);

        passw = "" + (passw.hashCode());
        try {
            Connection conn = DBUtils.getPool().getConnection();

            PreparedStatement pst = conn.prepareStatement(Q_INS);
            pst.setString(1, login);
            pst.setString(2, passw);
            pst.setString(3, name);
            pst.setInt(4, age);

            pst.execute();
            conn.close();

        } catch (Exception x){
            x.printStackTrace();
        }

    }

    private static boolean found(String login) {
        try {
            Connection conn = DBUtils.getPool().getConnection();
            PreparedStatement pst = conn.prepareStatement(Q_FIND);

            pst.setString(1, login);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
            conn.close();

        } catch (Exception x){
            x.printStackTrace();
        }
        return false;
    }
}
