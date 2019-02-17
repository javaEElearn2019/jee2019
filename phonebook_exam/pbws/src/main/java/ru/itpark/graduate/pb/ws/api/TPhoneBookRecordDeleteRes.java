package ru.itpark.graduate.pb.ws.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PhoneBookRecordDeleteRes")
@XmlAccessorType(XmlAccessType.FIELD)
public class TPhoneBookRecordDeleteRes {
    @XmlElement(name = "ErrorDescription")
    private TErrorDescription errorDescription = new TErrorDescription();

    public TErrorDescription getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(TErrorDescription errorDescription) {
        this.errorDescription = errorDescription;
    }

}
