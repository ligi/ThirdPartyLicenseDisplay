package org.ligi.thirdpartylicensedisplay

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.ligi.thirdpartylicensedisplay.lib.LicenseInfoRepository

class TheRepository {
    @Test
    fun canParse() {
        val repo = LicenseInfoRepository(TEST_METADATA, TEST_DATA)
        assertThat(repo.getInfoAt(0).name)
                .isEqualTo("org.jetbrains.kotlin:kotlin-annotation-processing-gradle")

        assertThat(repo.getInfoAt(0).info)
                .isEqualTo("http://www.apache.org/licenses/LICENSE-2.0.txt")

        assertThat(repo.getInfoAt(1).name)
                .isEqualTo("org.jetbrains.kotlin:kotlin-compiler-embeddable")

        assertThat(repo.getInfoAt(1).info)
                .isEqualTo("http://www.apache.org/licenses/LICENSE-2.0.txt")

        assertThat(repo.getInfoAt(repo.size() - 1).name)
                .isEqualTo("org.jvnet.staxex:stax-ex")

        assertThat(repo.getInfoAt(repo.size() - 1).info)
                .isEqualTo("https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html")

    }
}