package org.ligi.thirdpartylicensedisplay.lib

import org.ligi.thirdpartylicensedisplay.lib.model.LicenseInfoEntry

fun String.parseLicenseInfo()  = split("\n").filter { it.isNotBlank() }.map {
    it.split(" ").let {
        val positions = it.first().split(":")
        LicenseInfoEntry(it[1], positions.first().toInt(), positions.last().toInt())
    }
}