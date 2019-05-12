package org.ligi.thirdpartylicensedisplay.lib.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okio.Okio
import org.ligi.kaxtui.alert
import org.ligi.thirdpartylicensedisplay.lib.model.LicenseInfo


class LicenseInfoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(org.ligi.thirdpartylicensedisplay.lib.R.layout.list, container) as RecyclerView

        val source = Okio.buffer(Okio.source(context!!.assets.open("open_source_licenses.json")))

        val listMyData = Types.newParameterizedType(List::class.java, LicenseInfo::class.java)
        val adapter : JsonAdapter<List<LicenseInfo>> = Moshi.Builder().build().adapter(listMyData)

        val list = adapter.fromJson(source)

        if (list == null) {
            context?.alert("Cannot load license information (open_source_licenses.json in assets) - you need to generate it with the gradle plugin by jaredsburrows")
        } else {

            inflate.adapter = LicenseInfoAdapter(list)

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
