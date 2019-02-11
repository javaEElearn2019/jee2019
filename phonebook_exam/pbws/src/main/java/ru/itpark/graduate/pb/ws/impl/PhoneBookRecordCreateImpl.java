package ru.itpark.graduate.pb.ws.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.itpark.graduate.pb.commons.Crypto;
import ru.itpark.graduate.pb.commons.ErrorCodes;
import ru.itpark.graduate.pb.commons.ParamUtils;
import ru.itpark.graduate.pb.ws.api.TErrorDescription;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordCreateReq;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordCreateRes;
import ru.itpark.graduate.pb.ws.db.JpaSessionFactory;
import ru.itpark.graduate.pb.ws.db.entity.PhoneBookRecordEntity;

import java.util.UUID;

public class PhoneBookRecordCreateImpl {

    public TPhoneBookRecordCreateRes phoneBookRecordCreate(TPhoneBookRecordCreateReq req){
        TPhoneBookRecordCreateRes result = new TPhoneBookRecordCreateRes();
        ErrorCodes ec = validate(req);
        if(ec == ErrorCodes.OK){
            PhoneBookRecordEntity jpaEntity = new PhoneBookRecordEntity();
            jpaEntity.setRecGUID(UUID.randomUUID().toString());
            result.setRecordGUID(jpaEntity.getRecGUID());
            jpaEntity.setLogin(req.getLogin());
            jpaEntity.setPassword(Crypto.encryptPassword(req.getPassword()));
            jpaEntity.setBirthDate(req.getBirthDate());
            jpaEntity.setFirstname(req.getFirstName());
            jpaEntity.setLastname(req.getLastName());
            jpaEntity.setMiddlename(req.getMiddleName());
            jpaEntity.setEmail(req.getEmail());
            jpaEntity.setPhone(req.getPhone());
            Session session = JpaSessionFactory.getInstance().openSession();
            Transaction tx = session.beginTransaction();
            session.save(jpaEntity);
            tx.commit();
            session.close();
        }
        result.setErrorDescription(TErrorDescription.newInstance(ec.getId(), ec.getMsg()));
        return result;
    }


    public ErrorCodes validate(TPhoneBookRecordCreateReq req){
        if(ParamUtils.isEmpty(req.getLogin())){
            return ErrorCodes.BUS_LOGIN_NOSET;
        }
        if(ParamUtils.isEmpty(req.getPassword())){
            return ErrorCodes.BUS_PASSWORD_NOSET;
        }
        //TODO login already using
        return ErrorCodes.OK;
    }
}
