package cn.com.fhz.dao;

import cn.com.fhz.entity.WishWallEntity;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by woni on 17/12/17.
 */
@Component
@CacheConfig(cacheNames = "wishWallCache")
public interface WishWallDao extends JpaRepository<WishWallEntity,String>,PagingAndSortingRepository<WishWallEntity,String>{

    @Cacheable(key = "#p0")
    @Query("select ww from WishWallEntity ww where ww.userId=:userId")
    List<WishWallEntity> getWishWallByUserId(@Param("userId") String userId);

    @Cacheable(key = "#p0")
    @Query("select count(*) from WishWallEntity ww where ww.fromUserId=:fromUserId")
    Integer countAllByFromUserId(@Param("fromUserId") String fromUserId);

}
