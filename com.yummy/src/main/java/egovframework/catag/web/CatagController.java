package egovframework.catag.web;

import org.slf4j.LoggerFactory;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import egovframework.catag.service.CatagService;
import egovframework.catag.vo.Catag;

@Controller
@RequestMapping("/catag")
public class CatagController {
  
  private static final Logger logger = LoggerFactory.getLogger(CatagController.class);
  
  @Resource(name = "catagService")
  private CatagService catagService;
  
  @RequestMapping(value="/get", method= RequestMethod.POST, produces = "application/json;charset=utf-8")
  public @ResponseBody List<Catag> getCatag(
      @RequestParam(value="upper_no", required=true) int upper_no)
          throws Exception {
    logger.info(Integer.toString(upper_no));
    
    return catagService.getRstLowerCatagList(upper_no);
  }
}
