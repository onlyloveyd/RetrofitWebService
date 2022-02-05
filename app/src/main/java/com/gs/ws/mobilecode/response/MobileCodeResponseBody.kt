package com.gs.ws.mobilecode.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Body")
class MobileCodeResponseBody {
    @field:Element(name = "getMobileCodeInfoResponse", required = false)
    var response: MobileCodeInfoResponse? = null
}