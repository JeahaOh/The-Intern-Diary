package egovframework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * DB에 들어갈 인자들으 ㅣ정규 표현식 확인을 위한 클래스.
 * 
 * @Class Name  : PatternTest.java
 * @Discription : Pattern Test Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.04 최초생성
 *
 * @author 제하
 * @since 2019. 03.04
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

@Component("patternTest")
public class PatternTest {

  public Boolean idTest(String param) {
    Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
    Matcher m = p.matcher(param);
    return m.find();
  }
  
  public Boolean pwdTest(String id, String pwd) {
     
    String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$";
    Matcher matcher = Pattern.compile(pwPattern).matcher(pwd);
     
    pwPattern = "(.)\\1\\1\\1";
    Matcher matcher2 = Pattern.compile(pwPattern).matcher(pwd);
     
/*    if(!matcher.matches()){
        
    }
     
    if(matcher2.find()){
        
    }
     
    if(pwd.contains(id)){
        
    }
     
    if(pwd.contains(" ")){
        
    }*/
    
    if( !matcher.matches() && matcher2.find() && pwd.contains(id) && pwd.contains(" ") ){
      return true;
    }
    
    return false;
  }

}
