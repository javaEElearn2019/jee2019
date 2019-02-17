package ru.itpark.graduate.pb.ws.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.itpark.graduate.pb.commons.ErrorCodes;
import ru.itpark.graduate.pb.commons.ParamUtils;
import ru.itpark.graduate.pb.ws.api.TErrorDescription;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordGetListReq;
import ru.itpark.graduate.pb.ws.api.TPhoneBookRecordGetListRes;
import ru.itpark.graduate.pb.ws.api.TRecordListElement4TPhoneBookRecordGetListRes;
import ru.itpark.graduate.pb.ws.db.JpaSessionFactory;
import ru.itpark.graduate.pb.ws.db.entity.PhoneBookRecordEntity;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;

public class PhoneBookRecordGetListImpl {

    public TPhoneBookRecordGetListRes phoneBookRecordGetList(TPhoneBookRecordGetListReq req){
        TPhoneBookRecordGetListRes result = new TPhoneBookRecordGetListRes();
        if(!ParamUtils.isEmpty(req.getRecordGUID())){
            Session session = JpaSessionFactory.getInstance().openSession();
            Query query = session.createQuery("FROM PhoneBookRecordEntity WHERE recGUID = :id ");
            query.setParameter("id", req.getRecordGUID());
            List<PhoneBookRecordEntity> found = (List<PhoneBookRecordEntity>)query.list();
            mapToList(found, result.getList());
            session.close();
        } else {
            Session session = JpaSessionFactory.getInstance().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PhoneBookRecordEntity> criteriaQuery = builder.createQuery(PhoneBookRecordEntity.class);
            Root<PhoneBookRecordEntity> phoneBookRecordEntityRoot
                    = criteriaQuery.from(PhoneBookRecordEntity.class);
            criteriaQuery.select(phoneBookRecordEntityRoot);
            if(!ParamUtils.isEmpty(req.getSearchText())) {
                Predicate[] predicatesArray =
                        new Predicate[4];

                Expression<String> firstname =
                        phoneBookRecordEntityRoot.get("firstname");
                predicatesArray[0] = builder.like(builder.upper(firstname), "%" + req.getSearchText().toUpperCase() + "%");

                Expression<String> lastname =
                        phoneBookRecordEntityRoot.get("lastname");
                predicatesArray[1] = builder.like(builder.upper(lastname), "%" + req.getSearchText().toUpperCase() + "%");

                Expression<String> middlename =
                        phoneBookRecordEntityRoot.get("middlename");
                predicatesArray[2] = builder.like(builder.upper(middlename), "%" + req.getSearchText().toUpperCase() + "%");

                Expression<String> email =
                        phoneBookRecordEntityRoot.get("email");
                predicatesArray[3] = builder.like(builder.upper(email), "%" + req.getSearchText().toUpperCase() + "%");

                criteriaQuery.where( // where
                            builder.or(  // firstname like  .... OR lastname like ... OR
                                    predicatesArray
                            )
                );
            }
            List<PhoneBookRecordEntity> found = (List<PhoneBookRecordEntity>)session.createQuery(criteriaQuery).list();
            mapToList(found, result.getList());
            session.close();
        }
        ErrorCodes ec = ErrorCodes.OK;
        result.setErrorDescription(TErrorDescription.newInstance(ec.getId(), ec.getMsg()));
        return result;
    }

    private final static String ADM_LOGIN = "admin";

    private void mapToList(Collection<PhoneBookRecordEntity> from, Collection<TRecordListElement4TPhoneBookRecordGetListRes> to){
        for(PhoneBookRecordEntity item : from){
            if(!ADM_LOGIN.equals(item.getLogin())) {
                TRecordListElement4TPhoneBookRecordGetListRes row = new TRecordListElement4TPhoneBookRecordGetListRes();
                row.setBirthDate(item.getBirthDate());
                row.setEmail(item.getEmail());
                row.setFirstName(item.getFirstname());
                row.setLogin(item.getLogin());
                row.setLastName(item.getLastname());
                row.setMiddleName(item.getMiddlename());
                row.setPhone(item.getPhone());
                row.setRecordGUID(item.getRecGUID());
                to.add(row);
            }
        }
    }
}
