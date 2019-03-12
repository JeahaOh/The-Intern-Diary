package egovframework.rst.service;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.dflt.DefaultVO;
import egovframework.rst.dao.RstDAO;
import egovframework.rst.vo.Rst;

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

@Service("rstService")
@Component
public class RstServiceImple implements RstService {

  private static final Logger logger = LoggerFactory.getLogger(RstServiceImple.class);

  @Resource(name="rstDao")
  private RstDAO rstDao;
  
  /**
   * Rst의 리스트를 반환
   * 
   * @return Rst의 List
   * @throws Exception
   */
  @Override
  public List<Rst> getList() throws Exception {
    return rstDao.getList();
  }

  /**
   * 식당 상세 정보를 가져온다.
   * 
   * @param id  - 식당 id
   * @return  Rst
   * @throws Exception
   */
  @Override
  public Rst getDetail(int id) throws Exception {
    logger.info(Integer.toString(id));
    return rstDao.getDetail(id);
  }

  /**
   * rst를 등록하기 위한 Service
   * 
   * @param   rst - 등록할 rst 갹체 
   * @return  성공 여부
   * @throws  Exception
   */
  @Override
  public int save(Rst rst) throws Exception {
    logger.info("Service {} ",rst.toString());
    if( rst.getRst_no() == 0 ){
      rst.setRst_no( rstDao.getLastRstNo() + 1 );
    }
    
    if ( rstDao.save(rst) ) {
      return rst.getRst_no();
    }
    
    return 0;
  }
  
  /**
   * rst를 삭제하기 위한 Service
   * 
   * @param   rst_no  - 삭제 할 rst의 no
   * @return  성공 여부
   * @throws Exception
   */
  @Override
  public Boolean delete(int rst_no) throws Exception {
    return rstDao.delete(rst_no);
  }
  
  /**
   * rst의 총 갯수를 조회한다.
   * 
   * @param rst  - 조회할 정보가 담긴 VO
   * @return 글의 총 갯수
   */
  @Override
  public int getTotCnt(DefaultVO searchVO) {
    return rstDao.getTotCnt(searchVO);
  }
}
