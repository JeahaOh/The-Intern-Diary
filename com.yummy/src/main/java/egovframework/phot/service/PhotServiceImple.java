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

  /**
   * phot 테이블에 phot_no가 있는지 확인 하는 method
   * @param phot_no
   * @return
   * @throws Exception
   */
  @Override
  public Boolean getPhotNo(String phot_no) throws Exception {
    logger.info( "\n\n\tphotService getPhotNo recieve {} \n\n", phot_no );
    return photDao.getPhotNo(phot_no);
  }

  /**
   * phot 테이블에 식당 사진을 저장하는 method
   * @param phot
   * @return
   * @throws Exception
   */
  @Override
  public String saveRstPhot(Phot phot) throws Exception {
    logger.info( "\n\tphotService recieve {}", phot.toString() );
    
//    //  rst_no에 대한 phot가 있다면,
//    if( photDao.getRstPhot(phot.getRst_no()).length() > 0 ) {
//      logger.info( "\n\tphotService TABLE phot has rst_no = {}", phot.getRst_no() );
//      //  rst_no에 대한 phot를 삭제.
//      photDao.deleteRstPhot( phot.getRst_no() );
//    }
    
    //  rst_no에 대한 phot가 없다면,
    if( photDao.getRstPhot(phot.getRst_no()).length() < 0 ) {
      //  phot객체 저장.
      if( photDao.saveRstPhot( phot ) ) {
        return "success";
      }
    }   else {
      logger.info( "\n\tphotService TABLE phot has rst_no = {}", phot.getRst_no() );
      //  rst_no에 대한 phot를 삭제.
      photDao.deleteRstPhot( phot.getRst_no() );
      //  phot객체 저장.
      if( photDao.saveRstPhot( phot ) ) {
        return "success";
      }
    }
    
    

    return "fail";
  }
  
  

}
