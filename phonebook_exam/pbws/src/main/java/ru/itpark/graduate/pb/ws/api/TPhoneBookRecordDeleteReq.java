package ru.itpark.graduate.pb.ws.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PhoneBookRecordDeleteReq")
@XmlAccessorType(XmlAccessType.FIELD)
public class TPhoneBookRecordDeleteReq {

    @XmlElement(name = "RecordGUID")
    private String recordGUID;

    public String getRecordGUID() {
        return recordGUID;
    }

    public void setRecordGUID(String recordGUID) {
        this.recordGUID = recordGUID;
    }
}
