package my.mvppokemon.features.details

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import my.mvppokemon.PokemonApp
import my.mvppokemon.R
import my.mvppokemon.databinding.FragmentDetailsBinding
import my.mvppokemon.navigation.INavigationUpListener
import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.models.PokemonInfo

class DetailsFragment :
    MvpAppCompatFragment(R.layout.fragment_details), DetailsView, INavigationUpListener {
    private val presenter by moxyPresenter {
        DetailsPresenter(
            arguments?.getParcelable(DETAILS_TAG)!!
        ).apply {
            PokemonApp.INSTANCE.appComponent.inject(this)
        }
    }

    private var binding: FragmentDetailsBinding? = null
    private val b get() = binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
    }

    override fun showData(data: PokemonInfo) {
        b.tvName.text = data.name
        b.tvNumber.text = data.getNumberString()
        b.tvSpecies.text = data.species
        b.tvHeight.text = data.getHeightString()
        b.tvWeight.text = data.getWeightString()

        Glide.with(b.ivImage)
            .load(data.getImageUrl())
            .error(R.drawable.default_image)
            .into(b.ivImage)

        b.progressHp.progress = data.hp
        b.progressAttack.progress = data.attack
        b.progressDefense.progress = data.defense
        b.progressSpeed.progress = data.speed

        for (type in data.types) {
            val chip = layoutInflater.inflate(R.layout.item_chip_type, null, false) as Chip
            b.chips.addView(chip.apply { text = type })
        }
    }

    override fun backPressed() = presenter.backClicked()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val DETAILS_TAG = "my.mvppokemon.features.details"

        fun newInstance(data: Pokemon): DetailsFragment {
            val args = Bundle()
            args.putParcelable(DETAILS_TAG, data)
            return DetailsFragment().apply { arguments = args }
        }
    }
}