package egovframework.phot.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.phot.dao.PhotDAO;
import egovframework.phot.vo.Phot;

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

  @Override
  public Boolean getPhotNo(String phot_no) throws Exception {
    logger.info( "\n\n\tphotService getPhotNo recieve {} \n\n", phot_no );
    return photDao.getPhotNo(phot_no);
  }

  @Override
  public String saveRstPhot(Phot phot) throws Exception {
    logger.info( "\n\tphotService recieve {}", phot.toString() );
    
    if( photDao.getRstPhot(phot.getRst_no()).length() > 0 ) {
      logger.info( "\n\tphotService TABLE phot has rst_no = {}", phot.getRst_no() );
      photDao.deleteRstPhot( phot.getRst_no() );
    }
    
    if( photDao.saveRstPhot( phot ) ) {
      return "success";
    }
    return "fail";
  }
  
  

}
