package egovframework.memb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
public class MembServiceImple implements MembService {

  private static final Logger logger = LoggerFactory.getLogger(MembServiceImple.class);

  @Override
  public Boolean login(String id, String pwd) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  
}
