package greengram.feed;

import greengram.ResVo;
import greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo insFeed(FeedInsDto dto) {
        FeedInsProcDto pDto= new FeedInsProcDto(dto);
        mapper.insFeed(pDto);
        FeedPicsInsProcDto p2Dto= new FeedPicsInsProcDto(pDto.getIfeed(), dto.getPics());
        mapper.insFeedPic(p2Dto);
        return new ResVo(pDto.getIfeed());
    }
    public List<FeedSelVo> getFeed(int page, int loginedIuser, int targetIuser) {
        final int ROW_COUNT= 30;
        FeedSelDto dto= FeedSelDto.builder().
                startIdx((page-1)*ROW_COUNT).rowCount(ROW_COUNT).
                loginedIuser(loginedIuser).targetIuser(targetIuser).build();
        List<FeedSelVo> feedSelVoList= mapper.selFeed(dto);
        List<Integer> ifeedList= new ArrayList();
        Map<Integer, FeedSelVo> feedMap= new HashMap();
        for(FeedSelVo vo: feedSelVoList) {
            ifeedList.add(vo.getIfeed());
            feedMap.put(vo.getIfeed(), vo);
        }
        List<FeedPicsVo> feedPicsList= mapper.selFeedPics(ifeedList);
        for(FeedPicsVo vo: feedPicsList) {
            FeedSelVo feedVo= feedMap.get(vo.getIfeed());
            List<String> strPicsList = feedVo.getPics();
            strPicsList.add(vo.getPic());
        }
        return feedSelVoList;
    }
    public ResVo procFav(FeedFavProcDto dto) {
        int result= mapper.delFeedFav(dto);
        if(result==0) {return new ResVo(mapper.insFeedFav(dto));}
        return new ResVo(2);
    }

}
