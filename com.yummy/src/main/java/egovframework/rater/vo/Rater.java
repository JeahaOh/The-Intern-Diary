package egovframework.rater.vo;

public class Rater {
  //  해당 식당에 대한 리뷰의 수와 평점의 합
  int cnt;
  int sum;
  float avg;
  
  float grade;
  
  //  강추, 맛집, 무난, 별로, 최악
  int best;
  int good;
  int soso;
  int bad;
  int worst;
  
  public Rater( ) {  }

  public Rater(int cnt, int sum, float avg, float grade, int best, int good, int soso, int bad, int worst) {
    super();
    this.cnt = cnt;
    this.sum = sum;
    this.grade = grade;
    this.best = best;
    this.good = good;
    this.soso = soso;
    this.bad = bad;
    this.worst = worst;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public float getGrade() {
    if ( cnt == 0 ) {
      grade = (float) 0.00;
      return grade;
    }
    //( 15 + A에 대한 총점 합계 ) / ( 5 + A에 대한 총 리뷰 수 )
    this.grade = ( ( 5 * 3 ) + ( avg * cnt ) ) / (float) ( 5 + cnt );
    //  소수점 2째 자리까지 짜르기 
    int temp = (int) ( grade * 100 );
    this.grade = (float) (temp / 100.0);
    System.out.println(this.grade);
    return grade;
  }

  public int getBest() {
    return best;
  }

  public void setBest(int best) {
    this.best = best;
  }

  public int getGood() {
    return good;
  }

  public void setGood(int good) {
    this.good = good;
  }

  public int getSoso() {
    return soso;
  }

  public void setSoso(int soso) {
    this.soso = soso;
  }

  public int getBad() {
    return bad;
  }

  public void setBad(int bad) {
    this.bad = bad;
  }

  public int getWorst() {
    return worst;
  }

  public void setWorst(int worst) {
    this.worst = worst;
  }

  public float getAvg() {
    return avg;
  }
  
  public void setAvg(float avg) {
    this.avg = avg;
  }
  
  @Override
  public String toString() {
    return "\n Rater [cnt=" + cnt + ", sum=" + sum + ", avg=" + avg + ", grade=" + grade + ", best="
        + best + ", good=" + good + ", soso=" + soso + ", bad=" + bad + ", worst=" + worst + "]";
  }
  
  
}
