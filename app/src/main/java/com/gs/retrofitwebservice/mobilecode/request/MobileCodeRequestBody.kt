package com.gs.retrofitwebservice.mobilecode.request

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "soap:Body", strict = false)
class MobileCodeRequestBody {
    @Element(name = "getMobileCodeInfo", required = false)
    var mobileCodeRequestData: MobileCodeRequestData? = null
}