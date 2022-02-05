package com.gs.ws.mobilecode.request

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "soapenv:Body")
class MobileCodeRequestBody {
    @field:Element(name = "web:getMobileCodeInfo", required = true)
    var mobileCodeRequestData: MobileCodeRequestData? = null
}