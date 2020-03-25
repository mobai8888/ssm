package com.sun.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName QueryVo
 * @description:
 * @author: lk
 * @create: 2020-01-13 16:25
 * @Version 1.0
 **/
public class QueryVo implements Serializable{
    private User user;
    private List<Integer> ids;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
