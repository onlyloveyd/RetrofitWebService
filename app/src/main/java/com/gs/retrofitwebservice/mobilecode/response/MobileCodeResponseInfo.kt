package com.gs.retrofitwebservice.mobilecode.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "getMobileCodeInfoResponse", strict = false)
class MobileCodeResponseInfo {
    @Element(name = "getMobileCodeInfoResult", required = false)
    var mobileCodeResult: String? = null
}