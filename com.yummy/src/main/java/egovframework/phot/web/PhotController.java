package egovframework.phot.web;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
  
  @ResponseBody
  @RequestMapping(value = "/rst_phot", method = RequestMethod.POST, consumes = {"multipart/form-data"} )
  public String rstPhot(
      @RequestPart MultipartFile rst_phot
      //, int rst_no
      ) throws IOException{
    logger.info( "\n\t/phot/rst_phot recieve {} {}", /*rst_no,*/ rst_phot.getSize() );
    
    return "recieve";
  }

}
