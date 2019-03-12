package egovframework.rater.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.rater.dao.RaterDAO;
import egovframework.rater.vo.Rater;

/**
 * @Class Name  : RaterServiceImple.java
 * @Discription : RaterServiceImple Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.12 최초생성
 *
 * @author 제하
 * @since 2019. 03.12
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Service("raterService")
@Component
public class RaterServiceImple implements RaterService {
  
  private static final Logger logger = LoggerFactory.getLogger(RaterServiceImple.class);
  
  @Resource(name = "raterDao")
  private RaterDAO raterDao;
  
  /**
   * rst_no에 해당하는 식당에 대한
   * 리뷰의 수와 평점의 합을 베이지안 확률과 평균에 대입하여
   * 평점을 구해 rater를 return함.
   * @param rst_no
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unused")
  @Override
  public Rater getRate(int rst_no) throws Exception {
    Rater rate = raterDao.getRate(rst_no); 
    logger.info("\n\t RaterService retutn Rate ==> {}\n", rate.toString());
    if( rate != null ) {
      return rate;
    }
    return new Rater();
  }
  
  
}
