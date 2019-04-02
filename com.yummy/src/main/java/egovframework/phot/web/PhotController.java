package egovframework.phot.web;

import java.io.File;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import egovframework.phot.service.PhotService;
import egovframework.phot.vo.Phot;
import egovframework.rst.web.RstController;

/**
 * @Class Name  : RstController.java
 * @Discription : Rst Controller Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.20 최초생성
 *
 * @author 제하
 * @since 2019. 03.20
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Controller
@RequestMapping("/phot")
public class PhotController {
  
  private static final Logger logger = LoggerFactory.getLogger(RstController.class);
  
  @Autowired
  ServletContext sc;
  
  @Resource(name = "photService")
  private PhotService photService;
  
  /**
   * phot 테이블에 식당 사진을 저장하는 method
   * @param rst_phot
   * @param rst_no
   * @return
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "/rstPhotSave", method = RequestMethod.POST, consumes = {"multipart/form-data"} )
  public String rstPhot(
      @RequestPart MultipartFile rst_phot
      ,@RequestParam(name = "rst_phot_name") String rst_phot_name
//      ,@RequestParam(name = "rst_no", required=false) int 
      ) throws Exception{
    Phot phot;
    //  사진이 있다면 처리 시
    if (rst_phot != null && rst_phot.getSize() > 0) {
      try {
        
        //  파일 저장
        rst_phot.transferTo( new File( sc.getRealPath( "/resources/images/rst/" + rst_phot_name ) ) );
        
        //  phot 객체 생성후, rst_no와 phot_no 값 설정.
        phot = new Phot();
        phot.setPhot_no(rst_phot_name);
        
      } catch (IOException e) {
        logger.info("\n\t/phot/rstPhotSave Error Occur\n{} \n", e.toString());
        return "fail";
      }
      logger.info( "\n\t/phot/rst_phot recieve\n\trst_phot_name = {}\n\tphot.size =  {}", rst_phot_name, rst_phot.getSize() );
      logger.info( "\n\trst_phot  set new name as {}\n\tAnd Save At {}\n"
          , rst_phot_name
          , sc.getRealPath("/resources/images/rst/").toString() + rst_phot_name );
      //  photService.saveRstPhot() 실행.
      return photService.saveRstPhot( phot );
    }
    
    return "phot is null or < 0";
  }
}
