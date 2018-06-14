package org.ligi.thirdpartylicensedisplay.lib

import org.ligi.thirdpartylicensedisplay.lib.model.LicenseInfo
import org.ligi.thirdpartylicensedisplay.lib.model.LicenseInfoMeta

class LicenseInfoRepository(private val metaData: String, private val data: String) {


    private val licenseMetaDataList by lazy {
        metaData.split("\n").filter { it.isNotBlank() }.map {
            it.split(" ").let {
                val positions = it.first().split(":")
                LicenseInfoMeta(it[1], positions.first().toInt(), positions.last().toInt())
            }
        }
    }
    private val dataArray = Array<LicenseInfo?>(licenseMetaDataList.size) { null }

    fun size() = licenseMetaDataList.size

    fun getInfoAt(index: Int) = dataArray[index] ?: licenseMetaDataList[index].let {
        LicenseInfo(it.name, data.substring(it.position, it.position + it.length))
    }.also { dataArray[index] = it }

}