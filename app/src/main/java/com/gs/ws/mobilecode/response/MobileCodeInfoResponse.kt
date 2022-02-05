package com.gs.ws.mobilecode.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "getMobileCodeInfoResponse", strict = false)
class MobileCodeInfoResponse {
    @field:Element(name = "getMobileCodeInfoResult", required = false)
    var mobileCodeInfoResult: String? = null
}