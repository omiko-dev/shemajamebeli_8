package com.example.shemajamebeli_8.presentation.screen.place

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.shemajamebeli_8.databinding.FragmentPlaceBinding
import com.example.shemajamebeli_8.presentation.adapter.PlaceCardAdapter
import com.example.shemajamebeli_8.presentation.base.BaseFragment
import com.example.shemajamebeli_8.presentation.screen.place.event.PlaceEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.math.abs

@AndroidEntryPoint
class PlaceFragment : BaseFragment<FragmentPlaceBinding>(FragmentPlaceBinding::inflate) {
    private val viewModel: PlaceViewModel by viewModels()
    private lateinit var placeCardAdapter: PlaceCardAdapter

    override fun listener() {
        viewModel.onEvent(PlaceEvent.GetPlaceList)
    }

    override fun observe() {
        observePlaceList()
    }

    override fun event() {
        viewModel.onEvent(PlaceEvent.GetPlaceList)
    }

    override fun bind() {
        bindPlaceCardAdapter()
    }

    private fun bindPlaceCardAdapter() {
        placeCardAdapter = PlaceCardAdapter()
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, pos ->
            val r = 1 - abs(pos)
            page.scaleY = 0.85f + r + 0.14f
        }

        binding.vpCard.apply {
            adapter = placeCardAdapter
            offscreenPageLimit = 3
            clipToPadding = false
            clipChildren = false
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            setPageTransformer(transformer)
        }
    }

    private fun observePlaceList() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.placeListStateFlow.collect {
                    placeCardAdapter.submitList(
                        it.success
                    )
                }
            }
        }
    }
}