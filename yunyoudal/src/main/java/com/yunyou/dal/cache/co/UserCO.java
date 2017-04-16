package com.yunyou.dal.cache.co;

import java.io.Serializable;

/**
 * Created by lds on 2017/4/13.
 */
public class UserCO  implements Serializable {
    private static final long serialVersionUID = -1593694198393075745L;
    private String username;
    private String userPic;
    private Integer infoNum;

    public UserCO(String username, String userPic, Integer infoNum) {
        this.username = username;
        this.userPic = userPic;
        this.infoNum = infoNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public Integer getInfoNum() {
        return infoNum;
    }

    public void setInfoNum(Integer infoNum) {
        this.infoNum = infoNum;
    }
}
