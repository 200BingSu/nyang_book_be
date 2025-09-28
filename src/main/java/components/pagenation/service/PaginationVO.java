package components.pagenation.service;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaginationVO {
    private int page;
    private int numOfPage;

    /**
     * limit: 한 번에 가져올 데이터 개수
     */
    public int getLimit() {
        return numOfPage;
    }

    /**
     * offset: SQL에서 데이터 시작 위치
     * 1페이지 기준으로 계산
     */
    public int getOffset() {
        return (page - 1) * numOfPage;
    }
}
