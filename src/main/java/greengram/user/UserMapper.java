package greengram.user;

import greengram.user.model.UserInsDto;
import greengram.user.model.UserProfileInfoVo;
import greengram.user.model.UserSigninProcVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    UserSigninProcVo selUserByUid(String uid);
    UserProfileInfoVo selUserProfileInfo(int targetIuser);
}
