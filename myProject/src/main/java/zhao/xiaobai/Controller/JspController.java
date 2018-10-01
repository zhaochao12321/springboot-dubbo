package zhao.xiaobai.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class JspController {


    @GetMapping("/xiaobai/jsp")
    public ModelAndView goJsp() {

        //return  "xiaobai";
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("xiaobai");
        return modelAndView;
    }
}
