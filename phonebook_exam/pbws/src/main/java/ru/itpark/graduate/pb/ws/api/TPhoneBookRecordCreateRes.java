package ru.itpark.graduate.pb.ws.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PhoneBookRecordCreateRes")
@XmlAccessorType(XmlAccessType.FIELD)
public class TPhoneBookRecordCreateRes {

    @XmlElement(name = "ErrorDescription")
    private TErrorDescription errorDescription = new TErrorDescription();

    @XmlElement(name = "RecordGUID")
    private String recordGUID;

    public TErrorDescription getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(TErrorDescription errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getRecordGUID() {
        return recordGUID;
    }

    public void setRecordGUID(String recordGUID) {
        this.recordGUID = recordGUID;
    }
}
