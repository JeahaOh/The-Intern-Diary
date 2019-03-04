package egovframework.memb.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.memb.DAO.MembDAO;
import egovframework.memb.vo.Memb;

/**
 * @Class Name  : MemvServiceImple.java
 * @Discription : Memb Buisiness Implement Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.03 최초생성
 *
 * @author 제하
 * @since 2019. 03.03
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Service("membService")
@Component
public class MembServiceImple implements MembService {

  private static final Logger logger = LoggerFactory.getLogger(MembServiceImple.class);

  @Resource(name="membDao")
  private MembDAO membDao;
  
  /**
   * 관리자 로그인을 한다.
   * 
   * @param id  - 회원의 id
   * @param pwd - 회원의 pwd
   * @return  로그인 한 회원
   * @throws Exception
   */
  @Override
  public Memb adminLogin(String id, String pwd) throws Exception {
    logger.info(id);
    return membDao.adminLogin(id, pwd);
  }

  
}
