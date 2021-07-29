package my.mvppokemon.features.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import my.mvppokemon.R
import my.mvppokemon.databinding.FragmentHomeBinding
import my.mvppokemon.storage.getPokemons

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null
    private val b get() = binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val adapter = HomeAdapter()

        b.rvContainer.adapter = adapter
        b.rvContainer.layoutManager = GridLayoutManager(requireContext(), 2)

        adapter.setItems(getPokemons())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}