package cn.com.fhz.service.impl;

import cn.com.fhz.dao.WishWallDao;
import cn.com.fhz.entity.WishWallEntity;
import cn.com.fhz.service.WishWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by woni on 17/12/17.
 */
@Service
public class WishWallServiceImpl implements WishWallService{

    @Autowired
    WishWallDao wishWallDao;

    @Override
    public List<WishWallEntity> getWishWallByUserId(String userId) {
        return wishWallDao.getWishWallByUserId(userId);
    }

    @Override
    public Integer save(WishWallEntity wishWallEntity) {
        WishWallEntity save = wishWallDao.save(wishWallEntity);
        if (save.getId()!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public Integer countUser(String fromUserId) {
        return wishWallDao.countAllByFromUserId(fromUserId);
    }
}
