package org.ligi.thirdpartylicensedisplay.lib.model

data class LicenseInfo(
        val project: String,
        val description: String,
        val version: String,
        val developers: List<String>,
        val url: String?,
        val year: String?,
        val licenses: List<License>
)