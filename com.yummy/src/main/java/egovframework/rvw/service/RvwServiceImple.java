package egovframework.rvw.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.rvw.dao.RvwDAO;

/**
 * @Class Name  : RvwServiceImple.java
 * @Discription : RvwServiceImple Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.07 최초생성
 *
 * @author 제하
 * @since 2019. 03.07
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Service("rvwService")
@Component
public class RvwServiceImple implements RvwService {
  
  private static final Logger logger = LoggerFactory.getLogger(RvwServiceImple.class);
  
  @Resource(name = "rvwDao")
  private RvwDAO rvwDao;
  
  
}
