package nyc.c4q.dereksantos.exam_1_11.backend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KeyboardResponse {

    @SerializedName("available keys")
    List<Letter> letterList;

    public List<Letter> getLetterList() {
        return letterList;
    }

    public void setLetterList(List<Letter> letterList) {
        this.letterList = letterList;
    }
}
