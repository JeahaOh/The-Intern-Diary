package egovframework.rst.web;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import egovframework.catag.service.CatagService;
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
  
  @Resource(name = "catagService")
  private CatagService catagService;
  
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
  
  /**
   * rst 상세 정보 출력
   * 
   * @param model
   * @param id    - 출력 할 rst의 id
   * @return      - rstDetail.jsp
   * @throws Exception
   */
  @RequestMapping(value="/detail", method= RequestMethod.GET)
  public String rstDetail(Model model, int id) throws Exception {
    Rst rst = rstService.getDetail(id);
    model.addAttribute("rst", rst);
    
    logger.info(rst.toString());
    model.addAttribute("upperCatagList", catagService.getRstUpperCatagList());
    model.addAttribute("catagList", catagService.getRstLowerCatagList(rst.getUpper_no()));
    model.addAttribute("mode", "Modify");
    
    logger.info(model.toString(), id);
    return "rst/rstDetail";
  }
  
  /**
   * rst 등록 페이지를 출력
   * 
   * @param   model - 상위 분류와 rstDetail.jsp의 상태지정을 위한 data 전달
   * @return  rstDetail.jsp
   * @throws  Exception
   */
  @RequestMapping(value="/save", method= RequestMethod.GET)
  public String saveRst(Model model) throws Exception {
    model.addAttribute("upperCatagList", catagService.getRstUpperCatagList());
    model.addAttribute("mode", "Create");

    logger.info(model.toString());
    return "rst/rstDetail";
  }
  
  /**
   * rst를 등록하기 위한 POST URL
   * @param   rst - 등록할 rst 
   * @return  JSON 객체 true / false
   * @throws  Exception
   */
  @RequestMapping(value="/save", method= RequestMethod.POST)
  public @ResponseBody String saveRst( @RequestBody Rst rst ) throws Exception {
    logger.info("/rst/save {}", rst.toString());
    if( rstService.save(rst) ) {
      return "true";
    }
    return "false";
  }
  
  /**
   * rst를 삭제하기 위한 POST URL
   * @param   rst_no  - 삭제 할 rst의 no
   * @return  JSON 객체 true / false
   * @throws Exception
   */
  @RequestMapping(value="/delete", method= RequestMethod.POST)
  public @ResponseBody String deleteRst( @RequestBody int rst_no ) throws Exception {
    logger.info("/rst/delete {}", rst_no);
    if( rstService.delete( rst_no ) ) {
      return "true";
    }
    return "false";
  }
}
