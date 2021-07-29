package my.mvppokemon.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import my.mvppokemon.R
import my.mvppokemon.databinding.ItemPokemonCardBinding
import my.mvppokemon.repository.models.Pokemon

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var pokemonList: List<Pokemon> = emptyList()

    fun setItems(data: List<Pokemon>) {
        pokemonList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(pokemonList[position])

    override fun getItemCount() = pokemonList.size

    inner class ViewHolder(private val vb: ItemPokemonCardBinding) : RecyclerView.ViewHolder(vb.root) {

        fun bind(entity: Pokemon) {
            vb.apply {
                tvName.text = entity.name
                Glide.with(ivPokemon)
                    .load(entity.getImageUrl())
                    .error(R.drawable.default_image)
                    .into(ivPokemon)
            }
        }
    }
}