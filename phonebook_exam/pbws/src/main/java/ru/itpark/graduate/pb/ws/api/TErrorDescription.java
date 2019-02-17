package ru.itpark.graduate.pb.ws.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ErrorDescription")
@XmlAccessorType(XmlAccessType.FIELD)
public class TErrorDescription {

    public static TErrorDescription newInstance(Long id, String msg){
        TErrorDescription t = new TErrorDescription();
        t.setErrorCode(id);
        t.setErrorMessage(msg);
        return t;
    }

    @XmlElement(name = "ErrorCode")
    private Long errorCode;
    @XmlElement(name = "ErrorMessage")
    private String errorMessage;

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
