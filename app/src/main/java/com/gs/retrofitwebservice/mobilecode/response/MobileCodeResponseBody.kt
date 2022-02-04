package com.gs.retrofitwebservice.mobilecode.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Body")
class MobileCodeResponseBody {
    @Element(name = "getMobileCodeInfoResponse", required = false)
    var mobileCodeResponseInfo: MobileCodeResponseInfo? = null
}