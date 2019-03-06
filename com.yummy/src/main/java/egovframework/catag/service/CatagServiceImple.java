package egovframework.catag.service;

import java.util.List;
import javax.annotation.Resource;
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

  @Override
  public List<Catag> getRstUpperCatagList() throws Exception {
    return catagDao.getRstCatagList(10);
  }

  @Override
  public List<Catag> getRstLowerCatagList(int upper_no) throws Exception {
    return catagDao.getRstCatagList(upper_no);
  }
}