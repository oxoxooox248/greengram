package greengram.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileInfoVo {
    private String nm;
    private String createdAt;
    private int feedCnt;
    private int favCnt;
}
