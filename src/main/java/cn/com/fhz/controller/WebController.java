package cn.com.fhz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by woni on 17/12/4.
 */
@Controller
public class WebController {
    @RequestMapping("/index")
    public String getIndex(){
        return "BirthdayCake";
    }

    @RequestMapping("memories")
    public String getMemories(){
        return "Memories";
    }

    @RequestMapping("birthdayCake")
    public String getBrithdayCake(){
        return "BirthdayCake";
    }

    @RequestMapping("wishWall")
    public String intoWishWall(){
        return "wishWall";
    }

}
