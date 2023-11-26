package greengram.feed;

import greengram.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    void insFeed(FeedInsProcDto dto);
    void insFeedPic(FeedPicsInsProcDto dto);
    List<FeedSelVo> selFeed(FeedSelDto dto);
    List<FeedPicsVo> selFeedPics(List<Integer> ifeedList);
    int delFeedFav(FeedFavProcDto dto);
    int insFeedFav(FeedFavProcDto dto);
}
