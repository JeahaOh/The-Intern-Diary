package com.example.app.rst;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rater {
    //  해당 식당에 대한 리뷰의 수와 평점의 합
    @Expose
    @SerializedName("cnt")
    int cnt;
    @Expose
    @SerializedName("sum")
    int sum;
    @Expose
    @SerializedName("avg")
    float avg;
    @Expose
    @SerializedName("grade")
    float grade;

    //  강추, 맛집, 무난, 별로, 최악
    @Expose
    @SerializedName("best")
    int best;
    @Expose
    @SerializedName("good")
    int good;
    @Expose
    @SerializedName("soso")
    int soso;
    @Expose
    @SerializedName("bad")
    int bad;
    @Expose
    @SerializedName("worst")
    int worst;
    @Expose
    @SerializedName("wannago")
    int wannago;

    public int getCnt() {
        return cnt;
    }

    public int getSum() {
        return sum;
    }

    public float getAvg() {
        return avg;
    }

    public float getGrade() {
        return grade;
    }

    public int getBest() {
        return best;
    }

    public int getGood() {
        return good;
    }

    public int getSoso() {
        return soso;
    }

    public int getBad() {
        return bad;
    }

    public int getWorst() {
        return worst;
    }

    public int getWannago() {
        return wannago;
    }

    @Override
    public String toString() {
        return "Rater{" +
                "cnt=" + cnt +
                ", sum=" + sum +
                ", avg=" + avg +
                ", grade=" + grade +
                ", best=" + best +
                ", good=" + good +
                ", soso=" + soso +
                ", bad=" + bad +
                ", worst=" + worst +
                ", wannago=" + wannago +
                '}';
    }
}
