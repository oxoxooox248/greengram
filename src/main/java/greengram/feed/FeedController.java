package greengram.feed;

import greengram.ResVo;
import greengram.feed.model.FeedFavProcDto;
import greengram.feed.model.FeedInsDto;
import greengram.feed.model.FeedSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResVo insFeed(@RequestBody FeedInsDto dto) {
        return service.insFeed(dto);
    }
    @GetMapping
    public List<FeedSelVo> getFeed(int page, int iuser) {
        return service.getFeed(page, iuser, 0);
    }
    @GetMapping("/{targetIuser}")
    public List<FeedSelVo> getProfileFeed(@PathVariable int targetIuser, int page, int loginedIuser) {
        return service.getFeed(page, loginedIuser, targetIuser);
    }
    @GetMapping("/{ifeed}/fav")
    public ResVo procFav(@PathVariable int ifeed, int iuser) {
        FeedFavProcDto dto= FeedFavProcDto.builder().
                ifeed(ifeed).iuser(iuser).
                build();
        return service.procFav(dto);
    }
}
