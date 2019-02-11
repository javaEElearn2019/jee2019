package ru.itpark.graduate.pb.ws.impl;


import org.hibernate.Session;
import ru.itpark.graduate.pb.commons.Crypto;
import ru.itpark.graduate.pb.commons.ParamUtils;
import ru.itpark.graduate.pb.ws.db.JpaSessionFactory;

import org.hibernate.query.Query;
import ru.itpark.graduate.pb.ws.db.entity.PhoneBookRecordEntity;

import java.util.List;

public class PhoneBookExecuteCheckAuthPairImpl {

    public Boolean phoneBookExecuteCheckAuthPair(String login, String password){
        Boolean result = false;
        if(!ParamUtils.isEmpty(login) && !ParamUtils.isEmpty(password)) {
            Session session = JpaSessionFactory.getInstance().openSession();
            Query query = session.createQuery("FROM PhoneBookRecordEntity WHERE login = :id");
            query.setParameter("id", login);
            List<PhoneBookRecordEntity> found = (List<PhoneBookRecordEntity>)query.list();
            if(!found.isEmpty()){
                String dbHash = found.get(0).getPassword();
                String currentHash = Crypto.encryptPassword(password);
                if(dbHash.equalsIgnoreCase(currentHash)){
                    result = true;
                }
            }
            session.close();
        }
        return result;
    }
}
