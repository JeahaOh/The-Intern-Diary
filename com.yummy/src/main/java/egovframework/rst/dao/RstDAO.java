package egovframework.rst.dao;

import java.util.List;
import egovframework.dflt.DefaultVO;
import egovframework.rst.vo.Rst;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * Rst에 대한 데이터 처리 mapper 클래스
 * 
 * @Class Name  : RstDAO.java
 * @Discription : RstDAO Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.04 최초생성
 *
 * @author 제하
 * @since 2019. 03.04
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Mapper("rstDao")
public interface RstDAO {
  
  /**
   * Rst의 리스트를 반환
   * 
   * @return Rst의 List
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
  Boolean save(Rst rst) throws Exception;
  
  /**
   * rst_no의 마지막 값을 가져온다.
   * @return  rst_no
   * @throws Exception
   */
  int getLastRstNo() throws Exception;
  
  /**
   * rst를 삭제하기 위한 Service
   * @param   rst_no  - 삭제 할 rst의 no
   * @return  성공 여부
   * @throws Exception
   */
  Boolean delete(int rst_no) throws Exception;
  
  /**
   * rst의 총 갯수를 조회한다.
   * @param rst  - 조회할 정보가 담긴 VO
   * @return 글의 총 갯수
   */
  int getTotCnt(DefaultVO searchVO);
}
