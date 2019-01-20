package ru.test.firstapp;

import org.h2.jdbcx.JdbcConnectionPool;

public class DBUtils {

    private DBUtils(){

    }


    private static JdbcConnectionPool pool;

    public static JdbcConnectionPool getPool(){
        return pool;
    }

    public static void init(){
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pool = JdbcConnectionPool.create(
                "jdbc:h2:tcp://localhost/~/tstbd",
                "sa",
                ""
        );
    }

}
