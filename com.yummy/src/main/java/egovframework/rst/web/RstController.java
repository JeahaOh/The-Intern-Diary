package egovframework.rst.web;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;
import egovframework.catag.service.CatagService;
import egovframework.dflt.DefaultVO;
import egovframework.phot.service.PhotService;
import egovframework.phot.vo.Phot;
import egovframework.rst.service.RstService;
import egovframework.rst.vo.Rst;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

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
  
  @Resource(name = "photService")
  private PhotService photService;
  
  @Resource(name = "catagService")
  private CatagService catagService;
  
  /** EgovPropertyService */
  @Resource(name = "propertiesService")
  protected EgovPropertyService propertiesService;

  /** Validator */
  @Resource(name = "beanValidator")
  protected DefaultBeanValidator beanValidator;
  
  /**
   * rst목록을 출력
   * 
   * @param id  - 로그인 할 id
   * @param pwd - memb의 비밀번호
   * @return 
   * @exception Exception
   */
  @RequestMapping(value="/list", method= RequestMethod.GET)
  public String rstList(
      @ModelAttribute("searchVO") DefaultVO searchVO, ModelMap model
          ) throws Exception {
    
    searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    searchVO.setPageSize(propertiesService.getInt("pageSize"));
    
    PaginationInfo paginationInfo = new PaginationInfo();
    paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
    paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
    paginationInfo.setPageSize(searchVO.getPageSize());
    
    searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
    searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
    searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
    
    List<Rst> rstList = rstService.getList();
    model.addAttribute("rstList", rstList);
    
    int totCnt = rstService.getTotCnt(searchVO);
    paginationInfo.setTotalRecordCount(totCnt);
    model.addAttribute("paginationInfo", paginationInfo);
    
    logger.info(rstList.toString());
    return "rst/rstList";
  }
  
  @ResponseBody
  @RequestMapping(value="/rstList", method= RequestMethod.GET)
  public List<Rst> list() throws Exception {
    List<Rst> list = rstService.getList();
    logger.info("\n\trst/rstList return {} rsts...", list.size() );
    return list;
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
   * rst JSON 객체 return
   * @param rst_no  - return할 rst의 rst_no
   * @return  JSON형식의 rst
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/rstDetail", method = RequestMethod.POST)
  public Rst rstDetail( @RequestParam int rst_no) throws Exception {
    Rst rst = rstService.getDetail(rst_no);
    logger.info("\n\t/rst/rstDetail return {}", rst.toString());
    return rst;
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
  @RequestMapping(value="/create", method= RequestMethod.POST)
  public @ResponseBody int save(
      @RequestBody Rst rst
      ) throws Exception {
    logger.info("\n/rst/save {}", rst.toString());
    int result = rstService.save(rst);
    if( result != 0 ) {
      Phot phot = new Phot();
      phot.setPhot_no( rst.getRst_phot() );
      phot.setRst_no( rst.getRst_no() );
      photService.updatePhot(phot);
      return result;
    }
    return 0;
  }
  
  @RequestMapping(value="/update", method= RequestMethod.POST)
  public @ResponseBody int update(
      @RequestBody Rst rst
      ) throws Exception {
    logger.info("\n/rst/update recieve {}", rst.toString());
    int result = rstService.save(rst);
    logger.info("\n\trst/update save rst {}", result);
    if( result != 0 ) {
      Phot phot = new Phot();
      phot.setPhot_no( rst.getRst_phot() );
      phot.setRst_no( rst.getRst_no() );
      logger.info("\n\trst/update has Phot {}", phot.toString() );
      photService.updatePhot(phot);
      return result;
    }
    return 0;
  }
  
  /**
   * rst를 삭제하기 위한 POST URL
   * @param   rst_no  - 삭제 할 rst의 no
   * @return  JSON 객체 true / false
   * @throws Exception
   */
  @RequestMapping(value="/delete", method= RequestMethod.POST)
  public @ResponseBody String deleteRst( @RequestParam int rst_no ) throws Exception {
    logger.info("\n\t/rst/delete {}", rst_no);
    
    if( rstService.delete( rst_no ) ) {
      return "success";
    }
    return "fail";
  }
}
