package egovframework.rater.dao;

import egovframework.rater.vo.Rater;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name  : RaterDAO.java
 * @Discription : RaterDAO Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.12 최초생성
 *
 * @author 제하
 * @since 2019. 03.12
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Mapper("raterDao")
public interface RaterDAO {
  
  /**
   * rst_no에 해당하는 식당에 대한
   * 리뷰의 수와 평점의 합을 베이지안 확률과 평균에 대입하여
   * 평점을 구해 rater를 return함.
   * @param rst_no
   * @return
   * @throws Exception
   */
  Rater getRate(int rst_no) throws Exception;
  
}
