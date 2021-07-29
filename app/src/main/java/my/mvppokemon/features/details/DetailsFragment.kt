package my.mvppokemon.features.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import my.mvppokemon.R
import my.mvppokemon.databinding.FragmentDetailsBinding
import my.mvppokemon.storage.PokemonInfo
import my.mvppokemon.storage.getInfo

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var binding: FragmentDetailsBinding? = null
    private val b get() = binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        val info: PokemonInfo? = arguments?.let { it.getParcelable(DETAILS_TAG) }

        info?.let { pokemon ->
            b.tvName.text = pokemon.name
            b.tvNumber.text = pokemon.getNumberString()
            b.tvSpecies.text = pokemon.species
            b.tvHeight.text = pokemon.getHeightString()
            b.tvWeight.text = pokemon.getWeightString()

            Glide.with(b.ivImage)
                .load(pokemon.getImageUrl())
                .error(R.drawable.default_image)
                .into(b.ivImage)

            b.progressHp.progress = pokemon.hp
            b.progressAttack.progress = pokemon.attack
            b.progressDefense.progress = pokemon.defense
            b.progressSpeed.progress = pokemon.speed

            for(type in pokemon.types) {
                val chip = layoutInflater.inflate(R.layout.item_chip_type, null, false) as Chip
                b.chips.addView(chip.apply{text = type})
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val DETAILS_TAG = "my.mvppokemon.features.details"

        fun newInstance(info: PokemonInfo = getInfo()): DetailsFragment {
            val args = Bundle()
            args.putParcelable(DETAILS_TAG, info)
            return DetailsFragment().apply { arguments = args}
        }
    }
}