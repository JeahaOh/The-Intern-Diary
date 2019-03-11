package egovframework.rvw.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rvw.service.RvwService;
import egovframework.rvw.vo.Rvw;

/**
 * @Class Name  : RvwController.java
 * @Discription : RvwController Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.07 최초생성
 *
 * @author 제하
 * @since 2019. 03.07
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Controller
@RequestMapping("/rvw")
public class RvwController {
  
  private static final Logger logger = LoggerFactory.getLogger(RvwController.class);
  
  @Resource(name = "rvwService")
  private RvwService rvwService;
  
  /** EgovPropertyService */
  @Resource(name = "propertiesService")
  protected EgovPropertyService propertiesService;

  /** Validator */
  @Resource(name = "beanValidator")
  protected DefaultBeanValidator beanValidator;
  
  @RequestMapping("/test")
  public String test() throws Exception {
    System.out.println("rvwTest");
    return "rvwTest";
  }
  
  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String createRvw( @RequestBody Rvw rvw ) throws Exception {
    logger.info("\n\t/rvw/save receive --> {}", rvw.toString());
    if( rvwService.save(rvw)) {
      return "success";
    } 
    return "fail";
  }
  
  
  @ResponseBody
  @RequestMapping(value = "/getRvwList", method = RequestMethod.POST)
  public List<Rvw> getRvwList( @RequestParam(value="rst_no") int rst_no ) throws Exception {
    System.out.println("call");
    List<Rvw> list = rvwService.getRvwList(rst_no);
    logger.info("\n\t/rvw/getRvwList Return {} RVWs..", list.size() );
    return list;
  }
  
  @ResponseBody
  @RequestMapping(value = "/getRvwInfo", method = RequestMethod.POST)
  public Map<String, Object> getRvwInfo( @RequestParam(value="rst_no") int rst_no ) throws Exception {
    List<Rvw> list = rvwService.getRvwList(rst_no);
    
    Map<String, Object> map = new HashMap<String, Object>();
    List<Integer> rating = new ArrayList<>();
    
    
    map.put("rvwList", list);
    
    logger.info("\n\t/rvw/getRvwList Return {} RVWs..", list.size() );
    return map;
  }
  
  @ResponseBody
  @RequestMapping(value = "/getRvwDtl", method = RequestMethod.POST)
  public Rvw getRvwDtl ( @RequestParam(value="rvw_no") int rvw_no ) throws Exception {
    Rvw rvw = rvwService.getRvwDtl(rvw_no);
    logger.info("\n\t/rvw/getRvwDtl Return {} RVW..", rvw.toString() );
    return rvw;
  }
  
  @ResponseBody
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public String delete ( @RequestParam(value = "rvw_no")  int rvw_no ) throws Exception {
    logger.info("\n\t/rvw/delete receive --> {}", Integer.toString(rvw_no));
    if( rvwService.delete(rvw_no)) {
      return "success";
    }
    return "fail";
  }
  
  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update ( @RequestBody Rvw rvw ) throws Exception {
    logger.info("\n\t/rvw/update recieve --> {}", rvw.toString() );
    
    if( rvwService.update(rvw) ) {
      return "success";
    }
    return "fail";
  }
}
