
package ru.test.wscli.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.test.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MyBook_QNAME = new QName("http://ws.test.ru/", "MyBook");
    private final static QName _BookStore_QNAME = new QName("http://ws.test.ru/", "BookStore");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.test.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Library }
     * 
     */
    public Library createLibrary() {
        return new Library();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link Library.BookList }
     * 
     */
    public Library.BookList createLibraryBookList() {
        return new Library.BookList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.test.ru/", name = "MyBook")
    public JAXBElement<Book> createMyBook(Book value) {
        return new JAXBElement<Book>(_MyBook_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Library }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.test.ru/", name = "BookStore")
    public JAXBElement<Library> createBookStore(Library value) {
        return new JAXBElement<Library>(_BookStore_QNAME, Library.class, null, value);
    }

}
