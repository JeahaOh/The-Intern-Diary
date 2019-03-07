package egovframework.rst.service;

import java.util.List;
import egovframework.rst.vo.Rst;

/**
 * @Class Name  : RstService.java
 * @Discription : RstService Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.04 최초생성
 *
 * @author 제하
 * @since 2019. 03.04
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

public interface RstService {
  /**
   * 식당 목록을 가져온다.
   * 
   * @return 식당 목록
   * @throws Exception
   */
  List<Rst> getList() throws Exception;
  
  /**
   * 식당 상세 정보를 가져온다.
   * 
   * @param id  - 식당 id
   * @return  Rst
   * @throws Exception
   */
  Rst getDetail(int id) throws Exception;
  
  /**
   * rst를 등록하기 위한 Service
   * @param   rst - 등록할 rst 갹체 
   * @return  성공 여부
   * @throws  Exception
   */
  int save(Rst rst) throws Exception;
  
  /**
   * rst를 삭제하기 위한 Service
   * @param   rst_no  - 삭제 할 rst의 no
   * @return  성공 여부
   * @throws Exception
   */
  Boolean delete(int rst_no) throws Exception;
}
