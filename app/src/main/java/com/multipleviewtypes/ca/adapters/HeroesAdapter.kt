package com.multipleviewtypes.ca.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.multipleviewtypes.ca.R
import com.multipleviewtypes.ca.models.Captain
import com.multipleviewtypes.ca.models.IronMan
import com.multipleviewtypes.ca.models.Item
import com.multipleviewtypes.ca.models.Thor

class HeroesAdapter(list: MutableList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<Item> = list

    class IronManViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPicture: ImageView = itemView.findViewById(R.id.ivIronMan)
        private var tvName: TextView = itemView.findViewById(R.id.tvNameIronMan)
        private var tvDescription: TextView = itemView.findViewById(R.id.tvDescriptionIronMan)

        fun setIronMan(ironMan: IronMan){
            ivPicture.setImageResource(ironMan.picture!!)
            tvName.text = ironMan.name
            tvDescription.text = ironMan.description
        }
    }

    class ThorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPicture: ImageView = itemView.findViewById(R.id.ivThor)
        private var tvName: TextView = itemView.findViewById(R.id.tvNameThor)
        private var tvDescription: TextView = itemView.findViewById(R.id.tvDescriptionThor)

        fun setThor(thor: Thor){
            ivPicture.setImageResource(thor.picture!!)
            tvName.text = thor.name
            tvDescription.text = thor.description
        }
    }

    class CaptainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPicture: ImageView = itemView.findViewById(R.id.ivCaptain)
        private var tvName: TextView = itemView.findViewById(R.id.tvNameCaptain)
        private var tvDescription: TextView = itemView.findViewById(R.id.tvDescriptionCaptain)

        fun setCaptain(captain: Captain){
            ivPicture.setImageResource(captain.picture!!)
            tvName.text = captain.name
            tvDescription.text = captain.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                return IronManViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.item_ironman,
                    parent,
                    false)
                )
            }
            1 -> {
                return ThorViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.item_thor,
                    parent,
                    false)
                )
            }
            else -> {
                return CaptainViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.item_captain,
                    parent,
                    false)
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            getItemViewType(position) == 0 -> {
                val ironMan = items[position].obj as IronMan
                (holder as IronManViewHolder).setIronMan(ironMan)
            }
            getItemViewType(position) == 1 -> {
                val thor = items[position].obj as Thor
                (holder as ThorViewHolder).setThor(thor)
            }
            else -> {
                val captain = items[position].obj as Captain
                (holder as CaptainViewHolder).setCaptain(captain)
            }
        }
    }
}