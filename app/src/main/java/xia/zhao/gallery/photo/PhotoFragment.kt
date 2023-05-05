package xia.zhao.gallery.photo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class PhotoFragment : Fragment() {

    private lateinit var photoView: PhotoView
    private lateinit var photoViewModel: PhotoViewModel

    companion object {
        val TAG = PhotoFragment::class.java.simpleName
        fun newInstance() = PhotoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        photoView = PhotoView(requireContext())
        return photoView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoViewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)
        photoViewModel.photoUiModel.observeForever {
            Log.d(TAG, "ui mode: $it")
            when (it) {
                PhotoUiLoading -> photoView.showProgressBar()
                PhotoUiLoaded -> photoView.hideProgressBar()
            }
        }

        MainScope().launch {
            photoViewModel.loadLocalPhotos()
        }
    }
}
