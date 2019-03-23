package egovframework.rvw.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springmodules.validation.commons.DefaultBeanValidator;
import egovframework.dflt.ReviewVO;
import egovframework.phot.service.PhotService;
import egovframework.rater.service.RaterService;
import egovframework.rater.vo.Rater;
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
  
  @Autowired
  ServletContext sc;
  
  @Resource(name = "rvwService")
  private RvwService rvwService;
  
  @Resource(name = "raterService")
  private RaterService raterService;
  
  @Resource(name = "photService")
  private PhotService photService;
  
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
  @SuppressWarnings("null")
  @ResponseBody
  @RequestMapping(value = "/getRvwInfo", method = RequestMethod.POST)
  public Map<String, Object> getRvwInfo( @RequestParam(value="rst_no") int rst_no ) throws Exception {
    Map<String, Object> map = new HashMap<String, Object>();
    
    List<Rvw> list = rvwService.getRvwList(rst_no);
    map.put("rvwList", list);
    
    Rater rater = raterService.getRate(rst_no);
    if( rater == null) {
      logger.debug("\n\t/rater/getRate return null RATE : {}\n", rater.toString());
      rater = new Rater();
    }
    map.put("rate", rater);
    
    logger.info("\n\t/rvw/getRvwList Return {}\tAND\t{} RVWs..", rater.toString(), list.size() );
    return map;
  }
  
  /**
   * rvwList를 json으 전달
   * @param rst_no  - target rst의 rst_no
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/getList", method = RequestMethod.POST)
  public List<Rvw> getRvwList( @RequestParam(value="rst_no") int rst_no ) throws Exception {
    
    List<Rvw> list = rvwService.getRvwList(rst_no);
    
    logger.info("\n\t/rvw/getRvwList Return \t{} RVWs..", list.size() );
    return list;
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
   * rvw를 MultipartForm Data로 저장하기 위한 method
   * @param rvw
   * @return
   * @throws Exception
   */
  //@ResponseBody
  @RequestMapping(value = "/saveWith", method = RequestMethod.POST) //, consumes = "multipart/form-data" 
  public String RVW(
      @RequestPart(name="phot", required = false) MultipartFile phot,
      @RequestBody Rvw rvw 
      ) throws Exception {
    System.out.println("\nrvw/saveWith TEST");
    logger.info("\n\t/rvw/saveWITH receive -->\nrvw : {}", rvw.toString());
//    logger.info("\n\t/rvw/saveWITH receive -->\nrvwPhot : {}", phot.getSize());

    return "rvwTest";
  }
  
  @RequestMapping(value = "/Element", method = RequestMethod.POST) // , consumes = "multipart/form-data"
  public String Element(
      //@RequestPart(name="phot", required = false) MultipartFile phot,
      int rst_no, String id, String cont, int score
      ) throws Exception {
    System.out.println("\nrvw/Element FORM TEST");
    //logger.info("\n\t/rvw/Element receive -->\nrvwPhot : {}", phot.getSize());
    System.out.printf("%d, %s, %s, %d\n\n",rst_no , id , cont, score);
    return "rvwTest";
  }
  
  @RequestMapping(value = "/phot", method = RequestMethod.POST, consumes = "multipart/form-data") // 
  public String imgOnly(
      @RequestPart(name="phot", required = false) MultipartFile phot
      ) throws Exception {
    System.out.println("\nrvw/imageOnly FORM TEST");
    logger.info("\n\t/rvw/Object receive -->\nrvwPhot : {}\n", phot.getSize());
    return "rvwTest";
  }
  
  @RequestMapping(value = "/Object", method = RequestMethod.POST, consumes = "multipart/form-data") // 
  public String Object(
      @RequestPart(name="phot", required = false) MultipartFile phot,
      Rvw rvw
      ) throws Exception {
    System.out.println("\nrvw/Object FORM TEST");
    logger.info("\n\t/rvw/Object receive -->\nrvw : {}", rvw.toString());
    logger.info("\n\t/rvw/Object receive -->\nrvwPhot : {}\n", phot.getSize());
    return "rvwTest";
  }
  
  @RequestMapping(value = "/JSON", method = RequestMethod.POST, consumes = "multipart/form-data") // 
  public String JSON(
      @RequestPart(name="phot", required = false) MultipartFile phot,
      @RequestBody Rvw rvw
      ) throws Exception {
    System.out.println("\nrvw/Object FORM TEST");
    logger.info("\n\t/rvw/Object receive -->\nrvw : {}", rvw.toString());
    logger.info("\n\t/rvw/Object receive -->\nrvwPhot : {}\n", phot.getSize());
    return "rvwTest";
  }
  

  
  @ResponseBody
  @RequestMapping(value = "/elmtOnly", method = RequestMethod.POST, consumes = "multipart/form-data") // 
  public String elementOnly(
      int rst_no, String id, String cont, int score
      ) throws Exception {
    System.out.println("\nrvw/ElementOnly FORM TEST");
    System.out.printf("%d, %s, %s, %d\n\n",rst_no , id , cont, score);
    return "rvwTest";
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
  
  
  /**
   * 유진씨꺼 예제
   * @param vo
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value="/insertReview.do", method=RequestMethod.POST)
  public String insert (@RequestBody ReviewVO vo ) throws Exception{
  System.out.println("call");
  System.out.println(vo.toString());
     
     return "successs";
  }
  
}
