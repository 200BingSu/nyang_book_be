package components.util.service;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ResponseDTO<T> {
    private boolean success;
    private String message;

    private T dataMap;       // 단건 응답
    private List<T> dataList; // 목록 응답

    public ResponseDTO() {}

    // 메시지 + Map 데이터용
    public ResponseDTO(String message, T dataMap) {
        this.success = true;
        this.message = message;
        this.dataMap = dataMap;
    }

    //  메시지 + List 데이터용
    public ResponseDTO(String message, List<T> dataList) {
        this.success = true;
        this.message = message;
        this.dataList = dataList;
    }

    // 성공 여부와 메시지만
    public ResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
