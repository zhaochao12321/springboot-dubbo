package zhao.xiaobai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zhao.xiaobai.Service.UserService;
import zhao.xiaobai.common.ResponseTemplate;
import zhao.xiaobai.common.ResultStat;


@RestController

public class webController {
    @Autowired
    UserService userService;
    //@RequestMapping("/xiaobai/first/{message}")
    //@GetMapping("/api/companies/page")
    @GetMapping("/xiaobai/first/{id}")
    public ResponseTemplate<?> firstController(@PathVariable String id){

        return ResultStat.OK.wrap(userService.getUserMessage(id));
    }
}
