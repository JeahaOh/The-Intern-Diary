package egovframework.memb.DAO;

import org.apache.ibatis.annotations.Param;
import egovframework.memb.vo.Memb;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * memb에 대한 데이터 처리 mapper 클래스
 * 
 * @Class Name  : MembDAO.java
 * @Discription : MembDAO Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.04 최초생성
 *
 * @author 제하
 * @since 2019. 03.04
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Mapper("membDao")
public interface MembDAO {
  /**
   * 관리자 로그인을 한다.
   * 
   * @param id  - memb의 ID
   * @param pwd - memb의 PWD
   * @return 로그인한 memb
   * @throws Exception
   */
  Memb adminLogin(@Param("id") String id, @Param("pwd")String pwd) throws Exception;
}
