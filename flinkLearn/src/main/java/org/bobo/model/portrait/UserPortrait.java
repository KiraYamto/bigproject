package org.bobo.model.portrait;

import org.bobo.model.tencent.event.common.WxUser;
import org.bobo.model.tencent.order.GoodsInfo;
import org.bobo.model.tencent.order.UserInfo;

import java.io.Serializable;
import java.util.List;

public class UserPortrait implements Serializable {

    private WxUser user_info;
    private float totalCost;
    private int totolOrder;
    private float totalPoints;
    private List<GoodsInfo> goods_info;


}
