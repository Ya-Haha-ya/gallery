package xia.zhao.gallery.photo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PhotoViewModel(application: Application) : AndroidViewModel(application) {

    private val _photoUiModel: MutableLiveData<PhotoUiModel> = MutableLiveData(PhotoUiLoading)
    val photoUiModel: LiveData<PhotoUiModel> = _photoUiModel

    suspend fun loadLocalPhotos() {
        // TODO: Implement load photos from local and update the photoUiModel
        withContext(Dispatchers.IO) {
            delay(5000)
            _photoUiModel.postValue(PhotoUiLoaded)
        }
    }

}
