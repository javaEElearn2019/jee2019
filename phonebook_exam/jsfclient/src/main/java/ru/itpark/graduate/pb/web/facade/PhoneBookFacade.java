package ru.itpark.graduate.pb.web.facade;

import ru.itpark.graduate.pb.commons.ParamUtils;
import ru.itpark.graduate.pb.web.clnt.genapi.*;

import java.util.Date;
import java.util.List;

public class PhoneBookFacade {

    private static PbWs caller = new PbWsService().getPbWsPort();

    public static Boolean isUserAuth(String login, String password){
        return caller.phoneBookExecuteCheckAuthPair(login, password);
    }

    public static List<TRecordListElement4TPhoneBookRecordGetListRes>
            getList(String searchText, String guid){
        TPhoneBookRecordGetListReq req = new TPhoneBookRecordGetListReq();
        req.setRecordGUID(guid);
        req.setSearchText(searchText);
        TPhoneBookRecordGetListRes res = caller.phoneBookRecordGetList(req);
        return res.getRecordList().getRecord();
    }

    public static void update(String id, String fn, String ln, String mn, String mail, String phn, Date bd){
        if(!ParamUtils.isEmpty(id)) {
            TPhoneBookRecordUpdateReq req = new TPhoneBookRecordUpdateReq();
            req.setRecordGUID(id);
            req.setFirstName(fn);
            req.setLastName(ln);
            req.setMiddleName(mn);
            req.setEmail(mail);
            req.setPhone(phn);
            caller.phoneBookRecordUpdate(req);
        }
    }

    public static void delete(String id){
        if(!ParamUtils.isEmpty(id)){
            TPhoneBookRecordDeleteReq req = new TPhoneBookRecordDeleteReq();
            req.setRecordGUID(id);
            caller.phoneBookRecordDelete(req);
        }
    }
}
