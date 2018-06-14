package org.ligi.thirdpartylicensedisplay.lib.ui


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.ligi.thirdpartylicensedisplay.lib.LicenseInfoRepository
import org.ligi.thirdpartylicensedisplay.lib.R

class LicenseInfoAdapter(private val repo: LicenseInfoRepository) : RecyclerView.Adapter<LicenceInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            LicenceInfoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_license_entry, parent, false))

    override fun getItemCount() = repo.size()

    override fun onBindViewHolder(holder: LicenceInfoViewHolder, position: Int) {
        holder.bind(repo.getInfoAt(position))
    }
}