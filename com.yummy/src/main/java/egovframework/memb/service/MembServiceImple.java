package egovframework.memb.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.memb.DAO.MembDAO;
import egovframework.memb.vo.Memb;

/**
 * @Class Name  : MembServiceImple.java
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
   * id값이 있는지 확인 한다.
   * 
   * @param id  - 확인 할 id 값
   * @return id의 존재 여부
   * @throws Exception
   */
  @Override
  public String idCheck(String id) throws Exception {
    logger.info(id);
    return membDao.idCheck(id);
  }

  /**
   * 일반 회원의 회원 가입을 한다.
   * 
   * @param id  - memb의 ID
   * @param pwd - memb의 PWD
   * @param nick- memb의 nick
   * @return  회원 가입 성공 여부
   * @throws Exception
   */
  @Override
  public Boolean signUp(String id, String pwd, String nick) throws Exception {
    logger.info(id, nick);
    return membDao.signUp(id, pwd, nick);
  }
  
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
  
  /**
   * 일반 회원 로그인을 한다.
   * 
   * @param id  - 회원의 id
   * @param pwd - 회원의 pwd
   * @return  로그인 한 회원
   * @throws Exception
   */
  @Override
  public Memb login(String id, String pwd) throws Exception {
    logger.info(id);
    return membDao.login(id, pwd);
  }
  
  /**
   * 일반 회원의 탈퇴 기능
   * @Param id  - memb의 ID
   * @Throws Exception
   */
  @Override
  public void signOut(String id) throws Exception {
    logger.info(id);
    membDao.signOut(id);
  }
}
