package com.gs.ws.mobilecode.request

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "getMobileCodeInfo")
class MobileCodeRequestData {
    @field:Element(name = "web:mobileCode", required = true)
    var mobileCode: String? = null

    @field:Element(name = "web:userID", required = true)
    var userId: String = ""
}