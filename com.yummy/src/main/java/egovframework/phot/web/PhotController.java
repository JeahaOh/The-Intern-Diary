package egovframework.phot.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
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
  
  @Autowired ServletContext sc;
  
  @ResponseBody
  @RequestMapping(value = "/rst_phot", method = RequestMethod.POST, consumes = {"multipart/form-data"} )
  public String rstPhot(
      @RequestPart MultipartFile rst_phot
      ,@RequestParam(name = "rst_no") int rst_no
      ) throws IOException{
    logger.info( "\n\t/phot/rst_phot recieve\n\trst_no = {} phot.size =  {}", rst_no, rst_phot.getSize() );
    
    //  사진 처리하기
    if (rst_phot != null && rst_phot.getSize() > 0) {
      String rst_phot_name = UUID.randomUUID().toString();
      
      String path = sc.getRealPath("/resources/images/rst/").toString();
      logger.info( "\n\trst_phot  set new name as {}\n\tAnd Save At {}\n", rst_phot_name, path + rst_phot_name );
      
      rst_phot.transferTo( new File( sc.getRealPath( path + rst_phot_name) ) );

    }
    
    return "recieve";
  }

}
