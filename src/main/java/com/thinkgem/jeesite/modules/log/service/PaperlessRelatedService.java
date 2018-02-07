package com.thinkgem.jeesite.modules.log.service;

import com.thinkgem.jeesite.modules.log.dao.PaperlessRelatedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wzw on 2018/1/18.
 */
@Service
public class PaperlessRelatedService {

    @Autowired
    private PaperlessRelatedDao paperlessRelatedDao;

    public String findPaperlessProvinces(){
        return paperlessRelatedDao.findPaperlessProvinces();
    }
    public String findPaperlessBranches(){
        return paperlessRelatedDao.findPaperlessBranches();
    }
    public String findPaperlessUsers(){
        return paperlessRelatedDao.findPaperlessUsers();
    }
}
