package cn.com.fhz.service;

import cn.com.fhz.entity.WishWallEntity;

import java.util.List;

/**
 * Created by woni on 17/12/17.
 */
public interface WishWallService {

    List<WishWallEntity> getWishWallByUserId(String userId);

    Integer save(WishWallEntity wishWallEntity);

    /**
     *  统计当前用户，有几次祝福了
     *
     * @param fromUserId
     * @return
     */
    Integer countUser(String fromUserId);

}
