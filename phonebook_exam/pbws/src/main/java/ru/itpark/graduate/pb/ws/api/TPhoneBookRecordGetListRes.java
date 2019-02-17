package ru.itpark.graduate.pb.ws.api;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "PhoneBookRecordGetListRes")
@XmlAccessorType(XmlAccessType.FIELD)
public class TPhoneBookRecordGetListRes {

    @XmlElement(name = "ErrorDescription")
    private TErrorDescription errorDescription = new TErrorDescription();

    @XmlElementWrapper(name = "RecordList")
    @XmlElement(name = "Record")
    private List<TRecordListElement4TPhoneBookRecordGetListRes> list = new ArrayList<TRecordListElement4TPhoneBookRecordGetListRes>();

    public List<TRecordListElement4TPhoneBookRecordGetListRes> getList() {
        return list;
    }

    public void setList(List<TRecordListElement4TPhoneBookRecordGetListRes> list) {
        this.list = list;
    }

    public TErrorDescription getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(TErrorDescription errorDescription) {
        this.errorDescription = errorDescription;
    }
}
