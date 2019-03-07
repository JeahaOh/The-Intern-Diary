package egovframework.memb.service;

import egovframework.memb.vo.Memb;

/**
 * @Class Name  : MemvService.java
 * @Discription : MembService Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.03 최초생성
 *
 * @author 제하
 * @since 2019. 03.03
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

public interface MembService {
  
  /**
   * 관리자 로그인을 한다.
   * 
   * @param id  - 회원의 id
   * @param pwd - 회원의 pwd
   * @return  로그인 한 회원
   * @throws Exception
   */
  Memb adminLogin(String id, String pwd) throws Exception;
  
  /**
   * 일반 회원 로그인을 한다.
   * 
   * @param id  - 회원의 id
   * @param pwd - 회원의 pwd
   * @return  로그인 한 회원
   * @throws Exception
   */
  Memb login(String id, String pwd) throws Exception;
  
  /**
   * id값이 있는지 확인 한다.
   * 
   * @param id  - 확인 할 id 값
   * @return id의 존재 여부
   * @throws Exception
   */
  String idCheck(String id) throws Exception;
  
  /**
   * 일반 회원의 회원 가입을 한다.
   * 
   * @param id  - memb의 ID
   * @param pwd - memb의 PWD
   * @param nick- memb의 nick
   * @return  회원 가입 성공 여부
   * @throws Exception
   */
  Boolean signUp(String id, String pwd, String nick) throws Exception;
  
  /**
   * 회원 탈퇴를 기능.
   * @param id  - 탈퇴할 회원의 id
   * @throws Exception
   */
  void signOut(String id) throws Exception;
}
