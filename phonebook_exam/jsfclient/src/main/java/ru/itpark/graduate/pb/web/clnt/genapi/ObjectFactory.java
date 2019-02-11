
package ru.itpark.graduate.pb.web.clnt.genapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.itpark.graduate.pb.ws package. 
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

    private final static QName _PhoneBookRecordCreateReq_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordCreateReq");
    private final static QName _PhoneBookRecordCreateRes_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordCreateRes");
    private final static QName _ErrorDescription_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "ErrorDescription");
    private final static QName _PhoneBookRecordDeleteRes_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordDeleteRes");
    private final static QName _PhoneBookRecordGetListReq_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordGetListReq");
    private final static QName _PhoneBookRecordUpdateRes_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordUpdateRes");
    private final static QName _Record_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "Record");
    private final static QName _PhoneBookRecordDeleteReq_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordDeleteReq");
    private final static QName _PhoneBookRecordGetListRes_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordGetListRes");
    private final static QName _PhoneBookRecordUpdateReq_QNAME = new QName("http://ws.pb.graduate.itpark.ru/", "PhoneBookRecordUpdateReq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.itpark.graduate.pb.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TPhoneBookRecordGetListRes }
     * 
     */
    public TPhoneBookRecordGetListRes createTPhoneBookRecordGetListRes() {
        return new TPhoneBookRecordGetListRes();
    }

    /**
     * Create an instance of {@link TErrorDescription }
     * 
     */
    public TErrorDescription createTErrorDescription() {
        return new TErrorDescription();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordCreateRes }
     * 
     */
    public TPhoneBookRecordCreateRes createTPhoneBookRecordCreateRes() {
        return new TPhoneBookRecordCreateRes();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordCreateReq }
     * 
     */
    public TPhoneBookRecordCreateReq createTPhoneBookRecordCreateReq() {
        return new TPhoneBookRecordCreateReq();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordUpdateReq }
     * 
     */
    public TPhoneBookRecordUpdateReq createTPhoneBookRecordUpdateReq() {
        return new TPhoneBookRecordUpdateReq();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordDeleteReq }
     * 
     */
    public TPhoneBookRecordDeleteReq createTPhoneBookRecordDeleteReq() {
        return new TPhoneBookRecordDeleteReq();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordUpdateRes }
     * 
     */
    public TPhoneBookRecordUpdateRes createTPhoneBookRecordUpdateRes() {
        return new TPhoneBookRecordUpdateRes();
    }

    /**
     * Create an instance of {@link TRecordListElement4TPhoneBookRecordGetListRes }
     * 
     */
    public TRecordListElement4TPhoneBookRecordGetListRes createTRecordListElement4TPhoneBookRecordGetListRes() {
        return new TRecordListElement4TPhoneBookRecordGetListRes();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordGetListReq }
     * 
     */
    public TPhoneBookRecordGetListReq createTPhoneBookRecordGetListReq() {
        return new TPhoneBookRecordGetListReq();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordDeleteRes }
     * 
     */
    public TPhoneBookRecordDeleteRes createTPhoneBookRecordDeleteRes() {
        return new TPhoneBookRecordDeleteRes();
    }

    /**
     * Create an instance of {@link TPhoneBookRecordGetListRes.RecordList }
     * 
     */
    public TPhoneBookRecordGetListRes.RecordList createTPhoneBookRecordGetListResRecordList() {
        return new TPhoneBookRecordGetListRes.RecordList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordCreateReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordCreateReq")
    public JAXBElement<TPhoneBookRecordCreateReq> createPhoneBookRecordCreateReq(TPhoneBookRecordCreateReq value) {
        return new JAXBElement<TPhoneBookRecordCreateReq>(_PhoneBookRecordCreateReq_QNAME, TPhoneBookRecordCreateReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordCreateRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordCreateRes")
    public JAXBElement<TPhoneBookRecordCreateRes> createPhoneBookRecordCreateRes(TPhoneBookRecordCreateRes value) {
        return new JAXBElement<TPhoneBookRecordCreateRes>(_PhoneBookRecordCreateRes_QNAME, TPhoneBookRecordCreateRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TErrorDescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "ErrorDescription")
    public JAXBElement<TErrorDescription> createErrorDescription(TErrorDescription value) {
        return new JAXBElement<TErrorDescription>(_ErrorDescription_QNAME, TErrorDescription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordDeleteRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordDeleteRes")
    public JAXBElement<TPhoneBookRecordDeleteRes> createPhoneBookRecordDeleteRes(TPhoneBookRecordDeleteRes value) {
        return new JAXBElement<TPhoneBookRecordDeleteRes>(_PhoneBookRecordDeleteRes_QNAME, TPhoneBookRecordDeleteRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordGetListReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordGetListReq")
    public JAXBElement<TPhoneBookRecordGetListReq> createPhoneBookRecordGetListReq(TPhoneBookRecordGetListReq value) {
        return new JAXBElement<TPhoneBookRecordGetListReq>(_PhoneBookRecordGetListReq_QNAME, TPhoneBookRecordGetListReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordUpdateRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordUpdateRes")
    public JAXBElement<TPhoneBookRecordUpdateRes> createPhoneBookRecordUpdateRes(TPhoneBookRecordUpdateRes value) {
        return new JAXBElement<TPhoneBookRecordUpdateRes>(_PhoneBookRecordUpdateRes_QNAME, TPhoneBookRecordUpdateRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRecordListElement4TPhoneBookRecordGetListRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "Record")
    public JAXBElement<TRecordListElement4TPhoneBookRecordGetListRes> createRecord(TRecordListElement4TPhoneBookRecordGetListRes value) {
        return new JAXBElement<TRecordListElement4TPhoneBookRecordGetListRes>(_Record_QNAME, TRecordListElement4TPhoneBookRecordGetListRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordDeleteReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordDeleteReq")
    public JAXBElement<TPhoneBookRecordDeleteReq> createPhoneBookRecordDeleteReq(TPhoneBookRecordDeleteReq value) {
        return new JAXBElement<TPhoneBookRecordDeleteReq>(_PhoneBookRecordDeleteReq_QNAME, TPhoneBookRecordDeleteReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordGetListRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordGetListRes")
    public JAXBElement<TPhoneBookRecordGetListRes> createPhoneBookRecordGetListRes(TPhoneBookRecordGetListRes value) {
        return new JAXBElement<TPhoneBookRecordGetListRes>(_PhoneBookRecordGetListRes_QNAME, TPhoneBookRecordGetListRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPhoneBookRecordUpdateReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pb.graduate.itpark.ru/", name = "PhoneBookRecordUpdateReq")
    public JAXBElement<TPhoneBookRecordUpdateReq> createPhoneBookRecordUpdateReq(TPhoneBookRecordUpdateReq value) {
        return new JAXBElement<TPhoneBookRecordUpdateReq>(_PhoneBookRecordUpdateReq_QNAME, TPhoneBookRecordUpdateReq.class, null, value);
    }

}
