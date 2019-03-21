package egovframework.phot.dao;

import egovframework.phot.vo.Phot;
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
  
  /**
   * phot 테이블에 식당 사진을 저장하는 method
   * @param phot
   * @return
   * @throws Exception
   */
  Boolean savePhot( Phot phot ) throws Exception;
  
  /**
   * rst_no에 대한 phot의 유무를 반환하는 method
   * @param rst_no
   * @return
   * @throws Exception
   */
  String getRstPhot(int rst_no) throws Exception;
  
  /**
   * rst_no에 대한 phot를 삭제하는 method
   * @param rst_no
   * @return
   * @throws Exception
   */
  Boolean deleteRstPhot(int rst_no) throws Exception;

}
