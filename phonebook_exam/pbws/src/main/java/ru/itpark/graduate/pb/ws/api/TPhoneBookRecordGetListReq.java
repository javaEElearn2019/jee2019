package ru.itpark.graduate.pb.ws.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PhoneBookRecordGetListReq")
@XmlAccessorType(XmlAccessType.FIELD)
public class TPhoneBookRecordGetListReq {

    @XmlElement(name = "RecordGUID")
    private String recordGUID;

    @XmlElement(name = "SearchText")
    private String searchText;

    public String getRecordGUID() {
        return recordGUID;
    }

    public void setRecordGUID(String recordGUID) {
        this.recordGUID = recordGUID;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
