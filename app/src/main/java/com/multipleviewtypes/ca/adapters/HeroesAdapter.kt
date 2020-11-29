package com.multipleviewtypes.ca.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.multipleviewtypes.ca.R
import com.multipleviewtypes.ca.models.*
import com.multipleviewtypes.ca.ui.MainActivity

class HeroesAdapter(list: MutableList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<Item> = list

    class IronManViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPicture: ImageView = itemView.findViewById(R.id.ivIronMan)
        private var tvName: TextView = itemView.findViewById(R.id.tvNameIronMan)
        private var tvDescription: TextView = itemView.findViewById(R.id.tvDescriptionIronMan)

        fun setIronMan(ironMan: Hero){
            ivPicture.setImageResource(ironMan.picture!!)
            tvName.text = ironMan.name
            tvDescription.text = ironMan.description
        }
    }

    class ThorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPicture: ImageView = itemView.findViewById(R.id.ivThor)
        private var tvName: TextView = itemView.findViewById(R.id.tvNameThor)
        private var tvDescription: TextView = itemView.findViewById(R.id.tvDescriptionThor)

        fun setThor(thor: Hero){
            ivPicture.setImageResource(thor.picture!!)
            tvName.text = thor.name
            tvDescription.text = thor.description
        }
    }

    class CaptainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPicture: ImageView = itemView.findViewById(R.id.ivCaptain)
        private var tvName: TextView = itemView.findViewById(R.id.tvNameCaptain)
        private var tvDescription: TextView = itemView.findViewById(R.id.tvDescriptionCaptain)

        fun setCaptain(captain: Hero){
            ivPicture.setImageResource(captain.picture!!)
            tvName.text = captain.name
            tvDescription.text = captain.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            MainActivity.IRON_MAN -> {
                return IronManViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.item_ironman,
                    parent,
                    false)
                )
            }
            MainActivity.THOR -> {
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
        return items[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val hero = items[position].obj

        when {
            getItemViewType(position) == MainActivity.IRON_MAN -> {
                (holder as IronManViewHolder).setIronMan(hero)
            }
            getItemViewType(position) == MainActivity.THOR -> {
                (holder as ThorViewHolder).setThor(hero)
            }
            else -> {
                (holder as CaptainViewHolder).setCaptain(hero)
            }
        }
    }
}