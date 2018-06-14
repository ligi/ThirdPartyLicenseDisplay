package org.ligi.thirdpartylicensedisplay.lib.ui


import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_license_entry.view.*
import org.ligi.kaxt.startActivityFromURL
import org.ligi.kaxtui.alert
import org.ligi.thirdpartylicensedisplay.lib.R
import org.ligi.thirdpartylicensedisplay.lib.model.LicenseInfo

class LicenceInfoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(entry: LicenseInfo) {
        val nameSplit = entry.name.split(":")
        val context = itemView.context
        itemView.license_text_title.text = nameSplit.last()
        itemView.license_text_detail1.text = nameSplit.first()

        if (entry.info.length < 256) {
            itemView.license_text_detail2.text = entry.info
        } else {
            itemView.license_text_detail2.text = context.getString(R.string.click_for_details)
        }
        itemView.setOnClickListener {


            if (entry.info.startsWith("http")) {
                context.startActivityFromURL(entry.info)
            } else {
                context.alert(entry.info)
            }
        }
    }
}