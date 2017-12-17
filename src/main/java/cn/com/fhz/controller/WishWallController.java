package cn.com.fhz.controller;

import cn.com.fhz.entity.ResponseEntity;
import cn.com.fhz.entity.WishWallEntity;
import cn.com.fhz.service.WishWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by woni on 17/12/17.
 */
@RestController
@RequestMapping("wishWall")
public class WishWallController {

    @Autowired
    WishWallService wishWallService;

    @RequestMapping("save")
    public Object saveWishWall(WishWallEntity wishWallEntity){

        wishWallEntity.setCreateTime(new Date());

        ResponseEntity entity = new ResponseEntity();

        Integer countUser = 0;

        if (wishWallEntity.getFromUserId()!=null){
            countUser = wishWallService.countUser(wishWallEntity.getFromUserId());

            if (countUser>=3){

                entity.setMsg("您已经祝福三遍了，非常感谢您");
                entity.setStatus(false);

            }
        }

        if (countUser<3){
            Integer result = wishWallService.save(wishWallEntity);

            if (null!=result){
                if (result>0){
                    entity.setStatus(true);
                    entity.setMsg("保存成功");
                }
            }
        }



        return entity;

    }


    @RequestMapping("getAllWishWall")
    public Object getAllWishWall(@RequestParam(value = "userId",required = false,defaultValue = "1")String userId){

        List<WishWallEntity> entities = wishWallService.getWishWallByUserId(userId);

        return entities;

    }


}
