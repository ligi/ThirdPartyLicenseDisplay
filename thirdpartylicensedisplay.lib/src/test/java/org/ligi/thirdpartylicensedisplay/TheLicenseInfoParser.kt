package org.ligi.thirdpartylicensedisplay

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.ligi.thirdpartylicensedisplay.lib.parseLicenseInfo

class TheLicenseInfoParser {
    @Test
    fun canParse() {
        val list = testMetaData.parseLicenseInfo()
        assertThat(list.first().position).isEqualTo(0)
        assertThat(list.first().length).isEqualTo(46)
        assertThat(list.first().name).isEqualTo("org.jetbrains.kotlin:kotlin-annotation-processing-gradle")

        assertThat(list.last().position).isEqualTo(2239)
        assertThat(list.last().length).isEqualTo(102)
        assertThat(list.last().name).isEqualTo("javax.xml.bind:jaxb-api")
    }
}