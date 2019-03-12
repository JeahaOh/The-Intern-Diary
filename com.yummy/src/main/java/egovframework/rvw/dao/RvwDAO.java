package egovframework.rvw.dao;

import java.util.List;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rvw.vo.Rvw;

/**
 * @Class Name  : RvwDAO.java
 * @Discription : RvwDAO Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.07 최초생성
 *
 * @author 제하
 * @since 2019. 03.07
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Mapper("rvwDao")
public interface RvwDAO {
  /**
   * rst_no에 대한 rvw List 반환
   * @param rst_no
   * @return
   * @throws Exception
   */
  List<Rvw> getRvwList(int rst_no) throws Exception;
  
  /**
   * rvw_no에 대한 rvw 반환
   * @param rvw_no
   * @return
   * @throws Exception
   */
  Rvw getRvwDtl(int rvw_no) throws Exception;
  
  /**
   * rvw를 저장
   * @param rvw
   * @return
   * @throws Exception
   */
  Boolean save(Rvw rvw) throws Exception;
  
  /**
   * rvw 수정
   * @param rvw
   * @return
   * @throws Exception
   */
  Boolean update(Rvw rvw) throws Exception;
  
  /**
   * rvw 삭제
   * @param rvw_no
   * @return
   * @throws Exception
   */
  Boolean delete(int rvw_no) throws Exception;
}
