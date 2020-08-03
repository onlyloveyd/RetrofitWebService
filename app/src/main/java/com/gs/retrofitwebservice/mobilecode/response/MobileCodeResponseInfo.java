package com.gs.retrofitwebservice.mobilecode.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: MobileCodeResponseInfo
 * 创 建 人: 易冬
 * 创建日期: 2018/1/24 09:57
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "getMobileCodeInfoResponse",strict = false)
public class MobileCodeResponseInfo {

    public String getMobileCodeResult() {
        return MobileCodeResult;
    }

    public void setMobileCodeResult(String mobileCodeResult) {
        MobileCodeResult = mobileCodeResult;
    }

    @Element(name = "getMobileCodeInfoResult", required = false)
    private String MobileCodeResult;
}
