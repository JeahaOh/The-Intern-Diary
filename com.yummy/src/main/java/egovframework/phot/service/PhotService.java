package egovframework.phot.service;

import egovframework.phot.vo.Phot;

/**
 * @Class Name  : PhotService.java
 * @Discription : PhotService Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.20 최초생성
 *
 * @author 제하
 * @since 2019. 03.20
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
public interface PhotService {
  
  /**
   * phot 테이블에 phot_no가 있는지 확인 하는 method
   * @param phot_no
   * @return
   * @throws Exception
   */
  Boolean getPhotNo(String phot_no) throws Exception;
  
  /**
   * phot 테이블에 식당 사진을 저장하는 method
   * @param phot
   * @return
   * @throws Exception
   */
  String saveRstPhot( Phot phot ) throws Exception;
  
  /**
   * phot 테이블에 리뷰 사진을 저장하는 method
   * @param phot
   * @return
   * @throws Exception
   */
  String saveRvwPhot( Phot phot ) throws Exception;

}
