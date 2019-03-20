package egovframework.phot.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.phot.dao.PhotDAO;

/**
 * @Class Name  : PhotServiceImple.java
 * @Discription : PhotServiceImple Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.20 최초생성
 *
 * @author 제하
 * @since 2019. 03.20
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Service("photService")
@Component
public class PhotServiceImple implements PhotService {
  
  private static final Logger logger = LoggerFactory.getLogger(PhotService.class);
  
  @Resource(name = "photDao")
  private PhotDAO photDao;
  

}
