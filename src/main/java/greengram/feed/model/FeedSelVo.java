package greengram.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private int isFav;
    private int iuser;
    private String writer;
    private String createdAt;
    private List<String> pics= new ArrayList();
}
