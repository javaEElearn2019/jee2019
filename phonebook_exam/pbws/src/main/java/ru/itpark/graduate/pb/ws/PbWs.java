package ru.itpark.graduate.pb.ws;

import ru.itpark.graduate.pb.ws.api.*;
import ru.itpark.graduate.pb.ws.db.JpaSessionFactory;
import ru.itpark.graduate.pb.ws.impl.*;

import javax.annotation.PreDestroy;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PbWs {

    @PreDestroy
    private void away(){
        JpaSessionFactory.kill();
    }

    static{ //immediate jpa initialize
        JpaSessionFactory.getInstance();
    }

    @WebMethod
    @WebResult(name = "PhoneBookExecuteCheckAuthPairResponse")
    public Boolean phoneBookExecuteCheckAuthPair(
            @WebParam(name = "Login") String login,
            @WebParam(name = "Password") String password){
        return new PhoneBookExecuteCheckAuthPairImpl().phoneBookExecuteCheckAuthPair(login, password);
    }

    @WebMethod
    @WebResult(name = "PhoneBookRecordCreateResponse")
    public TPhoneBookRecordCreateRes phoneBookRecordCreate(
            @WebParam(name = "PhoneBookRecordCreateRequest") TPhoneBookRecordCreateReq req){
        return new PhoneBookRecordCreateImpl().phoneBookRecordCreate(req);
    }

    @WebMethod
    @WebResult(name = "PhoneBookRecordUpdateResponse")
    public TPhoneBookRecordUpdateRes phoneBookRecordUpdate(
            @WebParam(name = "PhoneBookRecordUpdateRequest") TPhoneBookRecordUpdateReq req){
        return new PhoneBookRecordUpdateImpl().phoneBookRecordUpdate(req);
    }

    @WebMethod
    @WebResult(name = "PhoneBookRecordGetListResponse")
    public TPhoneBookRecordGetListRes phoneBookRecordGetList(
            @WebParam(name = "PhoneBookRecordGetListRequest") TPhoneBookRecordGetListReq req){
        return new PhoneBookRecordGetListImpl().phoneBookRecordGetList(req);
    }

    @WebMethod
    @WebResult(name = "PhoneBookRecordDeleteResponse")
    public TPhoneBookRecordDeleteRes phoneBookRecordDelete(
            @WebParam(name = "PhoneBookRecordDeleteRequest") TPhoneBookRecordDeleteReq req){
        return new PhoneBookRecordDeleteImpl().phoneBookRecordDelete(req);
    }
}
