package zhao.xiaobai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zhao.xiaobai.Pojo.User;
import zhao.xiaobai.Service.UserService;
import zhao.xiaobai.common.ResponseTemplate;
import zhao.xiaobai.common.ResultStat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

public class webController {
    @Autowired
    UserService userService;

    //@RequestMapping("/xiaobai/first/{message}")
    //@GetMapping("/api/companies/page")
    @GetMapping("/xiaobai/first/{id}")
    public ResponseTemplate<?> firstController(@PathVariable String id) {

        return ResultStat.OK.wrap(userService.getUserMessage(id));
    }

    @GetMapping("/xiaobai/second")
    public ModelAndView getindxx(@RequestParam String name) {
        //ModelAndView modelAndView = new ModelAndView("redirect:www.baidu.com"); 重定向
        ModelAndView modelAndView = new ModelAndView("redirect:http://www.baidu.com");
        Map<String, List<User>> data = new HashMap<>();
        modelAndView.addAllObjects(data);
        return modelAndView;
    }

    @GetMapping("/xiaobai/port")
    public String grtport(HttpServletRequest request) {
        request.getRemoteHost();
        return  request.getRemoteAddr()+request.getRemoteHost();
    }




}
