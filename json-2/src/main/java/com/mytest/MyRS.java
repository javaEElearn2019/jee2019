package com.mytest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/book")
public class MyRS {

    private static List<Book> data = new ArrayList<Book>();



    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook(Book book){
        data.add(book);
    }


    @POST
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getList(){
        return data;
    }

    @POST
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getByISBN(
            @PathParam("id") String id,
            @QueryParam("a") String paramA,
            @QueryParam("b") String paramB,
            @HeaderParam("hd1") String parH
    ){

        System.out.println("A = " + paramA  + " B = " + paramB);

        System.out.println("H = " + parH);

        for(Book b : data){
            if(b.getIsbn()!=null && b.getIsbn().equalsIgnoreCase(id)){
                return b;
            }
        }
        return null;
    }

}
