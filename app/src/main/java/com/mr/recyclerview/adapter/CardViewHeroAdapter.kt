package com.mr.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mr.recyclerview.R
import com.mr.recyclerview.model.Hero
import org.jetbrains.anko.toast


class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvHeroesName: TextView = itemView.findViewById(R.id.tvItemName)
        var tvHeroesDetail: TextView = itemView.findViewById(R.id.tvItemDetail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.imgItemPhoto)
        var btnFavorite: Button = itemView.findViewById(R.id.btnSetFavorite)
        var btnShare: Button = itemView.findViewById(R.id.btnSetShare)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)

        holder.tvHeroesName.text = hero.name
        holder.tvHeroesDetail.text = hero.detail
        holder.btnFavorite.setOnClickListener{}
    }

}