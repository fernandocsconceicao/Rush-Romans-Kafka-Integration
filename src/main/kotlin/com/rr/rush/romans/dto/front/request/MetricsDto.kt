package com.ti89.dto.front.request

import com.google.gson.Gson

data class MetricsDto(val damageDone:Double){
    override fun toString(): String {
        return "damageDone=${damageDone}"
    }

}
