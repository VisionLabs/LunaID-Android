package ai.visionlabs.examples.camera.ui.main

import ai.visionlabs.examples.camera.databinding.FragmentMainBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.stateLiveData.observe(this) {
            updateUi(it)
        }
    }

    private fun updateUi(s: MainViewState) {
        when (s) {
            is MainViewState.Init -> {} // noop
            is MainViewState.Image -> {
                renderImage(s)
                renderVideoPath(s.videoPath)
            }
            is MainViewState.Error -> {
                renderError(s)
            }
            is MainViewState.Cancelled -> {
                renderVideoPath(s.videoPath)
            }
        }
    }

    private fun renderVideoPath(videoPath: String?) {
        binding.videoFilePath.isVisible = videoPath != null

        if (videoPath != null) {
            val t = "Video session path:\n$videoPath"
            binding.videoFilePath.text = t
        }
    }

    private fun renderError(s: MainViewState.Error) {
        Log.d("@@@@@", "error: ${s.message}")
    }

    private fun renderImage(s: MainViewState.Image) {
        binding.bestShotImage.setImageBitmap(s.image.warp)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        with(binding) {
            showCameraWithDetection.setOnClickListener {
                viewModel.onShowCameraWithDetectionClicked(requireActivity())
            }
            showCameraWithFrame.setOnClickListener {
                viewModel.onShowCameraWithFrameClicked(requireActivity())
            }
            showCameraAndRecordVideo.setOnClickListener {
                viewModel.onShowCameraAndRecordVideo(requireActivity())

            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}