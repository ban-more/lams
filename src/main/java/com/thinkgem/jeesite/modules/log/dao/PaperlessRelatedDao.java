package com.thinkgem.jeesite.modules.log.dao;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDaoThree;

import java.util.List;
import java.util.Map;

/**
 * Created by wzw on 2018/1/18.
 */
@MyBatisDaoThree
public interface PaperlessRelatedDao {

    public String findPaperlessProvinces();
    public String findPaperlessBranches();
    public String findPaperlessUsers();
}
