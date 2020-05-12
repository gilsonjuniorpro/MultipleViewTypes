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
import org.jetbrains.annotations.NotNull

class HeroesAdapter(list: MutableList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<Item> = list

    class IronManViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var ivPicture: ImageView
        private lateinit var tvName: TextView
        private lateinit var tvDescription: TextView

        fun setIronMan(ironMan: IronMan){
            ivPicture = itemView.findViewById(R.id.ivIronMan)
            tvName = itemView.findViewById(R.id.tvNameIronMan)
            tvDescription = itemView.findViewById(R.id.tvDescriptionIronMan)

            ivPicture.setImageResource(ironMan.picture!!)
            tvName.text = ironMan.name
            tvDescription.text = ironMan.description
        }
    }

    class ThorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var ivPicture: ImageView
        private lateinit var tvName: TextView
        private lateinit var tvDescription: TextView

        fun setThor(thor: Thor){
            ivPicture = itemView.findViewById(R.id.ivThor)
            tvName = itemView.findViewById(R.id.tvNameThor)
            tvDescription = itemView.findViewById(R.id.tvDescriptionThor)

            ivPicture.setImageResource(thor.picture!!)
            tvName.text = thor.name
            tvDescription.text = thor.description
        }
    }

    class CaptainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var ivPicture: ImageView
        private lateinit var tvName: TextView
        private lateinit var tvDescription: TextView

        fun setCaptain(captain: Captain){
            ivPicture = itemView.findViewById(R.id.ivCaptain)
            tvName = itemView.findViewById(R.id.tvNameCaptain)
            tvDescription = itemView.findViewById(R.id.tvDescriptionCaptain)

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
                var ironMan = items[position].obj as IronMan
                (holder as IronManViewHolder).setIronMan(ironMan)
            }
            getItemViewType(position) == 1 -> {
                var thor = items[position].obj as Thor
                (holder as ThorViewHolder).setThor(thor)
            }
            else -> {
                var captain = items[position].obj as Captain
                (holder as CaptainViewHolder).setCaptain(captain)
            }
        }
    }
}