package rrr.ttt;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class App {

    public static void main(String[] args) throws JAXBException {

        Book b = new Book();
        b.setAuthor("Eckel");
        b.setTilte("Thinkin in Java");
        b.setPageCount(3000);
        b.setIsbn("77-888899-66");


        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller m =  context.createMarshaller();
        m.marshal(b, new File("./book.xml"));

        Unmarshaller um = context.createUnmarshaller();
        Book book = (Book)um.unmarshal(new File("./book.xml"));

        System.out.println(book.getIsbn());




        Library lib = new Library();
        lib.setDescription("Warehouse-13");

        Book b2 = new Book();
        b2.setAuthor("Schildt");
        b2.setTilte("Full JAVA-8 hanbook");
        b2.setPageCount(60000);
        b2.setIsbn("77-888899-55");

        lib.getStore().add(b);
        lib.getStore().add(b2);

        JAXBContext ctx2  = JAXBContext.newInstance(Library.class);
        Marshaller m2 = ctx2.createMarshaller();
        m2.marshal(lib, System.out);

    }
}
