package gzcc.zyj.blood.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Admin on 2017/6/7.
 */
@Controller
public class index {

//设置主页
    @RequestMapping(value = {"", "/"})
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.html");
        return mav;
    }
}