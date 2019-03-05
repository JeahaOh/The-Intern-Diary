package egovframework.rst.web;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import egovframework.rst.service.RstService;
import egovframework.rst.vo.Rst;

/**
 * @Class Name  : RstController.java
 * @Discription : Rst Controller Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.04 최초생성
 *
 * @author 제하
 * @since 2019. 03.04
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Controller
@RequestMapping("/rst")
public class RstController {
  
  private static final Logger logger = LoggerFactory.getLogger(RstController.class);
  
  @Resource(name = "rstService")
  private RstService rstService;
  
  /**
   * rst목록을 출력
   * 
   * @param id  - 로그인 할 id
   * @param pwd - memb의 비밀번호
   * @return 
   * @exception Exception
   */
  @RequestMapping(value="/list", method= RequestMethod.GET)
  public String rstList(HttpSession session, Model model) throws Exception {
    logger.info(session.toString());
    
    List<Rst> rstList = rstService.getList();
    logger.info(rstList.toString());
    
    model.addAttribute("rstList", rstList);
    
    return "rst/rstList";
  }
  
  @RequestMapping(value="/detail", method= RequestMethod.GET)
  public String rstDetail(HttpSession session, Model model, int id) throws Exception {
    logger.info(session.toString(), model, id);
    
    model.addAttribute("rst", rstService.getDetail(id));
    
    return "rst/rstDetail";
  }
}
