package org.ligi.thirdpartylicensedisplay.lib.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.ligi.kaxtui.alert
import org.ligi.thirdpartylicensedisplay.lib.R
import org.ligi.thirdpartylicensedisplay.lib.model.LicenseInfoEntry

class ListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.list, container) as RecyclerView
        val data = readResource("third_party_licenses")
        val metadataText = readResource("third_party_license_metadata")
        if (data == null || metadataText == null) {
            context?.alert("Cannot load license information - did you add the plugin to your build.gradle file?")
        } else {
            Log.i("", metadataText)
            val metaDataList = metadataText.split("\n").filter { it.isNotBlank() }.map {
                it.split(" ").let {
                    val positions = it.first().split(":")
                    LicenseInfoEntry(it[1], positions.first().toInt(), positions.last().toInt())
                }
            }

            inflate.adapter = LicenseInfoAdapter(metaDataList, data)

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
