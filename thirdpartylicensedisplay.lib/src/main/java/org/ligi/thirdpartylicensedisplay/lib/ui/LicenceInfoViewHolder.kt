package org.ligi.thirdpartylicensedisplay.lib.ui


import android.support.v4.text.HtmlCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_license_entry.view.*
import org.ligi.thirdpartylicensedisplay.lib.model.LicenseInfo

class LicenceInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(entry: LicenseInfo) {
        itemView.license_text_title.text = entry.project + " " + entry.version
        itemView.license_text_detail.text = entry.description


        itemView.license_text_license.text = HtmlCompat.fromHtml(entry.licenses.joinToString("<br/>") { it.license }, FROM_HTML_MODE_LEGACY)

        itemView.setOnClickListener {
            var text = "<b>" + entry.project + "</b><br/><br/>" + entry.description + "<br/><br/>"


            entry.url?.let {
                text += "URL: <a href='$it'>$it</a><br/>"
            }

            text += "Version: " + entry.version + "<br/>"

            entry.year?.let {
                text += "Year: $it<br/>"
            }

            entry.licenses.forEach {
                text += "<a href='${it.license_url}'>${it.license}</a><br/>"
            }
            val dialog = AlertDialog.Builder(itemView.context)
                    .setTitle("Details")
                    .setMessage(Html.fromHtml(text))
                    .setPositiveButton(android.R.string.ok, null)
                    .create()

            dialog.show()
            val textView: TextView? = dialog.findViewById(android.R.id.message)
            textView?.movementMethod = LinkMovementMethod()
        }
    }
}