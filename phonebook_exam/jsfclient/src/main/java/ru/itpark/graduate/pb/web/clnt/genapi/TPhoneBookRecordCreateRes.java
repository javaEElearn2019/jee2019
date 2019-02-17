
package ru.itpark.graduate.pb.web.clnt.genapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPhoneBookRecordCreateRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPhoneBookRecordCreateRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorDescription" type="{http://ws.pb.graduate.itpark.ru/}tErrorDescription" minOccurs="0"/>
 *         &lt;element name="RecordGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPhoneBookRecordCreateRes", propOrder = {
    "errorDescription",
    "recordGUID"
})
public class TPhoneBookRecordCreateRes {

    @XmlElement(name = "ErrorDescription")
    protected TErrorDescription errorDescription;
    @XmlElement(name = "RecordGUID")
    protected String recordGUID;

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
     * Gets the value of the recordGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordGUID() {
        return recordGUID;
    }

    /**
     * Sets the value of the recordGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordGUID(String value) {
        this.recordGUID = value;
    }

}
