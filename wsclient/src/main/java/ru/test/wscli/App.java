package ru.test.wscli;

import ru.test.wscli.api.Book;
import ru.test.wscli.api.Library;
import ru.test.wscli.api.MyWsImpl;
import ru.test.wscli.api.MyWsImplService;

public class App {


    //wsimport.exe -keep -verbose "http://localhost:7777/myws/exmpl?wsdl"

    public static void main(String[] args){
        MyWsImplService serv = new MyWsImplService();
        MyWsImpl imppl = serv.getMyWsImplPort();

        Book b = new Book();
        b.setAuthor("A");
        b.setHeader("hh");
        b.setPages(123132);
        b.setISBN("77-888899-55");

        Library lib = imppl.doSmth(b);

        for(Book bb: lib.getBookList().getStore()){
            System.out.println(" Author = " + bb.getAuthor() + "\n" +
            " Title = " + bb.getHeader());
        }

    }
}
