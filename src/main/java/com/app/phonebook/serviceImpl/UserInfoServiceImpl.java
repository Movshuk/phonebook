package com.app.phonebook.serviceImpl;

import com.app.phonebook.model.UserInfo;
import com.app.phonebook.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    final
    EntityManagerFactory emf;

    public UserInfoServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UserInfo getUserInfoByEmail(String email) {
        EntityManager em = emf.createEntityManager();

        List<UserInfo> listU = em.createQuery(
                "select u from UserInfo u where u.email = :email",
                    UserInfo.class)
                .setParameter("email", email)
                .getResultList();

        UserInfo result = null;
        if(listU.size() == 0) {
            return null;
        } else {
            result = listU.get(0);
        }

        em.close();

        return result;
    }

    public boolean addUserInfo(UserInfo userReq) {
        EntityManager em = emf.createEntityManager();

        UserInfo userRes = new UserInfo(
                userReq.getEmail(),
                userReq.getPassword(),
                userReq.getRole()
        );

        em.getTransaction().begin();

        em.persist(userRes);

        em.getTransaction().commit();
        em.close();

        return true;
    }


    public UserInfo getUserInfoFromQuery(Query query) {
        List<Object[]> rows = query.getResultList();
        List<UserInfo> result = new ArrayList<>(rows.size());
//        result.add((UserInfo)rows.get(0));

        if(rows != null){
            for (var row : rows) {
                var item0 =  row[0];
                var item1 =  row[1];
                var item2 =  row[2];

                String email = (String)item0;
                String pass  = (String)item1;

//                result.add(new UserInfo(
//                        (String) row[0],
//                        (String) row[1],
//                        (String) row[2]));
            }
        }

        return result.get(0);
    }



}
