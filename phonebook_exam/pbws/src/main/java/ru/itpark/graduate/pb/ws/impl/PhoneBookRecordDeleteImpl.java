package ru.itpark.graduate.pb.ws.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.itpark.graduate.pb.commons.ErrorCodes;
import ru.itpark.graduate.pb.commons.ParamUtils;
import ru.itpark.graduate.pb.ws.api.TErrorDescription;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordDeleteReq;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordDeleteRes;
import ru.itpark.graduate.pb.ws.db.JpaSessionFactory;
import ru.itpark.graduate.pb.ws.db.entity.PhoneBookRecordEntity;

import java.util.List;

public class PhoneBookRecordDeleteImpl {
    public TPhoneBookRecordDeleteRes phoneBookRecordDelete(TPhoneBookRecordDeleteReq req){

        TPhoneBookRecordDeleteRes result = new TPhoneBookRecordDeleteRes();
        ErrorCodes ec = validate(req);
        if(ec == ErrorCodes.OK){
            Session session = JpaSessionFactory.getInstance().openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("FROM PhoneBookRecordEntity WHERE recGUID = :id");
            query.setParameter("id", req.getRecordGUID());
            List<PhoneBookRecordEntity> found = (List<PhoneBookRecordEntity>)query.list();
            if(found.isEmpty()){
                ec = ErrorCodes.BUS_RECORD_NOT_FOUND;
            } else {
                PhoneBookRecordEntity toDel = found.get(0);
                session.delete(toDel);
            }
            tx.commit();
            session.close();
        }
        result.setErrorDescription(TErrorDescription.newInstance(ec.getId(), ec.getMsg()));
        return result;
    }

    public ErrorCodes validate(TPhoneBookRecordDeleteReq req){
        if(ParamUtils.isEmpty(req.getRecordGUID())){
            return ErrorCodes.BUS_RECORD_GUID_NOSET;
        }
        return ErrorCodes.OK;
    }
}
