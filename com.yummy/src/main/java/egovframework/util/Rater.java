package egovframework.util;

import org.springframework.stereotype.Component;

@Component("rater")
public class Rater {
  
  //  총 평가 수
  int tot;
  //  별로예요
  int bad;
  //  그저 그래요
  int soso;
  //  좋아요
  int good;
  //  
  float avg;
  
}
