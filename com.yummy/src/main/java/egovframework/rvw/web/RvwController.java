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
  
  
  /**
   *  /rvw/test/ 화면으로 이동
   * @return
   * @throws Exception
   */
  @RequestMapping("/test")
  public String test() throws Exception {
    System.out.println("rvwTest");
    return "rvwTest";
  }
  
  /**
   * rvwList와 rst의 rvw 정보들 json 전달
   * @param rst_no  - target rst의 rst_no
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/getRvwInfo", method = RequestMethod.POST)
  public Map<String, Object> getRvwInfo( @RequestParam(value="rst_no") int rst_no ) throws Exception {
    Map<String, Object> map = new HashMap<String, Object>();
    
    List<Rvw> list = rvwService.getRvwList(rst_no);
    map.put("rvwList", list);
    
    List<Integer> rating = new ArrayList<>();
//  rating에 들어 가야 할 것..?
    
    
    logger.info("\n\t/rvw/getRvwList Return {}\tAND\t{} RVWs..", rating.toString(), list.size() );
    return map;
  }
  
  /**
   * rvw 상세 정보 JSON 전달
   * @param rvw_no
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/getRvwDtl", method = RequestMethod.POST)
  public Rvw getRvwDtl ( @RequestParam(value="rvw_no") int rvw_no ) throws Exception {
    Rvw rvw = rvwService.getRvwDtl(rvw_no);
    logger.info("\n\t/rvw/getRvwDtl Return {} RVW..", rvw.toString() );
    return rvw;
  }
  
  /**
   * rvw 저장
   * @param rvw
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String createRvw( @RequestBody Rvw rvw ) throws Exception {
    logger.info("\n\t/rvw/save receive --> {}", rvw.toString());
    if( rvwService.save(rvw)) {
      return "success";
    } 
    return "fail";
  }
  
  /**
   * rvw 수정
   * @param rvw
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update ( @RequestBody Rvw rvw ) throws Exception {
    logger.info("\n\t/rvw/update recieve --> {}", rvw.toString() );
    
    if( rvwService.update(rvw) ) {
      return "success";
    }
    return "fail";
  }
  
  /**
   * rvw 삭제
   * @param rvw_no
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public String delete ( @RequestParam(value = "rvw_no")  int rvw_no ) throws Exception {
    logger.info("\n\t/rvw/delete receive --> {}", Integer.toString(rvw_no));
    if( rvwService.delete(rvw_no)) {
      return "success";
    }
    return "fail";
  }
}
