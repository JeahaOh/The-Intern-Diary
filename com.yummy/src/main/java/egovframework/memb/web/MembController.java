package egovframework.memb.web;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import egovframework.memb.service.MembService;

/**
 * @Class Name  : MembController.java
 * @Discription : Memb Controller Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.03 최초생성
 *
 * @author 제하
 * @since 2019. 03.03
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Controller
public class MembController {
  
  private static final Logger logger = LoggerFactory.getLogger(MembController.class);
  
  @Resource(name = "membService")
  private MembService membService;
  
  /**
   * 로그인을 한다.
   * 
   * @param id  - 로그인 할 id
   * @param pwd - memb의 비밀번호
   * @return 
   * @exception Exception
   */
  @RequestMapping(value="/memb/login.do", method= RequestMethod.POST)
  public Boolean login(@RequestParam String id, @RequestParam String pwd)  throws Exception {
    logger.info(id);
    System.out.println("login\n" + id + "\n" + pwd);
    return true;
  }
}
