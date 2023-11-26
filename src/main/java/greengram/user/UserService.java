package greengram.user;

import greengram.ResVo;
import greengram.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo insUser(UserInsDto dto) {
        return new ResVo(mapper.insUser(dto));
    }
    public UserSigninVo signin(UserSigninDto dto) {
        UserSigninVo vo= new UserSigninVo();
        vo.setResult(3);
        UserSigninProcVo pVo= mapper.selUserByUid(dto.getUid());
        if(pVo==null) {vo.setResult(2);}
        else if(dto.getUpw().equals(pVo.getUpw())) {
            vo.setResult(1);
            vo.setIuser(pVo.getIuser());
            vo.setNm(pVo.getNm());
            vo.setPic(pVo.getPic());
        }
        return vo;
    }
    public UserProfileInfoVo getUserProfileInfo(int targetIuser) {
        return mapper.selUserProfileInfo(targetIuser);
    }
}
