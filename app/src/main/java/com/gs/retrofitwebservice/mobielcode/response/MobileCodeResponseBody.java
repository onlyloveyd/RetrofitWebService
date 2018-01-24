package com.gs.retrofitwebservice.mobielcode.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: MobileCodeResponseBody
 * 创 建 人: 易冬
 * 创建日期: 2018/1/24 09:55
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "Body")
public class MobileCodeResponseBody {
    public MobileCodeResponseInfo getMobileCodeResponseInfo() {
        return mMobileCodeResponseInfo;
    }

    public void setMobileCodeResponseInfo(
            MobileCodeResponseInfo mobileCodeResponseInfo) {
        mMobileCodeResponseInfo = mobileCodeResponseInfo;
    }

    @Element(name = "getMobileCodeInfoResponse", required = false)
    private MobileCodeResponseInfo mMobileCodeResponseInfo;
}
