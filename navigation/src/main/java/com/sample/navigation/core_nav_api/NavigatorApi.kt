package com.sample.navigation.core_nav_api

import com.sample.injector.BaseAPI
import com.sample.navigation.core_nav_impl.Navigator

interface NavigatorApi: BaseAPI {
    fun navigator(): Navigator
}