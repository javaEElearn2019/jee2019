
package ru.itpark.graduate.pb.web.clnt.genapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPhoneBookRecordGetListRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPhoneBookRecordGetListRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorDescription" type="{http://ws.pb.graduate.itpark.ru/}tErrorDescription" minOccurs="0"/>
 *         &lt;element name="RecordList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Record" type="{http://ws.pb.graduate.itpark.ru/}tRecordListElement4TPhoneBookRecordGetListRes" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPhoneBookRecordGetListRes", propOrder = {
    "errorDescription",
    "recordList"
})
public class TPhoneBookRecordGetListRes {

    @XmlElement(name = "ErrorDescription")
    protected TErrorDescription errorDescription;
    @XmlElement(name = "RecordList")
    protected TPhoneBookRecordGetListRes.RecordList recordList;

    /**
     * Gets the value of the errorDescription property.
     * 
     * @return
     *     possible object is
     *     {@link TErrorDescription }
     *     
     */
    public TErrorDescription getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link TErrorDescription }
     *     
     */
    public void setErrorDescription(TErrorDescription value) {
        this.errorDescription = value;
    }

    /**
     * Gets the value of the recordList property.
     * 
     * @return
     *     possible object is
     *     {@link TPhoneBookRecordGetListRes.RecordList }
     *     
     */
    public TPhoneBookRecordGetListRes.RecordList getRecordList() {
        return recordList;
    }

    /**
     * Sets the value of the recordList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPhoneBookRecordGetListRes.RecordList }
     *     
     */
    public void setRecordList(TPhoneBookRecordGetListRes.RecordList value) {
        this.recordList = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Record" type="{http://ws.pb.graduate.itpark.ru/}tRecordListElement4TPhoneBookRecordGetListRes" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "record"
    })
    public static class RecordList {

        @XmlElement(name = "Record")
        protected List<TRecordListElement4TPhoneBookRecordGetListRes> record;

        /**
         * Gets the value of the record property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the record property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRecord().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TRecordListElement4TPhoneBookRecordGetListRes }
         * 
         * 
         */
        public List<TRecordListElement4TPhoneBookRecordGetListRes> getRecord() {
            if (record == null) {
                record = new ArrayList<TRecordListElement4TPhoneBookRecordGetListRes>();
            }
            return this.record;
        }

    }

}
