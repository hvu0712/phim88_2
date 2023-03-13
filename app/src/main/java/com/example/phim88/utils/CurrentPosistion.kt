package com.example.phim88.utils

import androidx.annotation.IntDef

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
@IntDef(
    CurrentPosistion.TRAILER,
    CurrentPosistion.CASTING,
    CurrentPosistion.PRODUCER
)
annotation class CurrentPosistion {
    companion object {
        const val TRAILER = 0
        const val CASTING = 1
        const val PRODUCER = 2
    }
}