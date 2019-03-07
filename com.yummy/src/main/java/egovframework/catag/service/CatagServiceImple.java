package egovframework.catag.service;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.catag.dao.CatagDAO;
import egovframework.catag.vo.Catag;

/**
 * @Class Name  : CatagServiceImple.java
 * @Discription : CatagServiceImple Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.06 최초생성
 *
 * @author 제하
 * @since 2019. 03.06
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Service("catagService")
@Component
public class CatagServiceImple implements CatagService {
  
  private static final Logger logger = LoggerFactory.getLogger(CatagServiceImple.class);
  
  @Resource(name="catagDao")
  private CatagDAO catagDao;
  
  /**
   * 모든 Catag List를 반환
   * @return
   * @throws Exception
   */
  @Override
  public List<Catag> getList() throws Exception {
    return catagDao.getList() ;
  }

  /**
   * 하위 catag에 대한 상위 catag List를 보내준다
   * @return catag List
   * @throws Exception
   */
  @Override
  public List<Catag> getRstUpperCatagList() throws Exception {
    return catagDao.getRstCatagList(10);
  }

  /**
   * upper_no에 대한 하위 catag List를 보내준다
   * @param upper_no - catag의 부모 catag_no
   * @return catag List
   * @throws Exception
   */
  @Override
  public List<Catag> getRstLowerCatagList(int upper_no) throws Exception {
    logger.info(Integer.toString(upper_no));
    return catagDao.getRstCatagList(upper_no);
  }
}