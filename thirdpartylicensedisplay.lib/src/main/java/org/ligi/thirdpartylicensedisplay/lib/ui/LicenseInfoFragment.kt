package org.ligi.thirdpartylicensedisplay.lib.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.ligi.kaxtui.alert
import org.ligi.thirdpartylicensedisplay.lib.LicenseInfoRepository
import org.ligi.thirdpartylicensedisplay.lib.R

class LicenseInfoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.list, container) as RecyclerView
        val data = readResource("third_party_licenses")
        val metadataText = readResource("third_party_license_metadata")
        if (data == null || metadataText == null) {
            context?.alert("Cannot load license information - did you add the plugin to your build.gradle file?")
        } else {
            inflate.adapter = LicenseInfoAdapter(LicenseInfoRepository(metadataText, data))

            inflate.layoutManager = LinearLayoutManager(context)
        }

        return inflate
    }


    private fun readResource(name: String) = try {
        resources.openRawResource(getIdentifier(name)).reader().readText()
    } catch (e: Exception) {
        null
    }

    private fun getIdentifier(name: String) = resources.getIdentifier(name, "raw", context?.packageName)

}
