package egovframework.util;

import org.springframework.stereotype.Component;

@Component("rater")
public class Rater {
  
  int cnt;
  int sum;
  
  float grade;
  
  //  강추, 맛집, 무난, 별로, 최악
  int best;
  int good;
  int soso;
  int bad;
  int worst;
  
  
}
