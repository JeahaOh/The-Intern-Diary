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

  public Boolean test(String param) {
    Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
    Matcher m = p.matcher(param);
    return m.find();
  }

}
