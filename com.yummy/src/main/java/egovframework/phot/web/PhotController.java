package egovframework.phot.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
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
  
  @ResponseBody
  @RequestMapping(value = "/rstPhotSave", method = RequestMethod.POST, consumes = {"multipart/form-data"} )
  public String rstPhot(
      @RequestPart MultipartFile rst_phot
      ,@RequestParam(name = "rst_no") int rst_no
      ) throws Exception{
    logger.info( "\n\t/phot/rst_phot recieve\n\trst_no = {} phot.size =  {}", rst_no, rst_phot.getSize() );
    
    Phot phot;
    
    //  사진이 있다면 처리 시
    if (rst_phot != null && rst_phot.getSize() > 0) {
      //  저장할 파일 이름을 UUID로 만듦.
      String rst_phot_name = getUUID();
      
      try {
        //  저장 경로 
        String path = sc.getRealPath("/resources/images/rst/").toString();
        
        //  파일 저장
        rst_phot.transferTo( new File( sc.getRealPath( "/resources/images/rst/" + rst_phot_name ) ) );
        logger.info( "\n\trst_phot  set new name as {}\n\tAnd Save At {}\n", rst_phot_name, path + rst_phot_name );
        
        phot = new Phot();
        phot.setPhot_no(rst_phot_name);
        phot.setRst_no(rst_no);
        
        
      } catch (IOException e) {
        logger.info("\n\t/phot/rstPhotSave Error Occur\n{} \n", e.toString());
        return "fail";
      }
      
      return photService.saveRstPhot( phot );
    }
    
    return "phot is null or < 0";
  }
  
  private String getUUID() throws Exception {
    String str = UUID.randomUUID().toString();
    logger.info("\n\tgetUUID {}", str);
    //  UUID 중복 체크를 위한 콜백 함수를 구현하고 싶지만 시간 관계상 넘어가도록 하자.
//    if( photService.getPhotNo( str ) ) {
//      logger.info("\n\tgetUUID callback getUUID -> {}", str);
//      getUUID();
//    }
    
    return str;
  }

}
