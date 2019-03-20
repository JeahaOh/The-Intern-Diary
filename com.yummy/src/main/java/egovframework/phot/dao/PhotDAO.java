package egovframework.phot.dao;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name  : PhotDAO.java
 * @Discription : PhotDAO Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.20 최초생성
 *
 * @author 제하
 * @since 2019. 03.20
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Mapper("photDao")
public interface PhotDAO {
  
  /**
   * phot_no의 유무 확인
   * @param phot_no
   * @return
   * @throws Exception
   */
  Boolean getPhotNo(String phot_no) throws Exception;

}
