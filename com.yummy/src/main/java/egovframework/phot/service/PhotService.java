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
  
  Boolean getPhotNo(String phot_no) throws Exception;
  
  String saveRstPhot( Phot phot ) throws Exception;

}
