package com.slj.jinjihu.backend.dao;

import com.slj.jinjihu.backend.utils.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class UserNativeDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List findUserByCondition(Map<String, String> params) {
        StringBuilder sql = new StringBuilder("select id id,user_name userName from user where 1=1");
        if (MapUtil.isNotBlankKey("userName", params)) {
            sql.append(" and user_name=:userName");
        }
        if (MapUtil.isNotBlankKey("password", params)) {
            sql.append(" and password=:password");
        }
        if (MapUtil.isNotBlankKey("limit", params)) {
            sql.append(" limit :limit");
        }
        NativeQueryImpl nativeQuery = entityManager.createNativeQuery(sql.toString()).unwrap(NativeQueryImpl.class);
        if (MapUtil.isNotBlankKey("userName", params)) {
            nativeQuery.setParameter("userName", params.get("userName"));
        }
        if (MapUtil.isNotBlankKey("password", params)) {
            nativeQuery.setParameter("password", params.get("password"));
        }
        if (params.containsKey("limit") && StringUtils.isNotBlank("limit")) {
            nativeQuery.setParameter("limit", Integer.parseInt(params.get("limit")));
        }
        nativeQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return nativeQuery.getResultList();
    }
}
