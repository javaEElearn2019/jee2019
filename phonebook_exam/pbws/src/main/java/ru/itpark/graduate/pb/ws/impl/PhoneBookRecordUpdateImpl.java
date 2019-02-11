package ru.itpark.graduate.pb.ws.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.itpark.graduate.pb.commons.ErrorCodes;
import ru.itpark.graduate.pb.commons.ParamUtils;
import ru.itpark.graduate.pb.ws.api.TErrorDescription;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordUpdateReq;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordUpdateRes;
import ru.itpark.graduate.pb.ws.db.JpaSessionFactory;
import ru.itpark.graduate.pb.ws.db.entity.PhoneBookRecordEntity;

import java.util.List;

public class PhoneBookRecordUpdateImpl {
    public TPhoneBookRecordUpdateRes phoneBookRecordUpdate(TPhoneBookRecordUpdateReq req){
        TPhoneBookRecordUpdateRes result = new TPhoneBookRecordUpdateRes();
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
                PhoneBookRecordEntity row = found.get(0);
                if(!ParamUtils.isEmpty(req.getBirthDate())){
                    row.setBirthDate(req.getBirthDate());
                }
                if(!ParamUtils.isEmpty(req.getEmail())){
                    row.setEmail(req.getEmail());
                }
                if(!ParamUtils.isEmpty(req.getPhone())){
                    row.setPhone(req.getPhone());
                }
                if(!ParamUtils.isEmpty(req.getFirstName())){
                    row.setFirstname(req.getFirstName());
                }
                if(!ParamUtils.isEmpty(req.getLastName())){
                    row.setLastname(req.getLastName());
                }
                if(!ParamUtils.isEmpty(req.getMiddleName())){
                    row.setMiddlename(req.getMiddleName());
                }
                session.update(row);
            }
            tx.commit();
            session.close();
        }
        result.setErrorDescription(TErrorDescription.newInstance(ec.getId(), ec.getMsg()));
        return result;
    }

    public ErrorCodes validate(TPhoneBookRecordUpdateReq req){
        if(ParamUtils.isEmpty(req.getRecordGUID())){
            return ErrorCodes.BUS_RECORD_GUID_NOSET;
        }
        return ErrorCodes.OK;
    }
}
